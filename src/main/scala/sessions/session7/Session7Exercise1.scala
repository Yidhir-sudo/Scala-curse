package sessions.session7

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Success, Failure}

object Session7Exercise1 {

  def main(args: Array[String]): Unit = {

    val result = computeSquareAsync(6)

    result.onComplete {
      case Success(value) => println(s"The square is: $value")
      case Failure(e) => println(s"Error: ${e.getMessage}")
    }

    Await.ready(result, 5.seconds) // wait for completion without relying on an arbitrary sleep
  }

  // Exercise 1
  def computeSquareAsync(x: Int): Future[Int] = Future {
    Thread.sleep(1000)
    x * x
  }
}
