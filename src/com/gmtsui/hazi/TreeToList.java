package com.gmtsui.hazi;

public class TreeToList
{
    public static class Node
    {
    	public Node(int data)
    	{
    		this.data = data;
    	}
        public Node leftChild;
        public Node rightChild;
        public int data;
    }
    public static Node treeToList(Node root)
    {
        if(null == root)
        {
            return null;
        }
        link(root,null);
        while(null != root.leftChild)
        {
            root = root.leftChild;
        }
        return root;
    }
    private static Node link(Node current,Node prev)
    {
        if(null == current)
        {
            return null;
        }
        //convert leftchild
        if(null != current.leftChild)
        {
            prev = link(current.leftChild,prev);
        }
        //link current node
        current.leftChild = prev;
        if(null != prev)
        {
            prev.rightChild = current;
        }
        //convert rightchild
        if(null != current.rightChild)
        {
            prev = link(current.rightChild,current);
        }else
        {
            prev = current;
        }
        return prev;
    }
}
