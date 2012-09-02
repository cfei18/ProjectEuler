package cfei.projecteuler

object Problem16 {

  def main(args:Array[String]) {
    var num = BigInt(2).pow(1000)
    println (num.toString filter {_.isDigit} map {_.asDigit} reduce {_+_})
  }
  
}