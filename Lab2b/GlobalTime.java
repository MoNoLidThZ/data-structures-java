
public class GlobalTime extends SimpleTime {

  // time zone, type integer
  private int zone;

  // default constructor
  public GlobalTime() {
    super(0, 0, 0);
    this.zone = 0;
  }

  public GlobalTime(int h) {
    super(h, 0, 0);
    this.zone = 0;
  }

  public GlobalTime(int h, int m) {
    super(h, m, 0);
    this.zone = 0;
  }

  public GlobalTime(int h, int m, int s) {
    super(h, m, s);
    this.zone = 0;
  }

  public GlobalTime(int h, int m, int s, int z) {
    super(h, m, s);
    setZone(z);
  }

  public GlobalTime(GlobalTime otherTime) {
    this(otherTime.getHour(), otherTime.getMinute(), otherTime.getSecond(), otherTime.getZone());
  }

  public int getZone() {
    return zone;
  }

  public void setGlobalTime(int h, int m, int s, int z) {
    setHour(h);
    setMinute(m);
    setSecond(s);
    setZone(z);
  }

  public void setZone(int zone) {
    if (zone < -12 || zone > 12) {
      this.zone = 0;
    } else {
      this.zone = zone;
    }
  }

  /*
   * GlobalTime equals() checks if all properties are equal if compared to another
   * GlobalTime object. If compared to a SimpleTime object, it will compare only
   * hours, minutes, and seconds, ignoring zone. If compared to an object that is
   * not a SimpleTime or GlobalTime, return false.
   */
  public boolean equals(Object object) {

    if (object instanceof GlobalTime) {
      return super.equals(object) && zone == ((GlobalTime) object).getZone();
    } else if (object instanceof SimpleTime) {
      return this.getHour() == ((SimpleTime) object).getHour() && this.getMinute() == ((SimpleTime) object).getMinute()
          && this.getSecond() == ((SimpleTime) object).getSecond();
    }

    return false;
  }

  /*
   * GlobalTime toString() returns the time in 24 hour UTC format, with zone added
   * if zone is >= 0 or <= 0.
   */
  public String toString() {
    int h = getHour();
    int m = getMinute();
    int s = getSecond();
    int z = getZone();
    String result = "";

    if (z != 0) {
      result = String.format("%d:%02d:%02d %s", h, m, s, (z > 0) ? "UTC+" + zone : "UTC-" + zone);
    } else {
      result = String.format("%d:%02d:%02d UTC", h, m, s);
    }

    return result;
  }

  public static void main(String[] args) // GlobalTime Self-Test
  {
    GlobalTime gt1 = new GlobalTime(20, 30, 40, 0);
    GlobalTime gt2 = new GlobalTime(20, 30, 40, 10);
    SimpleTime st1 = new SimpleTime(20, 30, 40);
    SimpleTime st2 = new SimpleTime(5, 30, 30);

    // Print Global Time 1
    System.out.println("Global Time 1 is: " + gt1);

    // Print Global Time 2
    System.out.println("Global Time 2 is: " + gt2);

    // Print Simple Time 1
    System.out.println("Simple Time 1 is: " + st1);

    // Print Simple Time 2
    System.out.println("Simple Time 2 is: " + st2);

    // Test equality for GT1 and GT2, expected: false
    System.out.println("Global Time 1 and Global Time 2 match: " + gt1.equals(gt2));

    // Test equality for GT2 and ST1, expected: true
    System.out.println("Global Time 2 and Simple Time 1 match: " + gt2.equals(st1));

    // Test equality for GT1 and ST1, expected: true
    System.out.println("Global Time 1 and Simple Time 1 match: " + gt1.equals(st1));

    // Test equality for GT1 and ST2, expected: false
    System.out.println("Global Time 1 and Simple Time 2 match: " + gt1.equals(st2));
  }
}