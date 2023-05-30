package TestVagrant;

import java.util.LinkedList;
import java.util.Scanner;

import org.testng.annotations.Test;

public class TestVagrantSongList
{
	static String s;
	static LinkedList<String>l=new LinkedList<>();
	static void Default()
	{
		l.remove(2);
		l.remove(1);
		l.remove(0);
		l.add("S1");
		l.add("S2");
		l.add("S3");
	}
	static void repeat(LinkedList<String> l)
	{
		int b=0;
		for(Object a:l)
		{
			System.out.print(a);
			b++;
			if(b<3)
				System.out.print(',');
			else if(b==3)
				System.out.println();
		}
	}
	static void song1(LinkedList<String> l)
	{
		System.out.print("For the Song S1 the playlist is \n");
		l.remove("S3");
		l.remove("S2");
		l.add(0,"S4");
		l.add(1,"S2");
		repeat(l);
		Default();
	}
	static void song2(LinkedList<String> l)
	{
		System.out.print("For the Song S2 the playlist is \n");
		l.remove("S1");
		l.remove("S2");
		l.add("S4");
		l.add("S2");
		repeat(l);
		Default();
	}
	static void song4(LinkedList<String> l)
	{
		System.out.print("For the Song S4 the playlist is \n");
		l.remove("S1");
		l.add("S4");
		repeat(l);
		Default();
	}
	static void defaultPlaylist(LinkedList<String> l)
	{
		l.remove(2);
		l.remove(1);
		l.remove(0);
		l.add("S1");
		l.add("S2");
		l.add("S3");
		if(s!="S4"&&s!="S2"&&s!="S1")
		{
			System.out.println("Invalid song selection so the default playlist is ");
			repeat(l);
		}
	}
	@Test
	public void tc()
	{	
		l.add("S1");
		l.add("S2");
		l.add("S3");
		Scanner sc =new Scanner(System.in);
		for(;;)
		{
			System.out.println("Enter the song as S1 or S2 or S3 only: ");
			s=sc.next();
			switch(s)
			{
			case "S1":song1(l);
			break;
			case "S2":song2(l);
			break;
			case "S4":song4(l);
			break;
			default:defaultPlaylist(l);
			break;
			}
		}
	}
}


