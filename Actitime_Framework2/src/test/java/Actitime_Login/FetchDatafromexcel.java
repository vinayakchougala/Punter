package Actitime_Login;

import java.io.IOException;

import Aldi_generic_utility.ExcelUtlity;
import Aldi_generic_utility.FileUtlity;

public class FetchDatafromexcel
{  
	public static void main(String[] args) throws IOException, Throwable
	{
	   FileUtlity Flib = new FileUtlity();
	   ExcelUtlity Elib =new ExcelUtlity();
	  	 
	  	 
	  	 
	   String TEST_SCRIPT_EXCEL_FILE_PATH = Flib.getFilePathFromPropertiesFile("TestScriptdatafilePath");
	    System.out.println( TEST_SCRIPT_EXCEL_FILE_PATH);
	    String data = Elib.getDataFromExcel(TEST_SCRIPT_EXCEL_FILE_PATH, "lims", 1, 3);
	    System.out.println(data);

	    String data1 = Elib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "lims", "tc_01","Client_id" );
         System.out.println(data1);

 	    String data2= Elib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "lims", "tc_01","client_name" );
          System.out.println(data2);
}
}
