package com.bankingmavenproject.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	
	
	public void startReport(ITestContext  textcontext){
		
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		String repname="Test-Report"+timestamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-ouput/"+repname);
		
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Roja");
		
		htmlReporter.config().setDocumentTitle("Bnking Maven Project");//title of the report
		htmlReporter.config().setReportName("Fuctional Test Report");//name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
		
	
	public void passTest(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());//create the new entry in the report
		Assert.assertTrue(true);
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//send the passsed information
	}
	
	
	public void failTest( ITestResult tr ){
		logger = extent.createTest("failTest");
		Assert.assertTrue(false);
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
        String screenshot=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
        File f=new File(screenshot);
        if(f.exists())
        {
        	try {
        		logger.fail("screenshot is below"+logger.addScreenCaptureFromPath(screenshot));
        	}
        	catch(IOException e)
        	{
        	e.printStackTrace();	
        	}
        }
        }
	
	
	public void OnTestSkipTest(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	}
	
	
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));	
		}
	}
	
	public void endReport(ITestContext contex){
		extent.flush();
    }
}
