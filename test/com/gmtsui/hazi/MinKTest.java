package com.gmtsui.hazi;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Hazi
 * Date: 13-10-23
 * Time: 下午12:58
 * To change this template use File | Settings | File Templates.
 */
public class MinKTest {
    @Test
    public void testMinK() throws Exception {
        Integer a[] = {10,9,8,7,6,5,4,3,2,1};
        Integer b[] = {1,2,3,4};
        Integer c[] = MinK.minK(a,4);
        Arrays.sort(c);
        Assert.assertTrue(Arrays.equals(b,c));
    }
}
