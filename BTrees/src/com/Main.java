package com;

import java.util.*;

public class Main 
{
    public static void main(String[] args) {

        LeafNode leafOne = new LeafNode(new ArrayList<Integer>(Arrays.asList(26, 27, 28, 29, 40, 50)));
        LeafNode leafTwo = new LeafNode(new ArrayList<Integer>(Arrays.asList(1, 5, 10, 20, 24)));        
        LeafNode leafThree = new LeafNode(new ArrayList<Integer>(Arrays.asList(56, 70, 80, 81, 82)));

        RootNode rootThree = new RootNode(0, 25, new ArrayList<Node>(Arrays.asList(leafTwo)));
        RootNode rootOne = new RootNode(0, 50, new ArrayList<Node>(Arrays.asList(rootThree, leafOne)));
        RootNode rootTwo = new RootNode(51, 100, new ArrayList<Node>(Arrays.asList(leafThree)));


        RootNode head = new RootNode(0, 100, new ArrayList<Node>(Arrays.asList(rootOne, rootTwo)));

        //Head Node contains entire range and a list of Nodes.
        if (searchRoot(1, head.getList())) {
            System.out.println("Success!");
        }

        if (searchRoot(7, head.getList())) {
            System.out.println("Success! (2)");
        }

    }

    public static boolean searchRoot(int toBeSearched, ArrayList<Node> search) {

        //System.out.println("Running search. List Size = " + search.size());

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
        
        if (search.size() == 0) return false;

        else return searchRoot(toBeSearched, search);
    }



    public static boolean searchLeaf(int toBeSearched, ArrayList<Integer> searchList) {

        if (searchList.size() == 0) return false;

        if (searchList.get(0) == toBeSearched) return true;

        searchList.remove(0);

        return searchLeaf(toBeSearched, searchList);

    }
}