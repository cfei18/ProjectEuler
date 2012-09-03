package cfei.projecteuler
import java.util.Calendar

object Problem19 {

  /**
   * You are given the following information, but you may prefer to do some 
   * research for yourself.
   * 
   * 1 Jan 1900 was a Monday.
   * Thirty days has September,
   * April, June and November.
   * All the rest have thirty-one,
   * Saving February alone,
   * Which has twenty-eight, rain or shine.
   * And on leap years, twenty-nine.
   * 
   * A leap year occurs on any year evenly divisible by 4, but not on a century
   * unless it is divisible by 400.
   * 
   * How many Sundays fell on the first of the month during the twentieth 
   * century (1 Jan 1901 to 31 Dec 2000)?
   */
  def main(args:Array[String]) {
	  val c = Calendar.getInstance()
	  c.set(Calendar.YEAR, 1901)
	  c.set(Calendar.MONTH, Calendar.JANUARY)
	  c.set(Calendar.DAY_OF_MONTH, 6)
	  
	  val limit = Calendar.getInstance()
	  limit.set(Calendar.YEAR, 2000)
	  limit.set(Calendar.MONTH, Calendar.DECEMBER)
	  limit.set(Calendar.DAY_OF_MONTH, 31)
	  var num = 0
	  while(c.before(limit)) {
	    if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
	        && c.get(Calendar.DAY_OF_MONTH) == 1) {
	      num = num + 1
	      println(c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.YEAR))
	    }
	    c.add(Calendar.DAY_OF_YEAR, 7)
	  }
	  
	  println(num)
  }
}