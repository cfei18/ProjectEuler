package cfei.projecteuler

import cfei.projecteuler.util.Utils

object Problem20 {

  def main(args:Array[String]) {
    var num = Utils.factorial(100)
    println (num.toString filter {_.isDigit} map {_.asDigit} reduce {_+_})
  }
  
}