package cfei.projecteuler
import scala.collection.mutable.Set
import cfei.projecteuler.util.Utils

object Problem3 {

  /**
   * The prime factors of 13195 are 5, 7, 13 and 29.
   * What is the largest prime factor of the number 600851475143 ?
   */
  
  def main (args : Array[String]) {
    println(maxFactor(600851475143L))
  }
  
  def maxFactor (num : Long) : Long = {
    
    val sqrt = Math.sqrt(num.doubleValue()).floor.intValue()
    var max = 1
    2.until(sqrt).filter(i => Utils.isPrime(i)).foreach(i => {
      if (num % i == 0) {
        max = i
      }
    })
    
    return max
  }
}