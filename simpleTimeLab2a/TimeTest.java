
public class TimeTest {
  public static void main(String[] args) {
    // System.out.println("Creating GlobalTime object with zero zone");
    GlobalTime gtime1 = new GlobalTime(2, 33, 25, 0);
    System.out.println(gtime1.toString());

    // System.out.println("Creating GlobalTime object with zone");
    GlobalTime gtime2 = new GlobalTime(2, 33, 26, 10);
    System.out.println(gtime2.toString());

    System.out.println(gtime1.equals(gtime2));

    SimpleTime stime1 = new SimpleTime(2, 33, 25);
    System.out.println(stime1.getHour() + stime1.getMinute() + stime1.getSecond());
    System.out.println(gtime1.equals(stime1));
    System.out.println(gtime2.equals(stime1));
  }
}