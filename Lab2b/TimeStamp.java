public class TimeStamp extends SimpleDate {
  private GlobalTime time;
  private String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };

  public TimeStamp() {
    super(1, 1, 1);
    time = new GlobalTime();
  }

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

    System.out.println(ts); // Output: Dec 29, 2009 at 10:50:45 UTC-2
    System.out.println(ts2);

    // testing changeZone method
    TimeStamp cz = new TimeStamp(23, 11, 1990, 10, 50, 45, 2);
    System.out.println(cz);
    cz.changeZone(-2);
    System.out.println(cz);
  }
}