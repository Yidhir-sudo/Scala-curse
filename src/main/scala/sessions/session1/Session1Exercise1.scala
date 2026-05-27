package sessions.session1

// Session 1 – Exercise 1: simple display
object Session1Exercise1 {
  def main(args: Array[String]): Unit = {
    val name: String = "Yidhir" // feel free to change the value
    println(s"Hello $name")

    for (i <- 1 to 10) println(i)
  }
}