package binarytree;

public class Main {

    public static void main(String[] args) { // 1 2 3 null 4
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(5);
//        binaryTree.add(8);
//        binaryTree.add(7);
//        binaryTree.add(6);
//        binaryTree.add(4);
//        binaryTree.delete(14);
//        binaryTree.traverseInOrder();
        System.out.println("MOHINI:" + binaryTree.traverse(2, 4));
//        System.out.println("Max Sum: " + binaryTree.maxSum());
//        System.out.println("Max Height: " + binaryTree.height());
//        binaryTree.printNodesKDistanceFromRoot(7);
//        int[] pre = {10, 30, 20, 5, 15};
//        char[] preLN = {'N', 'N', 'L', 'L', 'P'};
//        binaryTree.constructTree(5, pre, preLN);
//        binaryTree.traversePreOrder();

//        System.out.println("Count: " + binaryTree.countBstNodesThatLieInAGivenRange(7, 11));
    }
}
