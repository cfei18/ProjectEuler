package cfei.projecteuler
import cfei.projecteuler.util.Utils

object Problem15 {

  /**
   * Starting in the top left corner of a 2x2 grid, there are 6 routes 
   * (without backtracking) to the bottom right corner.
   * 
   * How many routes are there through a 2020 grid?
   */
  
  val side:BigInt = BigInt(20)
  def main(args:Array[String]) {
    //Thank you combinatorics class - the answer is just 40 choose 20
    val moves = 2 * 20
    println(getCombination(moves, side))
  }
  
  def getCombination(n:BigInt, k:BigInt) : BigInt = {
    Utils.factorial(n) / (Utils.factorial(n-k) * Utils.factorial(k))
  }
  
}