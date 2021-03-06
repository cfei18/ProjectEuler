package cfei.projecteuler

object Problem16 {

  /**
   * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
   * 
   * What is the sum of the digits of the number 2^1000?
   */
  
  def main(args:Array[String]) {
    var num = BigInt(2).pow(1000)
    println (num.toString filter {_.isDigit} map {_.asDigit} reduce {_+_})
  }
  
}