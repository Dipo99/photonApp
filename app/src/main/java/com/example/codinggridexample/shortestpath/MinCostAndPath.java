package com.example.codinggridexample.shortestpath;

/**
 * Created by chayanchowdhury on 27/08/17.
 */

class MinCostAndPath {
    public final boolean canCross;
    public final int cost;
    public final String path;
    public MinCostAndPath(boolean canCross, int cost, String path) {
        this.canCross = canCross;
        this.cost = cost;
        this.path = path;
    }
}
