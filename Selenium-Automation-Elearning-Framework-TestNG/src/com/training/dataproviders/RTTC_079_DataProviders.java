package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class RTTC_079_DataProviders {
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\IBM_Selenium_Project\\TestData_079.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName, fileName); 
	}

}
