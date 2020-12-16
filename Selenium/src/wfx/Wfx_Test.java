package wfx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Wfx_Test {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\AMBA BISHT\\Desktop\\WFX_Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
			
		int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(2);
			Cell Deduction_Cell = row.getCell(3);
			System.out.println(cell+"-"+Deduction_Cell);
			double Gross_Salary = cell.getNumericCellValue();
			double Deduction = Deduction_Cell.getNumericCellValue();
			double Net = Gross_Salary-Deduction;
			System.out.println(Net+"O/P");
			
			/*
			 * Row row_write = sheet.createRow(i); Cell cell_write =
			 * row_write.createCell(4);
			 */
			Cell set_value = row.getCell(4);
			set_value.setCellValue(Net);
			FileOutputStream Fout = new FileOutputStream("C:\\Users\\AMBA BISHT\\Desktop\\WFX_Test.xlsx");
			workbook.write(Fout);
			Fout.close();
			System.out.println("END OF WRITING DATA IN EXCEL");
		}
		

	}

}
