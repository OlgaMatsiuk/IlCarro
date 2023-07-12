package tests;

import org.testng.annotations.Test;

public class SearchTests extends TestBase {

   // button[type='submit']
    //fillSearchForm with location
    //fillSearchForm
    //submit

    @Test
    public void searchPositiveTest(){
        app.getSearch().fillSearchForm("Haifa", "7/15/2023", "7/20/2023");


        app.getSearch().submitForm();

    }
    @Test
    public void searchPositiveTestDatePickerDays(){
        app.getSearch().fillSearchFormDatePickerDays("Haifa", "7/15/2023", "7/20/2023");

        app.getSearch().submitForm();
    }
    @Test
    public void searchPositiveTestDatePickerMonth(){
        app.getSearch().fillSearchFormDatePickerMonth("Haifa", "7/15/2023", "12/11/2023");

        app.getSearch().submitForm();
    }
    @Test
    public void searchPositiveTestDatePickerYears(){
        app.getSearch().fillSearchFormDatePickerYears("Haifa", "11/15/2023", "2/11/2024");

        app.getSearch().submitForm();
    }


}
