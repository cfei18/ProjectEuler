package cfei.projecteuler

object Problem6 {

  /**
   * The sum of the squares of the first ten natural numbers is,
   *    1^2 + 2^2 + ... + 10^2 = 385
   * The square of the sum of the first ten natural numbers is,
   *    (1 + 2 + ... + 10)^2 = 552 = 3025
   *    
   * Hence the difference between the sum of the squares of the first ten 
   * natural numbers and the square of the sum is 3025  385 = 2640.
   * 
   * Find the difference between the sum of the squares of the first one hundred
   * natural numbers and the square of the sum.
   */
  
  def main(args : Array[String]) {
    val range = 1.until(101)
    val squareOfSum = Math.pow(range.fold(0)((result,i) => result + i),2).intValue()
    val sumOfSquares = range.map(i => {
      Math.pow(i,2).intValue()
    }).fold(0)((result,i) => result + i).intValue()
    println(squareOfSum - sumOfSquares)
  }
}