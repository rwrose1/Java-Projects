package com;

import java.util.*;

public class SearchFunctions {

    public static void search(int toBeSearched, RootNode head) {

        if (searchRoot(toBeSearched, head.getList())) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed...");
        }

    }

    public static boolean searchRoot(int toBeSearched, ArrayList<Node> search) {

        //System.out.println("Running search. List Size = " + search.size());

        if (search.size() == 0) return false;

        if (search.get(0) instanceof LeafNode) {
            LeafNode leaf = (LeafNode) search.get(0);
            //System.out.println("Searching Leaf");
            if (searchLeaf(toBeSearched, leaf.getList())) return true;
        
        } else {
           
            RootNode root = (RootNode) search.get(0);
            if (root.getMin() <= toBeSearched && root.getMax() >= toBeSearched)
                return searchRoot(toBeSearched, root.getList());

        }
        
        search.remove(0);

        return searchRoot(toBeSearched, search);
    }



    public static boolean searchLeaf(int toBeSearched, ArrayList<Integer> searchList) {

        if (searchList.size() == 0) return false;

        if (searchList.get(0) == toBeSearched) return true;

        searchList.remove(0);

        return searchLeaf(toBeSearched, searchList);

    }

}