import java.util.Calendar;

public class TimeStamp extends SimpleDate {
  private GlobalTime time;
  private String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
  private static Calendar cal = Calendar.getInstance();

  public TimeStamp() {
    super(cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.YEAR));
    time = new GlobalTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
        cal.get(Calendar.ZONE_OFFSET));
  }
  // public TimeStamp() {
  // super(1, 1, 1);
  // time = new GlobalTime();
  // }

  public TimeStamp(int y) {
    super(1, 1, y);
    time = new GlobalTime();
  }

  public TimeStamp(int m, int y) {
    super(m, 1, y);
    time = new GlobalTime();
  }

  public TimeStamp(int m, int d, int y) {
    super(m, d, y);
    time = new GlobalTime();
  }

  public TimeStamp(int m, int d, int y, int h) {
    setDate(m, d, y);
    time = new GlobalTime(h);
  }

  public TimeStamp(int m, int d, int y, int h, int minute) {
    setDate(m, d, y);
    time = new GlobalTime(h, minute);
  }

  public TimeStamp(int m, int d, int y, int h, int minute, int sec) {
    setDate(m, d, y);
    time = new GlobalTime(h, minute, sec);
  }

  public TimeStamp(int m, int d, int y, int h, int minute, int sec, int zone) {
    setDate(m, d, y);
    time = new GlobalTime(h, minute, sec, zone);
  }

  public TimeStamp(SimpleDate otherDate) {
    this(otherDate.getMonth(), otherDate.getDay(), otherDate.getYear());
  }

  public boolean equals(Object o) {

    if (o instanceof TimeStamp) {
      return (((TimeStamp) o).getMonth() == this.getMonth() && ((TimeStamp) o).getDay() == this.getDay()
          && ((TimeStamp) o).getYear() == this.getYear() && this.time.getHour() == ((TimeStamp) o).time.getHour()
          && this.time.getMinute() == ((TimeStamp) o).time.getMinute()
          && this.time.getSecond() == ((TimeStamp) o).time.getSecond()
          && this.time.getZone() == ((TimeStamp) o).time.getZone());
    } else {
      return false;
    }
  }

  public void changeZone(int zone) {
    if (zone >= -12 || zone <= 12) {
      int difference = zone - time.getZone();
      time.setZone(zone);
      int newHour = time.getHour() + difference;

      if (newHour > 24) {
        newHour -= 24;
      } else if (newHour < 0) {
        newHour += 24;
      }

      time.setHour(newHour);
    }
  }

  public String toString() {

    String result = months[getMonth() - 1] + " " + getDay() + ", " + getYear() + " at " + time.getHour() + ":"
        + time.getMinute() + ":" + time.getSecond() + " UTC";

    if (time.getZone() > 0) {
      result += "+" + time.getZone();
    } else if (time.getZone() < 0) {
      result += time.getZone();
    }

    return result;
  }

  public static void main(String[] args) {

    SimpleDate sd = new SimpleDate(10, 15, 2001);
    TimeStamp ts = new TimeStamp(12, 29, 1986, 10, 50, 45, -8);
    TimeStamp ts2 = new TimeStamp(sd);

    // Testing output
    System.out.println(sd); // SimpleDate
    System.out.println(ts); // Output: Dec 29, 2009 at 10:50:45 UTC-2
    System.out.println(ts2); // Testing SimpleDate copy to TimeStamp

    System.out.println();

    // testing changeZone method
    TimeStamp cz = new TimeStamp(23, 11, 1990, 10, 50, 45, 6);
    System.out.println("Original zone: " + cz);
    cz.changeZone(3);
    System.out.println("Changed zone: " + cz);

    System.out.println();

    // Default constructor is based on the current system time
    TimeStamp curTime = new TimeStamp();
    System.out.println("Current time: " + curTime);

    // Testing equals
    TimeStamp ts3 = new TimeStamp(12, 29, 1986, 10, 50, 45, -8);
    TimeStamp ts4 = new TimeStamp(12, 29, 1986, 10, 50, 45, 6);
    System.out.println(ts.equals(ts3)); // expecting true
    System.out.println(ts3.equals(ts4)); // expecting false
  }
}