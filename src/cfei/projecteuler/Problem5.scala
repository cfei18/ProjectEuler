package cfei.projecteuler
import cfei.projecteuler.util.Utils
import scala.collection.mutable.Map

object Problem5 {

  /**
   * 2520 is the smallest number that can be divided by each of the numbers from
   * 1 to 10 without any remainder.
   *  
   * What is the smallest positive number that is evenly divisible by all of 
   * the numbers from 1 to 20?
   * 
   */
  
  val primeFactorMap = Map[Int,Int]()
  
  def main(args : Array[String]) {
    
	1.until(20 + 1).map(i => Utils.primeFactorization(i)).foreach(map => {
	  map.foreach(kv => {
	    val key:Int = kv._1
	    val value:Int = kv._2
	    
	    val existing = primeFactorMap.get(key).getOrElse(0)
	    if(value > existing) {
	      primeFactorMap.put(key, value)
	    }
	  })
	})
	
	var result = primeFactorMap.foldLeft(1)((result,kv) => {
	  result * Math.pow(kv._1, kv._2).intValue()
	})
	
	println(result)
  }
  
}