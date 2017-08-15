package com.ysk.workhard;
import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
}

public class PrintList {
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre.length == 0||in.length == 0){
			return null;
		} 
		//前序遍历是中-左-右  中序是左-中-右  后序是左-右-中
		//根据前序遍历，第一个值为根节点
		TreeNode node = new TreeNode(pre[0]);
		//copyOfRange(int[] original, int from, int to) 包括from但是不包括to
        // 将指定数组的指定范围复制到一个新数组。
		for(int i = 0; i < in.length; i++){
			if(pre[0] == in[i]){
				//递归
				//从前序遍历入手，找到根节点，将序列一分为二，每一部分的第一个就是一个父节点
				node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
				node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
			}
		}
		return node;
	}
	public static void main(String[] args) {
		int pre[] = new int[]{1,2,4,7,3,5,6,8};
		int in[] = new int[]{4,7,2,1,5,3,8,6};
	}
}
