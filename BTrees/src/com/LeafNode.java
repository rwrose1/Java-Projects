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

    /*public boolean search(int toBeSearched, int index) {
        
        if (index >= nodeList.size()) return false;

        if (toBeSearched == nodeList.get(index)) return true;

        return search(toBeSearched, ++index);

    }*/

}