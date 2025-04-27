package com.panopticode.algorithms.stringmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class RabinKarpMatcher extends AbstractStringMatcher {
    private final Alphabet alphabet;

    public RabinKarpMatcher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public List<Integer> _match(final String text,
                                final String pattern) {
        if (this.alphabet.notSupported(text) || this.alphabet.notSupported(pattern)) {
            throw new IllegalArgumentException("Invalid text for alphabet " + this.alphabet);
        }

        var n = text.length();
        var m = pattern.length();
        var d = this.alphabet.getSize();
        var q = this.alphabet.getMod();
        var it = transform(text);
        var ip = transform(pattern);

        var result = new ArrayList<Integer>();
        var h = modularPow(d, m - 1, q);
        var p = 0;
        var t = 0;

        // pre-processing (use Horner's Rule)
        for (int i = 0; i < m; ++i) {
            p = ((d % q * p % q) + ip[i] % q) % q;
            t = ((d % q * t % q) + it[i] % q) % q;
        }

        // matching
        for (int i = 0; i <= n - m; ++i) {
            if (p == t) { // potential hit
                if (Arrays.equals(ip, 0, m, it, i, i + m)) {
                    result.add(i);
                }
            }

            if (i < n - m) { // skip last cycle
                // update shift - use floorMod because the '%' operator is the remainder operator, not the modulus
                // ie '%' can return negative values, where the modulus q is always in [0, q-1]
                t = Math.floorMod((d * (t - it[i] * h)) + it[i + m], q);
            }
        }

        return Collections.unmodifiableList(result);
    }

    private int[] transform(final String s) {
        var is = new int[s.length()];

        switch (this.alphabet) {
            case ALPHA:
                for (int i = 0; i < s.length(); ++i) {
                    is[i] = Character.getNumericValue(s.charAt(i)) - 10;
                }
                break;
            case DIGIT:
                for (int i = 0; i < s.length(); ++i) {
                    is[i] = Character.getNumericValue(s.charAt(i));
                }
                break;
        }

        return is;
    }

    /**
     * Compute ans = b^e mod m, that is Math.pow(d, m-1) mod q.
     * This operation is optimised to perform the modulo on every multiplication,
     * using the distributive property of modulus arithmetic:
     *   ab mod n = [(a mod n) * (b mod n)] mod n
     *
     * @param b mantissa
     * @param e power
     * @param m modulus
     * @return d^(m-1) mod q
     */
    private int modularPow(final int b, final int e, final int m) {
        if (m == 1) {
            return 0;
        }

        var c = 1;

        for (int i = 0; i < e; ++i) {
            c = ((c % m) * (b % m)) % m;
        }

        return c;
    }

    public enum Alphabet {
        ALPHA("[a-z]*", 26, 19),
        DIGIT("[0-9]*", 10, 13);

        private final String regex;
        private final int size;
        private final int mod;

        Alphabet(String regex, int size, int mod) {
            this.regex = regex;
            this.size = size;
            this.mod = mod;
        }

        public boolean notSupported(final String text) {
            return !Pattern.matches(regex, text);
        }

        public int getSize() {
            return size;
        }

        public int getMod() {
            return mod;
        }
    }
}
