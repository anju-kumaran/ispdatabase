package co.demo.isp.data;

import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

public class LoginData {
    @DataProvider
    public Iterator<Object []> dataFromExcel(){
        ExcelReader excelReader = new ExcelReader();
        List<Object[]> logins = excelReader.getDataFromSheet("Logins", true);
        return logins.iterator();
    }
}
