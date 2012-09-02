package cfei.projecteuler
import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer

object Problem14 {
  
  val lengthCache = Map[Long,Long]()
  
  var maxKey:Long = 1l
  var maxVal:Long = 1l

  def main(args:Array[String]) {
//    println(getLength(725343l))
	800000l until 900000l foreach {getLength _} 
	println(maxKey + " -> " + maxVal)
  }
  
  def getLength(n:Long) : Long = {
    println("Checking " + n)
    if(n == 1) {
      return 1
    }
    
    var num = n    
    var jumpsToFinish = 1l
    
    var sequence = ListBuffer[Long]()
    
    var numJumps = 0
    
    while(num != 1) {
      sequence += num
      
      val len:Option[Long] = lengthCache.get(num)
      len match {
        case Some(cachedLen) => {
          jumpsToFinish = cachedLen
          num = 1
        }
        case None => {
          numJumps = numJumps + 1
	      if(num % 2 == 0) {
	        num = num / 2
	      } else {
	        num = 3 * num + 1
	      }
        } 
      } 
    }
    
    sequence foreach { num => {
      val jumps = jumpsToFinish + numJumps
      lengthCache += num -> jumps
      numJumps = numJumps-1 
    }}
    
    val result = lengthCache.get(n).get
    if(result > maxVal) {
      maxVal = result
      maxKey = n
      println("New max: " + maxKey + " -> " + maxVal)
    }
    
    return result;
  }
  
}