package cfei.projecteuler.util

object Utils {

  def isPrime (num : Long) : Boolean = {
    val sqrt = Math.sqrt(num.doubleValue()).floor.intValue()
    return !2.until(sqrt + 1).exists(i => num % i == 0)
  }
  
}