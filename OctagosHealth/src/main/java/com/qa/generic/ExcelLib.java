package com.qa.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	
	public static final String filePath = ".\\testData\\.....xlsx";
	public static String readExcelData (int rowNum, int cellNum) {
		
		String data = "";
		
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filePath)));
			data = wb.getSheet("sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		}
		
		catch(EncryptedDocumentException e){
			
		}

		catch(FileNotFoundException e){
			
		}
		catch(IOException e){
			
		}
		return data;
		
	}
	
	public static void writeData
	(Sheet s, int rowNum, String S, int Value)
	{
		Row r = s.createRow(rowNum);
		r.createCell(0).setCellValue(S);
		r.createCell(1).setCellValue(Value);
	}
	
	public static String[] toReadExcelData(String sTestCaseID)
	{
		String sData[]=null;
		try
		{
			FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataPayroll.xlsx"));
			Workbook wb =  WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet("Sheet1");
			int iRowNum= sht.getLastRowNum();
			
			for(int i=1; i<=iRowNum; i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new String[iCellNum];
					
					for(int j=0; j<iCellNum; j++)
					{
						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
					}
					
					break;
				}
			}
		
	
		}
		
	catch(EncryptedDocumentException ex){
		ex.printStackTrace();
	}

	catch(IOException ex){
		ex.printStackTrace();
	}
		return sData;
		
     }
	public static String[] toReadExcelData1(String sTestCaseID)
	{
		String sData[]=null;
		try
		{
			FileInputStream fis = new FileInputStream(new File(".\\testData\\testDataSA.xlsx"));
			Workbook wb =  WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet("Sheet1");
			int iRowNum= sht.getLastRowNum();
			
			for(int i=1; i<=iRowNum; i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new String[iCellNum];
					
					for(int j=0; j<iCellNum; j++)
					{
						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
					}
					
					break;
				}
			}
		
	
		}
		
	catch(EncryptedDocumentException ex){
		ex.printStackTrace();
	}

	catch(IOException ex){
		ex.printStackTrace();
	}
		return sData;
		
     }
	public static String[] toReadExcelDataNew(String sTestCaseID)
	{
		String sData[]=null;
		try
		{
			FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataNew.xlsx"));
			Workbook wb =  WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet("Sheet1");
			int iRowNum= sht.getLastRowNum();
			
			for(int i=1; i<=iRowNum; i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new String[iCellNum];
					
					for(int j=0; j<iCellNum; j++)
					{
						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
					}
					
					break;
				}
			}
		
	
		}
		
	catch(EncryptedDocumentException ex){
		ex.printStackTrace();
	}

	catch(IOException ex){
		ex.printStackTrace();
	}
		return sData;
		
     }
	public static String[] toReadExcelDataCRM(String sTestCaseID)
	{
		String sData[]=null;
		try
		{
			FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataCRM.xlsx"));
			Workbook wb =  WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet("Sheet1");
			int iRowNum= sht.getLastRowNum();
			
			for(int i=1; i<=iRowNum; i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new String[iCellNum];
					
					for(int j=0; j<iCellNum; j++)
					{
						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
					}
					
					break;
				}
			}
		
	
		}
		
	catch(EncryptedDocumentException ex){
		ex.printStackTrace();
	}

	catch(IOException ex){
		ex.printStackTrace();
	}
		return sData;
		
     }

	public static String[] toReadExcelDataVat(String sTestCaseID)
	{
		String sData[]=null;
		try
		{
			FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataPayroll.xlsx"));
			Workbook wb =  WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet("VAT");
			int iRowNum= sht.getLastRowNum();
			
			for(int i=1; i<=iRowNum; i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new String[iCellNum];
					
					for(int j=0; j<iCellNum; j++)
					{
						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
					}
					
					break;
				}
			}
		
	}
		
	catch(EncryptedDocumentException ex){
		ex.printStackTrace();
	}

	catch(IOException ex){
		ex.printStackTrace();
	}
		return sData;
		
     }
	
	public static String[] toReadExcelDataCT600(String sTestCaseID)
	{
		String sData[]=null;
		try
		{
			FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataNomisma.xlsx"));
			Workbook wb =  WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet("CT600");
			int iRowNum= sht.getLastRowNum();
			
			for(int i=1; i<=iRowNum; i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new String[iCellNum];
					
					for(int j=0; j<iCellNum; j++)
					{
						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
					}
					
					break;
				}
			}
		
	}
		catch(EncryptedDocumentException ex){
			ex.printStackTrace();
		}

		catch(IOException ex){
			ex.printStackTrace();
		}
			return sData;
			
	     }
	
		public static String[] toReadExcelDataAccounting(String sTestCaseID)
		{
			String sData[]=null;
			try
			{
				FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataNomisma.xlsx"));
				Workbook wb =  WorkbookFactory.create(fis);
				Sheet sht = wb.getSheet("Accounting");
				int iRowNum= sht.getLastRowNum();
				
				for(int i=1; i<=iRowNum; i++)
				{
					if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
					{
						int iCellNum=sht.getRow(i).getLastCellNum();
						sData= new String[iCellNum];
						
						for(int j=0; j<iCellNum; j++)
						{
							sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
						}
						
						break;
					}
				}
			
		}
			
		
	catch(EncryptedDocumentException ex){
		ex.printStackTrace();
	}

	catch(IOException ex){
		ex.printStackTrace();
	}
		return sData;
		
     }
		
		public static String[] toReadExcelDataPayroll(String sTestCaseID)
		{
			String sData[]=null;
			try
			{
				FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataNomisma.xlsx"));
				Workbook wb =  WorkbookFactory.create(fis);
				Sheet sht = wb.getSheet("Payroll");
				int iRowNum= sht.getLastRowNum();
				
				for(int i=1; i<=iRowNum; i++)
				{
					if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
					{
						int iCellNum=sht.getRow(i).getLastCellNum();
						sData= new String[iCellNum];
						
						for(int j=0; j<iCellNum; j++)
						{
							sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
						}
						
						break;
					}
				}
			
		}
			
		
	catch(EncryptedDocumentException ex){
		ex.printStackTrace();
	}

	catch(IOException ex){
		ex.printStackTrace();
	}
		return sData;
		
     }
		
        public static String[] toReadExcelDataBK(String sTestCaseID)
        {
                        String sData[]=null;
                        try
                        {
                                        FileInputStream fis = new FileInputStream(new File(".\\testData\\testDataBookKeeping.xlsx"));
                                        Workbook wb =  WorkbookFactory.create(fis);
                                        Sheet sht = wb.getSheet("Sheet1");
                                        int iRowNum= sht.getLastRowNum();
                                        
                                        for(int i=1; i<=iRowNum; i++)
                                        {
                                                        if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
                                                        {
                                                                        int iCellNum=sht.getRow(i).getLastCellNum();
                                                                        sData= new String[iCellNum];
                                                                        
                                                                        for(int j=0; j<iCellNum; j++)
                                                                        {
                                                                                        sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
                                                                        }
                                                                        
                                                                        break;
                                                        }
                                        }
                        }
                        catch(EncryptedDocumentException ex){
                                        ex.printStackTrace();
                        }

                        catch(IOException ex){
                                        ex.printStackTrace();
                        }
                                        return sData;
                                        
             }
        public static String[] toReadExcelMTRTests(String sTestCaseID)
        {
                        String sData[]=null;
                        try
                        {
                          FileInputStream fis = new FileInputStream(new File(".\\testData\\testDataMTRSA.xlsx"));
                          Workbook wb =  WorkbookFactory.create(fis);
                          Sheet sht = wb.getSheet("Sheet1");
                          int iRowNum= sht.getLastRowNum();                        
                          for(int i=1; i<=iRowNum; i++)
                            {
                              if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
                                 {
                                  int iCellNum=sht.getRow(i).getLastCellNum();
                                  sData= new String[iCellNum];                                                                        
                                  for(int j=0; j<iCellNum; j++)
                                    {
                                     sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
                                    }                                                                        
                                      break;
                                 }
                             }
                        }
                        catch(EncryptedDocumentException ex){
                                        ex.printStackTrace();
                        }

                        catch(IOException ex){
                                        ex.printStackTrace();
                        }
                                        return sData;
                                        
             }
        
        public static String[] toReadExcelDataLiveNomisma(String sTestCaseID)
    	{
    		String sData[]=null;
    		try
    		{
    			FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataNomismaLive.xlsx"));
    			Workbook wb =  WorkbookFactory.create(fis);
    			Sheet sht = wb.getSheet("NomismaReports");
    			int iRowNum= sht.getLastRowNum();
    			
    			for(int i=1; i<=iRowNum; i++)
    			{
    				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
    				{
    					int iCellNum=sht.getRow(i).getLastCellNum();
    					sData= new String[iCellNum];
    					
    					for(int j=0; j<iCellNum; j++)
    					{
    						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
    					}
    					
    					break;
    				}
    			}
    		
    	}
    		catch(EncryptedDocumentException ex){
    			ex.printStackTrace();
    		}

    		catch(IOException ex){
    			ex.printStackTrace();
    		}
    			return sData;
    			
    	     }
        
        public static String[] toReadExcelDataPayroll2(String sTestCaseID)
    	{
    		String sData[]=null;
    		try
    		{
    			FileInputStream fis = new FileInputStream(new File(".\\testData\\TestDataPayroll.xlsx"));
    			Workbook wb =  WorkbookFactory.create(fis);
    			Sheet sht = wb.getSheet("Payroll2");
    			int iRowNum= sht.getLastRowNum();
    			
    			for(int i=1; i<=iRowNum; i++)
    			{
    				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
    				{
    					int iCellNum=sht.getRow(i).getLastCellNum();
    					sData= new String[iCellNum];
    					
    					for(int j=0; j<iCellNum; j++)
    					{
    						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
    					}
    					
    					break;
    				}
    			}
    		
    	}
    		
    	catch(EncryptedDocumentException ex){
    		ex.printStackTrace();
    	}

    	catch(IOException ex){
    		ex.printStackTrace();
    	}
    		return sData;
    		
         }

}
	
	/*public void writeExcelData (int rowNum, int cellNum, String data) throws IOException, InvalidFormatException {

		try{
			
			File file = new File(filePath);
			Workbook wb = WorkbookFactory.create(new FileInputStream(file));
			Cell c = wb.getSheet("sheet1").getRow(rowNum).createCell(cellNum);
			c.setCellType(Cell.CELL_TYPE_STRING);
			FileOutputStream fos = new FileOutputStream(file);
			c.setCellValue(data);
			wb.write(fos);
		}
		catch(EncryptedDocumentException e){
			
		}
		catch(InvalidFormatException e){
			
		}
		catch(FileNotFoundException e){
			
		}
		catch(IOException e){
			
		}*/
		
