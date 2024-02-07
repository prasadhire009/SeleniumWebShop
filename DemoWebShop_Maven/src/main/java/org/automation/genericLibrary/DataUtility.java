package org.automation.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {
public String getDataFromProperties(String key) throws IOException {
	FileInputStream fileInputStream=new FileInputStream(FrameWorkConstants.properties_path);
	Properties pobj=new Properties();
	pobj.load(fileInputStream);
	
	return pobj.getProperty(key);
}

public String getDataFromExcel(String sheetname, int rownum , int cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream fileInputStream=new FileInputStream(FrameWorkConstants.excel_path);
	Workbook book = WorkbookFactory.create(fileInputStream);
	Sheet sh = book.getSheet(sheetname);
	return sh.getRow(rownum).getCell(cellnum).toString();
}

public Object[][] getMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException {
	FileInputStream fileInputStream = new FileInputStream(FrameWorkConstants.excel_path);
	
			Workbook book = WorkbookFactory.create(fileInputStream);
	
			Sheet sh = book.getSheet(sheetname);
			int lastRownum = sh.getPhysicalNumberOfRows();
			int lastCellnum = sh.getRow(0).getPhysicalNumberOfCells();
			
			Object [][] arr=new Object[lastRownum-1][lastCellnum];
			
			for (int i = 1; i < lastRownum; i++) {
				for (int j = 0; j < lastCellnum; j++) {
					arr[i-1][j]=sh.getRow(i).getCell(j).toString();
				}
}
			return arr;
}
}
