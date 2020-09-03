/*
 * Source: SimpleTime.java
 * Author: Instructor
 * Detail: Superclass for use in the Advanced Java Design Lab
 */

public class SimpleTime
{
   private int hour;                   // valid values 0 - 23
   private int minute;                 // valid values 0 - 59
   private int second;                 // valid values 0 - 59

   public SimpleTime()
   {
      this(0, 0, 0);
   }

   public SimpleTime(int h)
   {
      this(h, 0, 0);
   }

   public SimpleTime(int h, int m)
   {
      this(h, m, 0);
   }

   public SimpleTime(int h, int m, int s)
   {
      setSimpleTime(h, m, s);
   }

   public SimpleTime(SimpleTime otherTime)
   {
      this(otherTime.hour, otherTime.minute, otherTime.second);
   }

   public void setSimpleTime(int h, int m, int s)
   {
      setHour(h);
      setMinute(m);
      setSecond(s);
   }

   public void setHour(int h)
   {
      hour = ( h >= 0 && h < 24 ) ? h : 0;
   }

   public void setMinute(int m)
   {
      minute = ( m >= 0 && m < 60 ) ? m : 0;
   }

   public void setSecond(int s)
   {
      second = ( s >= 0 && s < 60 ) ? s : 0;
   }

   public int getHour()
   {
      return hour;
   }

   public int getMinute()
   {
      return minute;
   }

   public int getSecond()
   {
      return second;
   }

   public String toString()
   {
      return String.format
      (
         "%d:%02d:%02d %s",
         (hour == 0 || hour == 12) ? 12 : hour % 12, minute, second,
         hour < 12 ? "AM" : "PM"
      );
   }

   public static void main (String[] args)   // SimpleTime Self-Test
   {
      SimpleTime t1 = new SimpleTime(20, 30, 40);
      SimpleTime t2 = new SimpleTime(20, 30, 40);
      SimpleTime t3 = new SimpleTime(20, 30, 50);
      
      System.out.println("Time 1 is: " + t1);
      System.out.println("Time 2 is: " + t2);
      System.out.println("Time 3 is: " + t3);
      System.out.println("Time 1 and 2 match: " + t1.equals(t2));
      System.out.println("Time 2 and 3 match: " + t2.equals(t3));
   }
}
