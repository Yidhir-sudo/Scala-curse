package exams

case class Record(city: String, date: String, temperature: Double, humidity: Double)

object MockExamSolution {

  def main(args: Array[String]): Unit = {
    // Sample data
    val data = List(
      Record("Paris", "2025-03-01", 12.3, 0.65),
      Record("Paris", "2025-03-02", 15.1, 0.60),
      Record("Lyon", "2025-03-01", 10.5, 0.70),
      Record("Lyon", "2025-03-02", 9.8, 0.75),
      Record("Marseille", "2025-03-01", 17.2, 0.55),
      Record("Marseille", "2025-03-02", 18.4, 0.50)
    )

    val tempMin: Int = 0
    val tempMax: Int = 10

    println(s"1) The average temperature across all records is: ${averageTemperature(data).getOrElse("Empty list")}")
    println(s"2) The average temperature by city is: ${averageTemperatureByCity(data).mkString(",")}")
    println(s"3) The city with the highest average temperature is: ${hottestCity(data).getOrElse("Empty list")}")
    println(s"4) The new list: ${normalizeTemperatures(data).mkString(",")}")
    println(s"5) The records whose temperature is between $tempMin and $tempMax are: " +
      s"${filterByTemperature(data, tempMin, tempMax).mkString(",")}")
    println(s"6) The city with the largest gap between max and min temperature is: " +
      s"${cityWithMostVariation(data).getOrElse("Empty list")}")
    println(s"7) Daily summary: ${dailySummary(data).mkString(",")}")
  }

  // Helper: average of a numeric field across a collection of Record in a single pass.
  private def average(records: Seq[Record])(f: Record => Double): Option[Double] =
    if (records.isEmpty) None
    else Some(records.iterator.map(f).sum / records.size)

  // Question 1
  def averageTemperature(data: List[Record]): Option[Double] =
    average(data)(_.temperature)

  // Question 2: average temperature by city
  def averageTemperatureByCity(data: List[Record]): Map[String, Double] =
    data
      .groupBy(_.city) // Map(city -> List[Record])
      .view
      .mapValues(records => records.iterator.map(_.temperature).sum / records.size)
      .toMap

  // Question 3
  def hottestCity(data: List[Record]): Option[String] = {
    val avgByCity = averageTemperatureByCity(data)
    if (avgByCity.isEmpty) None
    else Some(avgByCity.maxBy(_._2)._1)
  }

  // Question 4
  def normalizeTemperatures(data: List[Record]): List[Record] =
    data.map(r => r.copy(temperature = r.temperature * 9 / 5 + 32))

  // Question 5
  def filterByTemperature(data: List[Record], min: Double, max: Double): List[Record] =
    data.filter(r => r.temperature >= min && r.temperature <= max)

  // Question 6: single pass to compute min and max simultaneously.
  def cityWithMostVariation(data: List[Record]): Option[String] = {
    val cityVariation: Map[String, Double] = data
      .groupBy(_.city)
      .view
      .mapValues { records =>
        val (min, max) = records.foldLeft((Double.MaxValue, Double.MinValue)) {
          case ((mn, mx), r) => (math.min(mn, r.temperature), math.max(mx, r.temperature))
        }
        max - min
      }
      .toMap

    if (cityVariation.isEmpty) None
    else Some(cityVariation.maxBy(_._2)._1)
  }

  // Question 7: single fold for temperature and humidity.
  def dailySummary(data: List[Record]): Map[String, (Double, Double)] =
    data
      .groupBy(_.date)
      .view
      .mapValues { records =>
        val (sumT, sumH) = records.foldLeft((0.0, 0.0)) {
          case ((t, h), r) => (t + r.temperature, h + r.humidity)
        }
        val n = records.size
        (sumT / n, sumH / n)
      }
      .toMap
}
