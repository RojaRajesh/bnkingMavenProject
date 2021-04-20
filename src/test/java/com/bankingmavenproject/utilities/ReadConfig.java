package com.bankingmavenproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties prop;
	public ReadConfig() 
	{
		//it is used to config the 
		try {
		File fil=new File("E:\\workspace\\BnkingMavenProject\\configuration\\config.properties");
			FileInputStream fis=new FileInputStream(fil);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public String getApplicationUrl()
		{
			String url=prop.getProperty("baseUrl");
			return url;
		}
		public String getUserName()
		{
			String username=prop.getProperty("username");
			return username;
		}
		public String getPassword()
		{
			String password=prop.getProperty("password");
			return password;
		}
		
		public String getChrome()
		{
			String chrome=prop.getProperty(" chromepath");
			return chrome;
		}
		public String getie()
		{
			String ie=prop.getProperty(" iepath");
			return ie;
		}
		public String getfirefox()
		{
			String firefox=prop.getProperty(" firefoxpath");
			return firefox;
		}
	
	

}
