package co.demo.isp.data;

import co.demo.isp.config.FrameWorkConfig;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    private Workbook workbook;


    public ExcelReader(){
        Path dataFilePath = Paths.get(FrameWorkConfig.getProperty("datafile.location"),FrameWorkConfig.getProperty("datafile.name"));
        try(InputStream stream = new FileInputStream(dataFilePath.toFile())){
            workbook = new XSSFWorkbook(stream);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public List<Object []> getDataFromSheet(String sheetName, boolean skipHeader){
        List<Object []> data = new ArrayList<>();
        Sheet sheet  = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.rowIterator();
        if(skipHeader){
            rowIterator.next();
        }
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            List<Object> cellData = new ArrayList<>();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if(cell.getCellTypeEnum()== CellType.STRING){
                    cellData.add(cell.getStringCellValue());
                }
                if(cell.getCellTypeEnum()== CellType.NUMERIC){
                    cellData.add(cell.getNumericCellValue());
                }
                if(cell.getCellTypeEnum()== CellType.BOOLEAN){
                    cellData.add(cell.getBooleanCellValue());
                }
            }
            data.add(cellData.toArray());
        }
        return data;

    }

}
