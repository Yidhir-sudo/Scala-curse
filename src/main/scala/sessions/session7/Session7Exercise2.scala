package sessions.session7

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Session7Exercise2 {

  def main(args: Array[String]): Unit = {
    val data = (1 to 1000000).toVector
    val result = parallelSum(data)

    result.foreach(sum => println(s"Total sum: $sum"))
    Await.ready(result, 10.seconds)
  }

  // Exercise 2
  // Vector allows splitAt in O(log n) instead of O(n) on List,
  // which makes parallelization actually beneficial.
  def parallelSum(list: Vector[Int]): Future[Int] = {
    val mid = list.length / 2
    val (left, right) = list.splitAt(mid)
    val f1 = Future { left.sum }
    val f2 = Future { right.sum }

    for {
      a <- f1
      b <- f2
    } yield a + b
  }
}
