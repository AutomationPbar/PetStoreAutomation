package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidermethod {
	
	@DataProvider(name="data")
	
	public String[][] getAlldata() throws IOException {
		
		String path= System.getProperty("user.dir")+"//testdata//testdata.xlsx";
		XLUtility xl= new XLUtility(path);  //open file in path
		int rowcount =xl.getRowCount("Sheet1");
		int colcount =xl.getCellCount("Sheet1", 1);
		
		String apidata[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++) {
			
			for(int j=0;j<colcount;j++) {
				
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		
		return apidata;
		
	}

	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		
		String path= System.getProperty("user.dir")+"//testdata//testdata.xlsx";
		XLUtility XL = new XLUtility(path);
		int rowcount= XL.getRowCount("Sheet1");
		String apidata[]=new String[rowcount];
		
		for(int i=1;i<=rowcount;i++) {
			
			apidata[i-1]=XL.getCellData("Sheet1", i, 1);
		}
		
		return apidata;
		
	}
			}
