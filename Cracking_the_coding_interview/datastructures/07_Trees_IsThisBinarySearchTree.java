// Trees: Is This a Binary Search Tree?
// https://www.hackerrank.com/challenges/ctci-is-binary-search-tree

/*
The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

boolean checkBST(Node root) {
    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

boolean checkBST(Node node, int min, int max){
    if(node == null)
        return true;
    if(node.data <= min || node.data >= max)
        return false;

    return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
}
