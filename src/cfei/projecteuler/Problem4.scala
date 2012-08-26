package cfei.projecteuler

object Problem4 {
  
  /** 
   * A palindromic number reads the same both ways. The largest palindrome made 
   * from the product of two 2-digit numbers is 9009 = 91 99.
   * 
   * Find the largest palindrome made from the product of two 3-digit numbers.
   */

  def main(args : Array[String]) {
    var max = 0
    for(i <- 100.until(999); j <- i.until(999)) {
      val num = i * j
      if(num > max && isPalindrome(num)) {
       max = num 
      }
    }
    println(max)
  }
  
  def isPalindrome(num : Int) : Boolean = {
    val reverse = num.toString().reverse
    return reverse equals num.toString()
  }
  
}