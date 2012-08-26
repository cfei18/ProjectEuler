package cfei.projecteuler

object Problem9 {
  
  /**
   * A Pythagorean triplet is a set of three natural numbers, a  b  c, for 
   * which,
   * 
   *    a^2 + b^2 = c^2
   * 
   * For example, 32 + 42 = 9 + 16 = 25 = 52.
   * 
   * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
   * Find the product abc.
   * 
   * NOTES:
   * Disclaimer - I used my old number theory notebook for this one. For 
   * n,m \in Z with n > m, let a = n^2 - m^2, b = 2nm, c = n^2 + m^2 and you 
   * have a Pythagorean triple.
   */

  def main(args : Array[String]) {
    val range = 1 until 500
    for(j <- range) {
      for(i <- j until 500) {
        val isquare = Math.pow(i,2).intValue()
        val jsquare = Math.pow(j,2).intValue()
        
        val a = isquare - jsquare
        val b = 2 * i *j
        val c = isquare + jsquare
        
        if(a != b && b != c && a != c) {
          if(a + b + c == 1000) {
            println("(" + a + "," + b + "," + c + ") -> " + a*b*c)
          }
        }
      }
    }
  }
  
}