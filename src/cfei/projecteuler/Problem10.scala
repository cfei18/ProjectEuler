package cfei.projecteuler
import cfei.projecteuler.util.Utils

object Problem10 {

  def main(ags : Array[String]) {
    val sum = 2.until(2000000).filter(n => Utils.isPrime(n)).foldLeft(0L)((result, n) => {
      result + n
    })
    println(sum)
  }
  
}