package com.smart;

public class Test
{
    public static int aMethod(int i)throws Exception
    {
        try{
            return i / 10;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }

    public static void main(String [] args)
    {
        try
        {
            System.out.println(aMethod(0));
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
}
