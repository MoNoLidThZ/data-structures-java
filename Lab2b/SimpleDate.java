/*
 * Source: SimpleDate.java
 * Author: Instructor
 * Detail: Superclass for use in the Advanced Java Design Lab
 */

public class SimpleDate
{
   private int month;              // valid values in: 1 - 12
   private int day; // valid values in: 1 - max days in month
   private int year;   // valid values in: all integers but 0

   public SimpleDate()
   {
      this(1, 1, 1);
   }

   public SimpleDate(int y)
   {
      this(1, 1, y);
   }

   public SimpleDate(int m, int y)
   {
      this(m, 1, y);
   }

   public SimpleDate(int m, int d, int y)
   {
      setDate(m, d, y);
   }
   
   public SimpleDate(SimpleDate otherDate)
   {
      this(otherDate.month, otherDate.day, otherDate.year);
   }

   public void setDate(int m, int d, int y)
   {
      setYear(y);
      setMonth(m);
      setDay(d);
   }

   public void setMonth(int m)
   {
      month = ( m >= 1 && m <= 12 ) ? m : 1;
   }

   public int getMonth()
   {
      return month;
   }
   
   public void setDay(int d)
   {
      int daysPerMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

      if (d >=1 && d <= daysPerMonth[month])
         day = d;
      else if
         (
            month == 2 && d == 29 &&
            (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
         )
      {
         day = d;
      }
      else
      {
         day = 1;
      }
   }
   
   public int getDay()
   {
      return day;
   }
   
   public void setYear(int y)
   {
      year = (!(y == 0)) ? y : 1;
   }
   
   public int getYear()
   {
      return year;
   }
   
   public boolean equals(Object o)
   {
      if (o instanceof SimpleDate)
      {
         return
         (
            ((SimpleDate) o).month == this.month &&
            ((SimpleDate) o).day   == this.day   &&
            ((SimpleDate) o).year  == this.year
         );
      }
      else
      {
         return false;
      }
   }

   public String toString()
   {
      return String.format("%02d/%02d/%04d", month, day, year);
   }

   public static void main (String[] args)   // SimpleTime Self-Test
   {
      SimpleDate d1 = new SimpleDate(2,  1, 2017);
      SimpleDate d2 = new SimpleDate(2,  1, 2017);
      SimpleDate d3 = new SimpleDate(2, 29, 2017);
      
      System.out.println("Date 1 is: " + d1);
      System.out.println("Date 2 is: " + d2);
      System.out.println("Date 3 is: " + d3);
      System.out.println("Date 1 and 2 match: " + d1.equals(d2));
      System.out.println("Date 2 and 3 match: " + d2.equals(d3));
   }
}
