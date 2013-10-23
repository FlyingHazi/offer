package com.gmtsui.hazi;

import java.util.Arrays;

public class MinK
{
    public static <T extends Comparable<? super T>> T[] minK(T a[],int k)
    {
        if(a.length <= k)
        {
            return Arrays.copyOf(a, a.length);
        }
        for(int i=k;i>=0;i--)
        {
            swapDown(a,i,k);
        }
        for(int i=k+1;i!=a.length;i++)
        {
            a[0] = a[i];
            swapDown(a,0,k);
        }
        return Arrays.copyOf(a,k);
    }

    private static <T extends Comparable<? super T>> void swap(T a[],int x,int y)
    {
        T tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private static int leftChild(int father)
    {
        return 2*father+1;
    }
    private static <T extends Comparable<? super T>> void swapDown(T a[],int i,int k)
    {
        for(int child = leftChild(i);child < k;i = child,child = leftChild(i))
        {
            if(child != k-1 && 0 > a[child].compareTo(a[child+1]))
            {
                child++;
            }
            if(0 > a[i].compareTo(a[child]))
            {
                swap(a,i,child);
            }else
            {
                break;
            }
        }
    }
}
