package com.bankingmavenproject.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XUtils
{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getrowcount(String xlfile, String xlSheet) throws IOException
	{
		
			fis=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fis);
			ws=wb.getSheet(xlSheet);
			int rowcount=ws.getLastRowNum();
			wb.close();
			fis.close();
			return rowcount;
	}
	
	public static int getcellcount(String xlfile,String xlSheet,int rownum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlSheet);
		int  cellcount=ws.getLastRowNum();
		wb.close();
		fis.close();
		return cellcount;
		
		
		
	}

	public static String getcelldata(String xlfile,String xlSheet,int rownum,int cellnum) throws IOException
	{
		int retval=0;
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlSheet);
		retval  =ws.getLastRowNum();
		wb.close();
		fis.close();
		return xlSheet;
		
	}
}
			
		
		
		
		
	
		
	
	


