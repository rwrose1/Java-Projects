package com;

import java.util.*;

class LeafNode extends Node {

    ArrayList<Integer> integerList;

    public LeafNode(Collection<Integer> values) {

        integerList = new ArrayList<Integer>();

        integerList.addAll(values);

    }

    public ArrayList<Integer> getList() {
        return integerList;
    }

}