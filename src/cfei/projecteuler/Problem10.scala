package cfei.projecteuler
import cfei.projecteuler.util.Utils

object Problem10 {
  
  /**
   * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
   * 
   * Find the sum of all the primes below two million.
   */

  def main(ags : Array[String]) {
    val sum = 2.until(2000000).filter(n => Utils.isPrime(n)).foldLeft(0L)((result, n) => {
      result + n
    })
    println(sum)
  }
  
}