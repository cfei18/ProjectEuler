package cfei.projecteuler
import scala.collection.mutable.ListBuffer
import java.io.File
import java.util.Scanner
import cfei.projecteuler.util.Utils

object Problem22 {
  
  /**
   * Using names.txt, a 46K text file containing over five-thousand first names,
   * begin by sorting it into alphabetical order. Then working out the 
   * alphabetical value for each name, multiply this value by its alphabetical 
   * position in the list to obtain a name score.
   * 
   * For example, when the list is sorted into alphabetical order, COLIN, which 
   * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, 
   * COLIN would obtain a score of 938  53 = 49714.
   * 
   * What is the total of all the name scores in the file?
   */
  
  val names:ListBuffer[String] = ListBuffer[String]()
  
  def main(args:Array[String]) {
    readInput
    val scores = names.sortWith(_.compareTo(_) < 0)
      .zipWithIndex map { case(value, index) => {
        val score = getScore(value, index)
        println(index + ": " + value + " -> " + score)
        score
      }} reduce {_+_}
    println(scores)
  }
  
  def getScore(name:String, index:Long) : Long = {
    (name.toUpperCase() map {_ - 65 + 1} reduce {_+_}) * (index + 1)
  }
  
  
  def readInput {
    val file = new File(Utils.FILE_PATH + "names.txt")
    val scanner = new Scanner(file)
    scanner.useDelimiter(",")
    while(scanner.hasNext()) {
      var name = scanner.next()
      // remove quotes
      name = name.substring(1, name.length() - 1)
      names += name
    }
  }

}