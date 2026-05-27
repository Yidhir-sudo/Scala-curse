package sessions.session1

import scala.io.StdIn
import scala.util.{Random, Try}

object Session1Exercise2Improved {
  def main(args: Array[String]): Unit = {
    val secret = Random.nextInt(101) // 0..100 inclusive
    println("I picked a number between 0 and 100. Try to guess it!")

    var attempts = 0
    var found = false

    while (!found && attempts <= 10) {
      print("Enter a number: ")

      val maybeInt: Option[Int] = Try(StdIn.readLine().trim.toInt).toOption

      maybeInt match {
        case Some(guess) if guess >= 0 && guess <= 100 =>
          attempts += 1
          if (guess < secret) println("Too small!")
          else if (guess > secret) println("Too big!")
          else {
            println(s"Well done! The number was $secret.")
            println(s"Found in $attempts attempt(s).")
            found = true
          }
        case _ =>
          attempts += 1
          println("Invalid input. Please enter an integer between 0 and 100.")
      }
    }
    if (attempts > 10)
      println(s"You reached the maximum number of attempts. The mystery number was: $secret")
  }
}
