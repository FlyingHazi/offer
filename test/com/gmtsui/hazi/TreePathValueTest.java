package com.gmtsui.hazi;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Hazi
 * Date: 13-10-23
 * Time: 上午12:26
 * To change this template use File | Settings | File Templates.
 */
public class TreePathValueTest {
    final private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintStream original;

    @BeforeMethod
    public void setUp() throws Exception {
        original = System.out;
        System.setOut(new PrintStream(out));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.setOut(original);
        try {
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindPath() throws Exception {
        Set<String> set = new HashSet<String>();
        set.add("12,10,");
        set.add("7,5,10,");
        Set<String> re = new HashSet<String>();
        TreePathValue.TreeNode root = new TreePathValue.TreeNode(10);
        root.leftChild = new TreePathValue.TreeNode(5);
        root.rightChild = new TreePathValue.TreeNode(12);
        root.leftChild.leftChild = new TreePathValue.TreeNode(4);
        root.leftChild.rightChild = new TreePathValue.TreeNode(7);
        TreePathValue.findPath(root, 22);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s = null;
        try {
            while (null != (s = br.readLine())) {
                re.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(set.size(), re.size());
        for (String ss : re) {
            Assert.assertTrue(set.contains(ss));
        }
    }
}
