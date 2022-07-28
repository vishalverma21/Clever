package Bean;

public class DataBean {

    private static String flag;
    private static String flag1;

    public static void setTimer1(String timer1) {

        flag = timer1;
    }

    public static String getTimer1() {

        return flag;
    }

    public static void setTimer2(String timer2) {

        flag1 = timer2;
    }

    public static String getTimer2() {

        return flag1;
    }
}
