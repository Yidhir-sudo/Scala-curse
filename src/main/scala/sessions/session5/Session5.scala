package sessions.session5

object Session5 {

  def main(args: Array[String]): Unit = {

    // Exercise 1
    println(describe(5))             // Positive number
    println(describe(""))            // Empty string
    println(describe(List(1, 2, 3))) // List of length 3
    println(describe(3.14))          // Unknown type

    // Exercise 2
    println(safeSqrt(9))             // Right(3.0)
    println(safeSqrt(-4))            // Left(Negative number)
  }

  // Exercise 1
  def describe(x: Any): String = x match {
    case i: Int if i > 0 => "Positive number"
    case s: String if s.isEmpty => "Empty string"
    case l: List[_] => s"List of length ${l.length}"
    case _ => "Unknown type"
  }

  // Exercise 2
  def safeSqrt(x: Double): Either[String, Double] =
    if (x < 0) Left("Negative number")
    else Right(math.sqrt(x))
}
