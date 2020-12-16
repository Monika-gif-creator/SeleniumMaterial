package basic;

	import java.io.File;
    import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;


	//How to read excel files using Apache POI
	public class ReadExcel {
		public static void main (String [] args) throws IOException{
	             
			    //I have placed an excel file 'Test.xlsx' in my D Driver 
				FileInputStream fis = new FileInputStream("C:\\Users\\AMBA BISHT\\Desktop\\ExcelGuru99Demo.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheetAt(0);
	            //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
	            //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(0);
	            System.out.println(cell);
		 		System.out.println(sheet.getRow(0).getCell(0)); 
		 		String cellval =cell.getStringCellValue(); 
		 		System.out.println(cellval);
		 		int index =cell.getRowIndex();
		 		System.out.println(index);
		 		
		 			 		
		 		Sheet guru99Sheet = workbook.getSheet("ExcelGuru99Demo");

			    //Find number of rows in excel file

			    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

			    //Create a loop over all the rows of excel file to read it

			    for (int i = 0; i < rowCount+1; i++) {

			        Row rows = guru99Sheet.getRow(i);

			        //Create a loop to print c`ell values in a row

			        for (int j = 0; j < rows.getLastCellNum(); j++) {

			            //Print Excel data in console

			            System.out.print(rows.getCell(j).getStringCellValue()+"|| ");

			        }

			        System.out.println();
			    } 

			    }  
		
	/*
	 * public void readExcel(String filePath,String fileName,String sheetName)
	 * throws IOException{
	 * 
	 * //Create an object of File class to open xlsx file
	 * 
	 * File file = new File(filePath+"\\"+fileName);
	 * 
	 * //Create an object of FileInputStream class to read excel file
	 * 
	 * FileInputStream inputStream = new FileInputStream(file);
	 * 
	 * Workbook guru99Workbook = null;
	 * 
	 * //Find the file extension by splitting file name in substring and getting
	 * only extension name
	 * 
	 * String fileExtensionName = fileName.substring(fileName.indexOf("."));
	 * 
	 * //Check condition if the file is xlsx file
	 * 
	 * if(fileExtensionName.equals(".xlsx")){
	 * 
	 * //If it is xlsx file then create object of XSSFWorkbook class
	 * 
	 * guru99Workbook = new XSSFWorkbook(inputStream);
	 * 
	 * }
	 * 
	 * //Check condition if the file is xls file
	 * 
	 * else if(fileExtensionName.equals(".xls")){
	 * 
	 * //If it is xls file then create object of HSSFWorkbook class
	 * 
	 * guru99Workbook = new HSSFWorkbook(inputStream);
	 * 
	 * }
	 * 
	 * //Read sheet inside the workbook by its name
	 * 
	 * Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
	 * 
	 * //Find number of rows in excel file
	 * 
	 * int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	 * 
	 * //Create a loop over all the rows of excel file to read it
	 * 
	 * for (int i = 0; i < rowCount+1; i++) {
	 * 
	 * Row row = guru99Sheet.getRow(i);
	 * 
	 * //Create a loop to print cell values in a row
	 * 
	 * for (int j = 0; j < row.getLastCellNum(); j++) {
	 * 
	 * //Print Excel data in console
	 * 
	 * System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	 * 
	 * }
	 * 
	 * System.out.println(); }
	 * 
	 * }
	 * 
	 * //Main function is calling readExcel function to read data from excel file
	 * 
	 * public static void main(String[] args) throws IOException{
	 * 
	 * //Create an object of ReadGuru99ExcelFile class
	 * 
	 * ReadExcel objExcelFile = new ReadExcel();
	 * 
	 * //Prepare the path of excel file
	 * 
	 * String filePath =
	 * System.getProperty("C:\\Users\\AMBA BISHT\\Desktop\\ExcelGuru99Demo.xlsx");
	 * 
	 * //Call read file method of the class to read data
	 * 
	 * objExcelFile.readExcel(filePath,"ExcelGuru99Demo.xlsx","ExcelGuru99Demo");
	 * 
	 * }
	 */

		}
		 
					


