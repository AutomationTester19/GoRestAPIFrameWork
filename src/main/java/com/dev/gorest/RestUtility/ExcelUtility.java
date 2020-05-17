package com.dev.gorest.RestUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import com.dev.gorest.BaseRestAPI.BaseRestAPI;

public class ExcelUtility extends BaseRestAPI {

	public static Workbook workbook = null ;
	public static Sheet sheet = null;
	public static Row row = null;
	public static Cell cell = null; 
	public static FileInputStream fis;
	public static String filePath = System.getProperty("user.dir")+"\\Resources\\";
	
	public static void getdatausingHashMap(){
		
		
		
		
	}
	
	
	public static LinkedHashMap<String, LinkedHashMap<String, String>> getexcelDataUsingSheetName(String fileName,String sheetName){
		
		LinkedHashMap<String,LinkedHashMap<String,String>> excelData = new LinkedHashMap<String,LinkedHashMap<String,String>>();
		LinkedHashMap<String,String> innerMap = new LinkedHashMap<String,String>();
		boolean flag = false;
		String key= " ", value = " ";
		try{if(fileName.isEmpty() || fileName==null)Assert.assertNull(fileName);}catch(Exception e){}
		try{fis = new FileInputStream(filePath+fileName);}catch(FileNotFoundException e) {}
		String extension = fileName.substring(fileName.indexOf("."));
		if(extension.contains(".xlsx"))try {workbook = new XSSFWorkbook(fis);} catch (IOException e) {e.printStackTrace();} 
		else if(extension.contains(".xls"))try {workbook = new HSSFWorkbook(fis);} catch (IOException e) {e.printStackTrace();} 
		        sheet = workbook.getSheet(sheetName);
				for(int i=1;i<sheet.getLastRowNum()+1;i++){
					row = sheet.getRow(i);
					key = row.getCell(0).getStringCellValue();
					for(int j=1;j<row.getLastCellNum();j++){
						value = row.getCell(j).getStringCellValue().toString();
						innerMap.put(key, value);
						  flag = true;
                      }
				}	
				if(flag==false)
					Assert.assertNotNull(innerMap);
				else if(flag==true)
				     excelData.put(sheetName, innerMap);
				
				return excelData;
				
			}
			
		
	
}
