package com;

import java.util.*;

public class RootNode extends Node {

    private int min;
    private int max;

    ArrayList<Node> nodeList;

    public RootNode(int min, int max, Collection<Node> nodes) {
        this.min = min;
        this.max = max;
        nodeList = new ArrayList<Node>();
        nodeList.addAll(nodes);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public ArrayList<Node> getList() {
        return nodeList;
    }

}