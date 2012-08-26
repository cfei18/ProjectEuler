package cfei.projecteuler

object Problem4 {

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