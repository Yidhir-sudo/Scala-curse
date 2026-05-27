package sessions.session1

import scala.io.StdIn

object Session1Exercise2 {
  def main(args: Array[String]): Unit = {
    val secret = scala.util.Random.nextInt(101) // 0..100 inclusive
    println("I picked a number between 0 and 100. Try to guess it!")

    var attempts = 0
    var found = false

    while (!found) {
      print("Enter a number: ")
      val guess = StdIn.readLine().trim.toInt
      attempts += 1

      if (guess < secret) println("Too small!")
      else if (guess > secret) println("Too big!")
      else {
        println(s"Well done! The number was $secret.")
        println(s"Found in $attempts attempt(s).")
        found = true
      }
    }
  }
}
