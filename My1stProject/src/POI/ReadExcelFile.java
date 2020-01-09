package POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException
	{
		 File file = new File(filePath+"\\"+fileName);
		 FileInputStream inputStram = new FileInputStream(file);
		 Workbook MyWorkBook = null;
		 String fileExtensionName = fileName.substring(fileName.indexOf("."));
		 
		 if(fileExtensionName.equals(".xlsx"))
		 {
			 MyWorkBook = new XSSFWorkbook(inputStram);
		 }
		 else if (fileExtensionName.equals(".xls"))
		 {
			 MyWorkBook = new XSSFWorkbook(inputStram);
		 }
		 
		 Sheet mySheet = MyWorkBook.getSheet(sheetName);
		 
		 int rowCount = mySheet.getLastRowNum()-mySheet.getFirstRowNum();
		 
		 for (int i = 0; i < rowCount+1; i++)
			 
		 {
			 Row row = mySheet.getRow(i);
			 for (int j = 0; j < row.getLastCellNum(); j++)
			 {	 
				 System.out.print(row.getCell(j).getStringCellValue()+"|| ");				 
			 }
			 
			 System.out.println();
		 }
	}
	

	public static void main(String org[]) throws IOException
	{
		
		ReadExcelFile objExcelFile1 = new ReadExcelFile();
		//String filePath = System.getProperty("user.dir", "\\src\\excelExportAndFileIO");
		
		objExcelFile1.readExcel("C://Users//ADMIN//Desktop","DataFile.xlsx","ExcelDemo");
		
	}

}
