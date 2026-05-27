package sessions.session2

// Session 2 – Exercise 1: word counting
object Session2Exercise1 {
  def main(args: Array[String]): Unit = {
    val words = List("A", "B", "A", "C", "B", "A")

    // Functional version using groupBy
    val occurrences: Map[String, Int] = words.groupBy(identity).view.mapValues(_.size).toMap
    println(occurrences) // Map(A -> 3, B -> 2, C -> 1)


    // Equivalent variant with explicit pattern matching
    val occurrences2: Map[String, Int] = words.groupBy(identity).map {
      case (word, list) => word -> list.size
    }
    println(occurrences2) // Map(A -> 3, B -> 2, C -> 1)

    // Variant without groupBy (foldLeft)
    val occurrences3 = words.foldLeft(Map.empty[String, Int]) {
      (acc, word) => acc + (word -> (acc.getOrElse(word, 0) + 1))
    }

    println(occurrences3) // Map(A -> 3, B -> 2, C -> 1)
  }
}
