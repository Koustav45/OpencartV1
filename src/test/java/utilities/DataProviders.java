package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = ".\\testdata\\Opencart_logindata.xlsx";

        // Create an instance of ExcelUtility using the file path
        ExcelUtility xlutil = new ExcelUtility(path);

        // Call the instance methods to get row and cell counts
        int totalrows = xlutil.getRowCount("Sheet1");  // Use the instance method
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Create a 2D array to store login data
        String[][] logindata = new String[totalrows][totalcols];

        // Loop through the Excel sheet to fetch the data
        for (int i = 1; i <= totalrows; i++) {  // Excel row indexing starts at 1
            for (int j = 0; j < totalcols; j++) {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);  // Use the instance method
            }
        }

        return logindata;  // Return the 2D array for the data provider
    }
}
