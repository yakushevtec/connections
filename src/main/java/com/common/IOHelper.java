package com.common;
import java.util.*;
import java.io.*;

public class IOHelper
{
	static public String fileToString(String fileName) throws IOException
	{
		String str = "";
		File file = new File(fileName);

		int length = (int)file.length();
		if(length==0)
			return null;
		FileInputStream fr = new FileInputStream(file);
		BufferedInputStream br = new BufferedInputStream(fr, length);
		byte[] ca = new byte[length];
		br.read(ca, 0, length);
		str = new String(ca);
		br.close();
		fr.close();

		return str;
	}

	static public void stringToFile(String fileName, String str, boolean append) throws IOException
	{
		int i = fileName.lastIndexOf(File.separatorChar);
		if (i != -1)
		{
			String dirName = fileName.substring(0, i);
			File dir = new File(dirName);
			if (!dir.exists())
			{
				if (!dir.mkdirs())
					throw new IOException("Cannot create the directory '"+dirName+"'");
			}
		}
		PrintWriter out = new PrintWriter(new FileWriter(fileName, append));
		out.print(str);
		out.flush();
		out.close();
	}

	static public List<String> fileToList(String fileName) throws IOException
	{
		List<String> res=new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null)
			res.add(line);
		return res;
	}

	static public List<String> fileToList(InputStream fis) throws IOException
	{
		List<String> res=new ArrayList<String>();
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null)
			res.add(line);
		return res;
	}

	static public void listToFile(String fileName, List<?> list, boolean append) throws IOException
	{
		int i = fileName.lastIndexOf(File.separatorChar);
		if (i != -1)
		{
			String dirName = fileName.substring(0, i);
			File dir = new File(dirName);
			if (!dir.exists())
			{
				if (!dir.mkdirs())
					throw new IOException("Cannot create the directory '"+dirName+"'");
			}
		}
		File f = new File(fileName);
		FileWriter fw = new FileWriter(fileName, append);
		BufferedWriter bw = new BufferedWriter(fw);
		for(Object o:list)
		{
			bw.write(o.toString());
			bw.newLine();
		}
		fw.flush();
		bw.close();
	}
}
