package org.example.karthick;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBT {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            List<Integer> level = new ArrayList<>();

            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                if(node != null){
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if(!level.isEmpty()){
                res.add(level);
            }

        }

        return res;
    }

    public void printInOrder(TreeNode node){
        if(node == null)
            return;

        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public void printPreOrder(TreeNode node){
        if(node == null)
            return;

        System.out.println(node.val + " ");
        printInOrder(node.left);
        printInOrder(node.right);
    }

    public void printPostOrder(TreeNode node){
        if(node == null)
            return;

        printInOrder(node.left);
        printInOrder(node.right);
        System.out.println(node.val + " ");
    }
}
