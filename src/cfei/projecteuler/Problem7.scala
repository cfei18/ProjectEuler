package cfei.projecteuler
import cfei.projecteuler.util.Utils

object Problem7 {

  /**
   * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
   * that the 6th prime is 13.
   * 
   * What is the 10001st prime number?
   */
  
  def main(args : Array[String]) {
    var numPrimes = 0
    var index = 2
    var mostRecentPrime = 0
    while (numPrimes < 10001) {
      if(Utils.isPrime(index)) {
        numPrimes += 1
        mostRecentPrime = index
      }
      index += 1
    }
    
    println(mostRecentPrime)
  }
}