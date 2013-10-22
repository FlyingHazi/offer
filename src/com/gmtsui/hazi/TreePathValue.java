package com.gmtsui.hazi;

import java.util.List;
import java.util.LinkedList;

public class TreePathValue {
	public static class TreeNode {
		public TreeNode(int data) {
			this.data = data;
		}

		public int data;
		public TreeNode leftChild;
		public TreeNode rightChild;
	}

	public static void findPath(TreeNode root, int all) {
		List<Integer> list = new LinkedList<Integer>();
		findPath(root, all, list);
	}

	private static void findPath(TreeNode root, int cur, List<Integer> list) {
		if (null == root) {
			if (0 == cur) {
				for (int i : list) {
					System.out.print(i + ",");
				}
				System.out.println();
			}
			return;
		}
		list.add(0, root.data);
		findPath(root.leftChild, cur - root.data, list);
		findPath(root.rightChild, cur - root.data, list);
		list.remove(0);
	}
}
