package com.cookie.demo2;

import java.util.List;

public interface ITree {
    public List<TreeNode> getTree();
    public List<TreeNode> getRoot();
    public TreeNode getTreeNode(String nodeId);
}
