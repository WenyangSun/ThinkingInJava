package com.ietree.base.io.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String>
{
    private static final long serialVersionUID = 1L;

    public static String read(String fileName)
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            String s;
            try
            {
                while ((s = in.readLine()) != null)
                {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                in.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void write(String fileName, String text)
    {
        try
        {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try
            {
                out.print(text);
            }
            finally
            {
                out.close();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public TextFile(String fileName, String splitter)
    {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals(""))
        {
            remove(0);
        }
    }

    public TextFile(String fileName)
    {
        this(fileName, "\n");
    }

    public void write(String fileName)
    {
        try
        {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try
            {
                for (String item : this)
                {
                    out.println(item);
                }
            }
            finally
            {
                out.close();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        String file = read("TextFile.java");
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        TreeSet<String> words = new TreeSet<String>(new TextFile("TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
