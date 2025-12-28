package Trees;

import java.util.Scanner;

public  class TreeMaster {
    public static void main(String[] args) {

        BinaryTree t = new BinaryTree();

        //  A) Build BST and Data Set
        int[] values = {50, 30, 70, 20, 40, 60, 80,35,45,65};

        for (int v : values)
            t.root = t.insert(t.root, v);


        //B: insert a data enterede for the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int pnum = scanner.nextInt();
        t.root = t.insert(t.root, pnum);


        //Search for the 45 node
        Node searchNd= t.search(t.root,45);
        System.out.println(searchNd.data);


        // Delete the node 30
        t.root = t.delete(t.root, 30);
        System.out.println("After 30 : ");
        t.inorder(t.root);

        t.printTree(t.root);

    }
}