package abstractComponents;




	import java.io.File;
import java.io.FileInputStream;

	import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class Excelutility {
		
		
		public static String getCellValue(String testData1, String SheetName, int r, int c)
		{
			try
		
		
		{
				File f= new File(testData1);
				
				FileInputStream fi = new FileInputStream(f);
				XSSFWorkbook wb= new XSSFWorkbook(fi);
				XSSFCell cell= (XSSFCell) wb.getSheet(SheetName).getRow(r).getCell(c);
				if(cell.getCellType()==CellType.STRING)
				{
					return cell.getStringCellValue();
					
				}
				else
				{
					return cell.getRawValue();
				}
				
		}
			
			catch (Exception e)
			{
				return "";
			}

	}
		public static int getRowCount(String testData1, String SheetName)
		
		{
			
			try
			{
				File f= new File(testData1);
				
				FileInputStream fi = new FileInputStream(f);
				XSSFWorkbook wb= new XSSFWorkbook(fi);
				int rowNum = wb.getSheet(SheetName).getLastRowNum();
				System.out.println(rowNum);
				return rowNum;
				
			}
			catch (Exception e)
			{
				return 0;
			}

		
		
	}
		
	}




