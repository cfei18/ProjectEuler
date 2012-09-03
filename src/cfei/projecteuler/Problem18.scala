package cfei.projecteuler

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import scala.collection.mutable.Set

object Problem18 {

  /**
   * By starting at the top of the triangle below and moving to adjacent numbers
   * on the row below, the maximum total from top to bottom is 23.
   *  3
   *  7 4
   *  2 4 6
   *  8 5 9 3
   *  
   * That is, 3 + 7 + 4 + 9 = 23.
   * Find the maximum total from top to bottom of the triangle below:
   *  75
   *  95 64
   *  17 47 82
   *  18 35 87 10
   *  20 04 82 47 65
   *  19 01 23 75 03 34
   *  88 02 77 73 07 63 67
   *  99 65 04 28 06 16 70 92
   *  41 41 26 56 83 40 80 70 33
   *  41 48 72 33 47 32 37 16 94 29
   *  53 71 44 65 25 43 91 52 97 51 14
   *  70 11 33 28 77 73 17 78 39 68 17 57
   *  91 71 52 38 17 14 91 43 58 50 27 29 48
   *  63 66 04 68 89 53 67 30 73 16 69 87 40 31
   *  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
   *  
   *  NOTE: As there are only 16384 routes, it is possible to solve this problem
   *  by trying every route. However, Problem 67, is the same challenge with a
   *  triangle containing one-hundred rows; it cannot be solved by brute force,
   *  and requires a clever method! ;o)
   */
  val input = """75
    95 64
    17 47 82
    18 35 87 10
    20 04 82 47 65
    19 01 23 75 03 34
    88 02 77 73 07 63 67
    99 65 04 28 06 16 70 92
    41 41 26 56 83 40 80 70 33
    41 48 72 33 47 32 37 16 94 29
    53 71 44 65 25 43 91 52 97 51 14
    70 11 33 28 77 73 17 78 39 68 17 57
    91 71 52 38 17 14 91 43 58 50 27 29 48
    63 66 04 68 89 53 67 30 73 16 69 87 40 31
    04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"""
    
  val flatGraph:ListBuffer[Int] = ListBuffer[Int]()
  
  def main(args:Array[String]) {
    parseInput
    dijkstra
  }
  
  def dijkstra() {
    val distances:Map[Int,Int] = Map[Int,Int]()
    val unvisited:Set[Int] = Set[Int]()
    0 until flatGraph.size foreach(i => {
      distances.put(i, Int.MaxValue)
      unvisited add i
    })
    
    distances(0) = flatGraph(0)

    while(unvisited.size != 0) {
      val u:Int = 0 until flatGraph.size filter {unvisited.contains(_)} min;
      unvisited remove u
      
      println(unvisited.size + " visited")
      if(distances(u) != Int.MaxValue) {
        println(u + " -> " + neighbors(u))
        neighbors(u) filter {_ < flatGraph.size} foreach(index => {
          val dist = distances(u) + flatGraph(index)
          if(dist < distances(index)) {
            distances(index) = dist
          }
        })
      }
    }
    
    println(distances.values min)
    
  }
  
  /*
   * 0 -> (1,2)
   * 1 -> (3,4)
   * 2 -> (4,5)
   * 3 -> (6,7)
   * 4 -> (7,8)
   * 5 -> (8,9)
   */
  def neighbors(num:Int) : Set[Int] = {
    val neighbors = Set[Int]()
    val rowNum = rowNumber(num)
    neighbors.add(num + rowNum + 1)
    neighbors.add(num + rowNum + 2)
    return neighbors
  }
  
  def rowNumber(num:Int) : Int = {
    var rowNum = 0
    0 until num+1 foreach(i => {
      val tNum = i * (i+1) / 2
      if(num >= tNum) {
        rowNum = i	
      }
    })
    
    return rowNum
  }

  def parseInput() {
    var i = 0
    input.split("\n") map {_.trim} foreach(str => {
      var strArr:Array[String] = str.split(" ")
      strArr map {_.toInt * -1} foreach {flatGraph += _}
    })
  }
}