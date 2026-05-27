package sessions.session3

object Session3 {

  def main(args: Array[String]): Unit = {
    val nums = List(1, 2, 3, 4, 5, 6)
    val result = processNumbers(nums)
    println(result)

    val text = "Scala is great and Scala is functional"
    val wordCounts = textPipeline(text)
    println(wordCounts)
  }

  // Exercise 1
  def processNumbers(nums: List[Int]): Int = {
    nums
      .filter(_ % 2 == 0) // keep only the even numbers
      .map(_ * 3)         // multiply by 3
      .sum                // sum everything
  }

  // Exercise 2
  def textPipeline(text: String): Map[String, Int] = {
    text
      .split("\\s+")                 // split into words
      .map(_.toLowerCase)            // lowercase
      .filter(_.length >= 4)         // keep only words of length ≥ 4
      .groupBy(identity)             // group by word
      .map { case (word, list) => word -> list.size } // count occurrences
  }
}
