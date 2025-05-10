package com.panopticode.problems;

import com.panopticode.utils.OneIdxString;
import com.panopticode.utils.Printer;
import com.panopticode.utils.Utils;

public class EditDistance {
    private static boolean debug =  false;

    public static final int COST_C = 2;
    public static final int COST_R = 3;
    public static final int COST_D = 2;
    public static final int COST_I = 2;
    public static final int COST_T = 1;
    public static final int COST_K = 2;

    /**
     * This is the solution to problem 14-5 from Introduction to Algorithms, 4th Ed., by Cormen, Leiserson, Rivest, Stein.
     *
     * @param a the string to edit
     * @param b the target string
     * @return the cost of the least expensive operation sequence
     */
    public static int editDistance(final String a, final String b) {
        var x = new OneIdxString(a);
        var y = new OneIdxString(b);
        var mtx = new int[x.length + 1][y.length + 1];
        int i, j;

        // initialise the first row and column
        for (i = 0; i <= x.length; ++i) {
            mtx[i][0] = i * COST_D;
        }
        for (i = 0; i <= y.length; ++i) {
            mtx[0][i] = i * COST_I;
        }

        // start the main loop
        for (i = 1; i <= x.length; ++i) {
            for (j = 1; j <= y.length; ++j) {
                // consider twiddling
                var qt = Integer.MAX_VALUE;
                if (i > 1 && j > 1) {
                    if (x.at(i - 1) == y.at(j) && x.at(i) == y.at(j - 1)) {
                        qt = mtx[i - 2][j - 2] + COST_T;
                    }
                }

                // consider copying
                var qc = Integer.MAX_VALUE;
                if (x.at(i) == y.at(j)) {
                    qc = mtx[i - 1][j - 1] + COST_C;
                }

                // consider replacing
                var qr = mtx[i - 1][j - 1] + COST_R;

                // consider deleting/inserting
                var qd = mtx[i - 1][j] + COST_D;
                var qi = mtx[i][j - 1] + COST_I;

                var mc = Utils.min(qt, qc, qr, qd, qi);
                mtx[i][j] = mc;
            }
        }

        if (debug) {
            Printer.printTable(mtx, false, ("*" + b).split(""), ("*" + a).split(""));
        }

        return mtx[x.length][y.length];
    }

    public static void setDebug(final boolean debug) {
        EditDistance.debug = debug;
    }
}
