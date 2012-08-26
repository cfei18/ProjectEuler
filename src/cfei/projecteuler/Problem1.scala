package cfei.projecteuler

object Problem1 {

  /**
   * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
   * we get 3, 5, 6 and 9. The sum of these multiples is 23.
   * Find the sum of all the multiples of 3 or 5 below 1000.
   */
  
  def main(args : Array[String]) {
    val range = 0 until 1000
    val filtered = range.filter( i => { 
      i % 15 == 0 || i % 5 == 0 || i % 3 == 0
    })
    
    val sum = filtered.fold(0)((x,y) => x+y)
    println(sum)
  }
  
}