package com;

import java.util.*;
import com.SearchFunctions;

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

        SearchFunctions.search(5, head);
        SearchFunctions.search(28, head);
        SearchFunctions.search(80, head);

        SearchFunctions.search(71, head);
        SearchFunctions.search(30, head);
        SearchFunctions.search(6, head);

    }

}
