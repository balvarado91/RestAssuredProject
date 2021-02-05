package demo;

import org.testng.annotations.DataProvider;


public class DataForTests {
    @DataProvider(name = "dataForPost")
    public Object[][] dataForPost(){
        //Excel with 2 rows 3 columns
//        Object[][] data = new Object[2][3];
//        data[0][0] = "Brayan";
//        data[0][1] = "Alve";
//        data[0][2] = 2;
//
//        data[1][0] =  "Laika";
//        data[1][1] =  "Gaty";
//        data[1][2] = 1;
//
//        return data;

        return new Object[][]{
                {"Graham", "Bell", 1},
                {"Oddie", "Ford", 2}
        };
    }
    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){

        return new Object[]{
                1
        };
    }

}
