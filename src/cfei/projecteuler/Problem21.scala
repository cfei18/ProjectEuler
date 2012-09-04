package cfei.projecteuler

import scala.collection.mutable.Set

object Problem21 {

  /**
   * Let d(n) be defined as the sum of proper divisors of n (numbers less than 
   * n which divide evenly into n).
   * 
   * If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and
   * each of a and b are called amicable numbers.
   * 
   * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
   * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 
   * 4, 71 and 142; so d(284) = 220.
   * 
   * Evaluate the sum of all the amicable numbers under 10000.
   */
  
  val amicableNumbers = Set[Int]()
  
  def main(args:Array[String]) {
    1 until 10000 foreach(num => {
      if(!amicableNumbers.contains(num)) {
    	  val sum1 = divisorSum(num)
    	  val sum2 = divisorSum(sum1)
    	  if(num !=  sum1 && num == sum2) {
    	    amicableNumbers += sum1
    	    amicableNumbers += sum2
    	  }
      }
    })
    
    println(amicableNumbers reduce {_+_})    
  }
  
  def divisorSum(num:Int) : Int = {
    divisors(num) reduce(_+_)  
  }
  
  def divisors(num:Int) : Set[Int] = {
    val result = Set[Int](0)
    val sqrt = scala.Math.sqrt(num.doubleValue()).intValue() + 1
    val range = 1 until sqrt
    range filter { num % _ == 0} foreach (divisor => { 
      if(divisor < num) {
        result += divisor
        if(divisor != 1) {
    	  result += num / divisor
        }
      }
    })
    
    return result
  }
  
}