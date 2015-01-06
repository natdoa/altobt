package altobt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SortedLinkedListToBalancedBST<T> {

    private TreeNode<T> root;

    List l(List l1,List l2){
    	
    }
    private static class TreeNode<T> {
        TreeNode<T> left;
        T item;
        TreeNode<T> right;
    };

    public void convert(LinkedList<T> ll) {
        Iterator<T> itr = ll.iterator();
        root = inorder(0, ll.size() - 1, itr);
    }

    private TreeNode<T> inorder(int lb, int hb, Iterator<T> itr) {
        if (lb > hb) return null;
        // same as (lb+hb)/2, avoids overflow
        int mid = lb + (hb - lb) / 2;

        final TreeNode<T> treeNode = new TreeNode<T>();
        treeNode.left = inorder(lb, mid - 1, itr);
        treeNode.item = itr.next();
        treeNode.right = inorder(mid + 1, hb, itr);

        return treeNode;
    }

    public List<T> getInorderList() {
        final List<T> inorderList = new ArrayList<T>();
        inorder(root, inorderList);
        return inorderList;
    }


    private void inorder(TreeNode<T> node, List<T> list) {
        if (node != null) {
            inorder(node.left,  list);
            list.add(node.item);
            inorder(node.right, list);
        }
    }
}


