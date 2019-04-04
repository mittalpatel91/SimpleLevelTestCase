package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.RTTC_076_Bean;
import com.training.dao.RTTC_076_DAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class RTTC_076_DataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RTTC_076_Bean> list = new RTTC_076_DAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RTTC_076_Bean temp : list){
			Object[]  obj = new Object[5]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getOrderid();
			obj[3] = temp.getProduct();
			obj[4] = temp.getQuantity();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
}
