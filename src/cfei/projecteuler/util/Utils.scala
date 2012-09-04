package cfei.projecteuler.util

import collection.mutable.Map

object Utils {
  
  val FILE_PATH = "/Users/chrisfei/Documents/workspace2/ProjectEuler/files/"

  def isPrime (num : Long) : Boolean = {
    val sqrt = Math.sqrt(num.doubleValue()).intValue()
    return !2.until(sqrt + 1).exists(i => num % i == 0)
  }
  
  def primeFactorization(num : Int) : Map[Int,Int] = {
    val results = Map[Int,Int]()
    val sqrt = Math.sqrt(num.doubleValue()).intValue()
    2.until(sqrt + 1).filter(i => Utils.isPrime(i)).foreach(i => {
      var n = num
      var numTimes = 0
      while(n % i == 0) {
        n /= i
        numTimes += 1
      }
      
      results.put(i, numTimes)
    })
    return results
  }
  
  def factorial(num:BigInt) : BigInt = {
    BigInt(2).until(num+1).reduce(_*_)
  }
  
}