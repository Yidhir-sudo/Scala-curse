package sessions.session2

// Session 2 – Exercise 2: List vs Vector comparison
object Session2Exercise2 {
  def main(args: Array[String]): Unit = {
    val n = 100000
    val list = List.fill(n)(0)
    val vector = Vector.fill(n)(0)

    // Prepend
    val listHeadTime = executionTime {
      1 +: list
    }
    val vectorHeadTime = executionTime {
      1 +: vector
    }

    // Append
    val listTailTime = executionTime {
      list :+ 1
    }
    val vectorTailTime = executionTime {
      vector :+ 1
    }

    println(s"Prepend : List = $listHeadTime ms, Vector = $vectorHeadTime ms")
    println(s"Append  : List = $listTailTime ms, Vector = $vectorTailTime ms")
  }

  // Measure execution time
  def executionTime(operation: => Unit): Long = {
    val t0 = System.nanoTime()
    operation
    val t1 = System.nanoTime()
    (t1 - t0) / 1000000 // ms
  }
}
