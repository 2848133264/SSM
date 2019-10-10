package com.pojo.utils;

import java.util.ArrayList;
import java.util.List;

public class JsonFactory {

	/**
	 * 采用递归调用这个方法，从而的到这children 属性值
	 * @param nodes
	 * @param id
	 * @return
	 */
	public static List<TreeNode> buildtree(List<TreeNode> nodes, int id) {
		List<TreeNode> treeNodes =new ArrayList<TreeNode>();
		System.out.println("JsonFactory --> nodes:"+nodes.size());
		
		for (TreeNode treeNode : nodes) {//  1 
			TreeNode node =new TreeNode();
			node.setId(treeNode.getId());
			node.setText(treeNode.getText());
			if(id == treeNode.getFid()){
				// 调用builtdtree 方法给这个treennode 中的children属性赋值,没有找到
				node.setChildren(buildtree(nodes, node.getId()));
				treeNodes.add(node);
			}
		}
		System.out.println("......");
		return treeNodes;
	}
	
}
