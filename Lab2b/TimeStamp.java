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
    super(otherDate.getMonth(), otherDate.getDay(), otherDate.getYear());
  }

  public String toString() {
    String result = "";

    result += months[getMonth() - 1] + " " + getDay() + ", " + getYear() + " at " + time.getHour() + ":"
        + time.getMinute() + ":" + time.getSecond() + " UTC";

    if (time.getZone() > 0) {
      result += "+" + time.getZone();
    } else if (time.getZone() < 0) {
      result += "-" + time.getZone();
    }

    return result;
  }

  public static void main(String[] args) {
    TimeStamp ts = new TimeStamp(10, 29, 2009, 10, 50, 45, 4);

    System.out.println(ts);
  }
}