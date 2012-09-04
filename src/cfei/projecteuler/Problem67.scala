package cfei.projecteuler

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import scala.collection.mutable.Set
import java.io.File
import java.util.Scanner
import cfei.projecteuler.util.Utils

object Problem67 {

  var input:String = ""
  val flatGraph:ListBuffer[Int] = ListBuffer[Int]()
  
  def main(args:Array[String]) {
    initInput
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
  
  def initInput() {
    val file = new File(Utils.FILE_PATH + "triangle.txt")
    val scanner = new Scanner(file)
    while(scanner.hasNextLine()) {
      val line = scanner.nextLine()
      println("Adding line: " + line)
      input = input + line + "\n"
    }
    println(input)
  }

  def parseInput() {
    var i = 0
    input.split("\n") map {_.trim} foreach(str => {
      var strArr:Array[String] = str.split(" ")
      strArr map {_.toInt * -1} foreach {flatGraph += _}
    })
  }
  
}