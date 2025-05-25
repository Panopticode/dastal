package com.panopticode.datastructures;

public class DisjointSet {
    private final int size;
    private final Integer[] parent;
    private final int[] rank;
    private int components;

    // Constructor to initialize the UnionFind data structure
    public DisjointSet(int size) {
        this.size = size;
        parent = new Integer[size];
        rank = new int[size];
        components = 0;
    }

    // Find operation with path compression
    public Integer find(int p) {
        if (p < 0 || p >= size) {
            throw new IllegalArgumentException("Invalid index: " + p);
        }

        if (parent[p] == null) {
            return -1;
        }

        if (parent[p] != p) {
            parent[p] = find(parent[p]);  // Path compression
        }
        return parent[p];
    }

    // Union operation with union by rank
    public void union(int p, int q) {
        if (p >= size || q > size) {
            return;
        }

        int rootP = find(p);
        int rootQ = find(q);

        // If they are already in the same set, do nothing
        if (rootP == rootQ) {
            return;
        }

        // Union by rank: attach the smaller tree under the larger tree
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        components--;
    }

    public void add(int p) {
        if (p < 0 || p >= size) {
            return;
        }

        if (parent[p] == null) {
            parent[p] = p;
            components++;
        }
    }

    public int components() {
        return components;
    }
}
