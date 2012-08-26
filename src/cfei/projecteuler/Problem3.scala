package cfei.projecteuler
import scala.collection.mutable.Set

object Problem3 {

  /**
   * The prime factors of 13195 are 5, 7, 13 and 29.
   * What is the largest prime factor of the number 600851475143 ?
   */
  
  def main (args : Array[String]) {
    println(maxFactor(600851475143L))
  }
  
  def isPrime (num : Long) : Boolean = {
    val sqrt = Math.sqrt(num.doubleValue()).floor.intValue()
    return !2.until(sqrt + 1).exists(i => num % i == 0)
  }
  
  def maxFactor (num : Long) : Long = {
    
    val sqrt = Math.sqrt(num.doubleValue()).floor.intValue()
    var max = 1
    2.until(sqrt).filter(i => isPrime(i)).foreach(i => {
      if (num % i == 0) {
        max = i
      }
    })
    
    return max
  }
}