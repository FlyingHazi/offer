package com.gmtsui.hazi;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Hazi
 * Date: 13-10-23
 * Time: 上午12:26
 * To change this template use File | Settings | File Templates.
 */
public class PermutationTest {
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
    public void testPermutation() throws Exception {


        Set<String> set = new HashSet<String>(Arrays.asList("abc", "bac", "cba", "acb", "bca",
                "cab"));
        Set<String> re = new HashSet<String>();
        Permutation.permutation("abc");
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
        Assert.assertSame(set.size(), re.size());
        for (String ss : re) {
            Assert.assertTrue(set.contains(ss));
        }
    }
}
