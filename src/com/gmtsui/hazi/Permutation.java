package com.gmtsui.hazi;

public class Permutation
{
    public static void permutation(String s)
    {
        char array[] = s.toCharArray();
        permutation(array,0);
    }

    private static void permutation(char array[], int index)
    {
        if(array.length == index)
        {
            System.out.println(new String(array));
        }
        for(int i=index;i!=array.length;i++)
        {
            swap(array,i,index);
            permutation(array,index+1);
            swap(array,i,index);
        }
    }

    private static void swap(char array[],int x,int y)
    {
        char tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
