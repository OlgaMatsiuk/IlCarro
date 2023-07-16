package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String dataFrom, String dataTo){
        fillCity(city);
        selectPeriodDays(dataFrom, dataTo);

    }
    public void fillSearchFormDatePickerDays(String city, String dataFrom, String dataTo){
        fillCity(city);
        selectPeriodDaysDataPicker(dataFrom, dataTo);
        pause(2000);

    }

    private void selectPeriodDays(String dataFrom, String dataTo) {
       //click(By.id("dates"));
        //type(By.id("dates"), dataFrom + " - " + dataTo);
        wd.findElement(By.id("dates")).sendKeys(dataFrom + " - " + dataTo);
        //click(System.);
        pause(2000);
    }

    private void fillCity(String city) {
        type(By.id("city"), city);
        pause(3000);
        click(By.cssSelector("div.pac-item"));
        pause(3000);
    }
    public void submitLogin() {
        click(By.cssSelector("button[type='submit']"));
    }
    private void selectPeriodDaysDataPicker(String dataFrom, String dataTo) {
        //date 7/10/2023
        String[] startDate = dataFrom.split("/");
        String[] endDate = dataTo.split("/");
        click(By.id("dates"));
        click(By.xpath("//div[.=' " + startDate[1] +" ']"));
        click(By.xpath("//div[.=' " + endDate[1] +" ']"));

//        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
//        String locatorEndDate = String.format("//div[.=' %s ']", endDate[1]);
//        click(By.xpath(locatorStartDate));
//        click(By.xpath(locatorEndDate));
        pause(3000);
    }
    public void submitForm(){
        wd.findElement(By.cssSelector("button[type='submit']")).click();
        pause(2000);
    }


    public void fillSearchFormDatePickerMonth(String city, String dataFrom, String dataTo) {
        fillCity(city);
        selectPeriodMonth(dataFrom, dataTo);

    }
    private void selectPeriodMonth(String dataFrom, String dataTo) {
        //date 7/10/2023
        String[] startDate = dataFrom.split("/");
        String[] endDate = dataTo.split("/");
        int numberOfClick = Integer.parseInt(endDate[0])-Integer.parseInt(startDate[0]);
        click(By.id("dates"));
//        click(By.xpath("//div[.=' " + startDate[1] +" ']"));
//        click(By.xpath("//div[.=' " + endDate[1] +" ']"));

        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDate[1]);
        click(By.xpath(locatorStartDate));
        while (numberOfClick > 0){
            click(By.cssSelector("button[aria-label='Next month']"));
            numberOfClick = numberOfClick-1;
        }

        click(By.xpath(locatorEndDate));
        pause(3000);
    }

    public void fillSearchFormDatePickerYears(String city, String dataFrom, String dataTo) {
        fillCity(city);
        selectPeriodYearsDataPicker(dataFrom, dataTo);

    }

    public void selectPeriodYearsDataPicker(String dataFrom, String dataTo) {
        //date 7/10/2023
        String[] startDate = dataFrom.split("/");
        String[] endDate = dataTo.split("/");
        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDate[1]);
        String locatorYear = String.format("//div[.=' %s ']",endDate[2]);
//================================================================
//        LocalDate startDate2= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        LocalDate endDate2= LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        LocalDate nowDate2= LocalDate.now();
//        String locatorStartDate2 = String.format("//div[.=' %s ']",startDate2.getDayOfMonth());
//        String locatorEndDate2 = String.format("//div[.=' %s ']",endDate2.getDayOfMonth());
//        int startToEndMonth = startDate2.getYear()-nowDate2.getYear()==0
//                 ? startDate2.getMonthValue()-nowDate2.getMonthValue()
//                : 12-nowDate2.getMonthValue()+ startDate2.getMonthValue();
//        for (int i = 0; i < startToEndMonth; i++) {
//            click(By.xpath(locatorStartDate2));
//            pause(1000);
//        }
//        click(By.xpath(locatorStartDate2));
//        startToEndMonth = endDate2.getYear() - startDate2.getYear()==0 ?
//                endDate2.getMonthValue() - startDate2.getMonthValue() :
//                12-startDate2.getMonthValue() + endDate2.getMonthValue();
//        for (int i = 0; i < startToEndMonth; i++) {
//            click((By.cssSelector("button[aria-label='Next month']")));
//            pause(1000);
//        }
        //click((By.xpath(locatorEndDate2));
        pause(3000);
     // =================================================================

        click(By.id("dates"));
        int numberOfClickStart = Integer.parseInt(startDate[0])- LocalDate.now().getMonthValue(); // 7- July-current month
        while (numberOfClickStart > 0){
            click(By.cssSelector("button[aria-label='Next month']"));
            numberOfClickStart = numberOfClickStart-1;
        }
        click(By.xpath(locatorStartDate));
        pause(2000);
        int numberOfClickEnd = 12-Integer.parseInt(startDate[0])+Integer.parseInt(endDate[0]);
        while (numberOfClickEnd > 0){
            click(By.cssSelector("button[aria-label='Next month']"));
            numberOfClickEnd = numberOfClickEnd-1;
        }
        click(By.xpath(locatorEndDate));
        //click(By.cssSelector("button[aria-label='Choose month and year'] span[class='mat-button-wrapper']"));

        //click(By.xpath(locatorYear));
        pause(3000);
    }

//    public String fromDigitToMonth(int digitMonth) {
//        String m;
//
//        switch (digitMonth) {
//            case '1': m="JAN";
//            case '2': m= "FEB";
//            case '3': m= "MAR";
//            case '4': m= "APR";
//            case '5': m= "MAY";
//            case '6': m= "JUN";
//            case '7': m= "JUL";
//            case '8': m= "Januar";
//            case '9': m= "Janury";
//            case '10': m= "Jauay";
//            case '11': m= "Jary";
//            case '12': m= "Janary";
//        }
//        return m;

//    }


}
