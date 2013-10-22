package com.gmtsui.hazi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Hazi
 * Date: 13-10-23
 * Time: 上午12:26
 * To change this template use File | Settings | File Templates.
 */
public class TreeToListTest {
    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testTreeToList() throws Exception {
        int[] a = { 10, 6, 14, 4, 8, 12, 16 };
        int[] b = { 4, 6, 8, 10, 12, 14, 16 };
        int[] c = { 16, 14, 12, 10, 8, 6, 4 };
        int[] tmp = new int[7];
        TreeToList.Node root = creatTree(a);
        root = TreeToList.treeToList(root);
        TreeToList.Node node = root;
        for (int i = 0; node != null; node = node.rightChild,i++) {
            tmp[i] = node.data;
        }
        Assert.assertTrue(Arrays.equals(b, tmp));
        node = root;
        while (null != node.rightChild) {
            node = node.rightChild;
        }
        for (int i = 0; node != null; node = node.leftChild,i++) {
            tmp[i] = node.data;
        }
        Assert.assertTrue(Arrays.equals(c, tmp));
    }
    private TreeToList.Node creatTree(int[] data) {
        List<TreeToList.Node> nodeList = new ArrayList<TreeToList.Node>();
        for (int each : data) {
            TreeToList.Node node = new TreeToList.Node(each);
            nodeList.add(node);
        }
        int lastRootIndex = data.length / 2 - 1;
        for (int i = lastRootIndex; i >= 0; i--) {
            int leftIndex = i * 2 + 1;
            TreeToList.Node root = nodeList.get(i);
            TreeToList.Node left = nodeList.get(leftIndex);
            root.leftChild = left;
            if (leftIndex + 1 < data.length) {
                TreeToList.Node right = nodeList.get(leftIndex + 1);
                root.rightChild = right;
            }
        }
        TreeToList.Node head = nodeList.get(0);
        return head;

    }
}
