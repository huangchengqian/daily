package com.hcq.daily.solution;

import com.hcq.daily.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> cons = new ArrayList<>();
        if (root == null) {
            return cons;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> lev = new ArrayList<>();
            for (int i = 0; i < len; ++i) {
                TreeNode node = queue.removeFirst();
                lev.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            cons.add(lev);
        }
        return cons;
    }

}
