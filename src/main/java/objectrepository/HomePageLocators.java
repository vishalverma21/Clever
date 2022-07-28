package objectrepository;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static final By profileButton = By.xpath("//*[@data-test='BottomNavigation.ProfileScreenButton']");

    public static final By clock = By.xpath("//*[@data-test='BottomNavigation.ReportScreenButton']");

    public static final By calender = By.xpath("//*[@data-test='BottomNavigation.CalendarScreenButton']");

    public static final By brandLogo = By.xpath("//*[@data-test='CalendarScreen.UpcomingShifts.BrandLogoImage']");

    public static final By elapsedTime = By.xpath("//*[@data-test='ShiftScreen.TimeRecording.ElapsedTimeText']");

    public static final By recordTimeButton = By.xpath("//*[@data-test='ShiftScreen.TimeRecording.TrackTimeButton']");

    public static final By stopWorkingTime = By.xpath("//*[@data-test='ShiftScreen.StopWorkingTimeDialog.ConfirmButton']");
}
