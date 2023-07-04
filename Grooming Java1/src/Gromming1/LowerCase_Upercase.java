package Gromming1;

public class LowerCase_Upercase
{
	static char ch;
public static void main(String[] args)
{
	
	String s1 = "jAvA";
	String s2="";
	for(int i=0; i<s1.length(); i++)
	{
		 ch = s1.charAt(i);
	}
	if((ch>=97) && (ch<=122))
	{
		s2=s2+(char)(ch-32);
	}
	else
	{
		s2=s2+(char)(ch+32);
	}
}
}
