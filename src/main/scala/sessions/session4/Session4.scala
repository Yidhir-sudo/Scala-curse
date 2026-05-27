package sessions.session4

import sessions.session4.classes.{Bike, Car, Rectangle, Vehicle}

object Session4 {

  def main(args: Array[String]): Unit = {
    // Exercise 1 sample usage
    val rect = new Rectangle(5.0, 3.0)
    println(s"Area: ${rect.area}")           // Area: 15.0
    println(s"Perimeter: ${rect.perimeter}") // Perimeter: 16.0

    // Exercise 2 sample usage
    val vehicles: List[Vehicle] = List(new Car(), new Bike(), new Vehicle())

    vehicles.foreach(_.move())
  }
}
