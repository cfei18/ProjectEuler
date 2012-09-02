package cfei.projecteuler

object Problem17 {
  
  /**
   * If the numbers 1 to 5 are written out in words: one, two, three, four, 
   * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
   * 
   * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
   * in words, how many letters would be used?
   *  
   *  NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
   *  forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 
   *  20 letters. The use of "and" when writing out numbers is in compliance 
   *  with British usage.
   */

  val one = "one"
  val two = "two"
  val three = "three"
  val four = "four"
  val five = "five"
  val six = "six"
  val seven = "seven"
  val eight = "eight"
  val nine = "nine"
  
  val onesList = List[String]("",one,two,three,four,five,six,seven,eight,nine)
  
  val ten = "ten"
  val eleven = "eleven"
  val twelve = "twelve"
  val thirteen = "thirteen"
  val fifteen = "fifteen"
  val eighteen = "eighteen"
  val teen = "teen"
  
  val twenty = "twenty"
  val thirty = "thirty"
  val forty = "forty"
  val fifty = "fifty"
  val sixty = "sixty"
  val seventy = "seventy"
  val eighty = "eighty"
  val ninety = "ninety"
  
  val tensList = List[String]("","",twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety)
  
  val hundred = "hundred"
  
  val and = "and"
    
  val onethousand = one + "thousand"
  
  def main(args:Array[String]) {
    println(1 until 1001 map {letters(_)} reduce {_+_} length)
  }
  
  def getOnes(num:Int) : String = {
    onesList(num)
  }
  
  def getTens(num:Int) : String = {
    num match {
      case 10 => ten
      case 11 => eleven
      case 12 => twelve
      case 13 => thirteen
      case 15 => fifteen
      case 18 => eighteen
      case n if 14 until 20 contains n => getOnes(n % 10) + teen
      case _ => tensList(num/10) + getOnes(num%10)
    }
  }
  
  def getHundreds(num:Int) : String = {
    getOnes(num/100) + hundred + 
    (num%100 match {
      case 0 => ""
      case _ => and + getTens(num%100)
    })
  }
  
  def letters(num:Int) : String = {
    num match {
      case n if 0 until 10 contains n => getOnes(n)
      case n if 10 until 100 contains n => getTens(n)
      case n if 100 until 1000 contains n => getHundreds(n)
      case 1000 => onethousand
    }
  }
}