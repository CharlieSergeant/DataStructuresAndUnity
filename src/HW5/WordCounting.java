package HW5;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounting
{
	MyHashMap<String, Integer> itr = new MyHashMap<>();
	MyHashSet<String> keywords = new MyHashSet<>(Arrays.asList("package","import","public",
			"class","this","void","private","new","static","try","catch",
			"if","else","while","switch","for","interface","abstract"
			,"protected","throws","extends","implements"));
	String filename;
	WordCounting()
	{
		
	}
	
	WordCounting(String inputfile)
	{
		this.filename = inputfile;
	}
	
	private void scanFile()
	{
		File f = new File(this.filename);
		try 
		{
			Scanner input = new Scanner(f);
			while(input.hasNext())
			{
				String s = input.next();
				if(keywords.contains(s))
				{
					if(itr.containsKey(s))
					{
						int c = itr.get(s);
						c++;
						itr.put(s, new Integer(c));
					}
					else
					{
						itr.put(s, 1);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
private void sortByValue()
{
	TreeMap<Integer, String> tm = new TreeMap<>();
	for(MyMap.Entry<String, Integer> ent: itr.entrySet())
	{
		tm.put(ent.getValue(), ent.getKey());
	}
	itr = new MyHashMap<>();
	for(Map.Entry<Integer, String>ent: tm.entrySet())
	{
		itr.put(ent.getValue(),ent.getKey());
	}
}

private void printCount()
{
	for(MyMap.Entry<String, Integer> ent: itr.entrySet())
	{
		System.out.println(ent.getKey()+"|"+ent.getValue());
	}

}
public static void main(String []args)
{
	WordCounting wc = new WordCounting("WordCounting.java");
	wc.scanFile();
	wc.sortByValue();
	wc.printCount();
}
}
