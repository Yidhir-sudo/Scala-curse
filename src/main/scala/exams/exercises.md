# Mock Exam — Weather Records

📝 **Context**

You are given a dataset of weather observations. Each observation is modelled by the
following case class:

```scala
case class Record(city: String, date: String, temperature: Double, humidity: Double)
```

A sample dataset:

```scala
val data = List(
  Record("Paris",     "2025-03-01", 12.3, 0.65),
  Record("Paris",     "2025-03-02", 15.1, 0.60),
  Record("Lyon",      "2025-03-01", 10.5, 0.70),
  Record("Lyon",      "2025-03-02",  9.8, 0.75),
  Record("Marseille", "2025-03-01", 17.2, 0.55),
  Record("Marseille", "2025-03-02", 18.4, 0.50)
)
```

Implement the following functions in an idiomatic, **immutable**, functional style.
Return an `Option` (or `Either`) when the result can be undefined (e.g. empty input)
rather than a sentinel value.

---

## 🧮 Question 1 — Global average temperature

Write a function:

```scala
def averageTemperature(data: List[Record]): Option[Double]
```

It returns the average temperature across **all** records, or `None` if the list is
empty.

---

## 🏙️ Question 2 — Average temperature by city

Write a function:

```scala
def averageTemperatureByCity(data: List[Record]): Map[String, Double]
```

It returns a `Map` associating each city with its average temperature.

**Hint:** `groupBy` + `mapValues`.

---

## 🔥 Question 3 — Hottest city

Write a function:

```scala
def hottestCity(data: List[Record]): Option[String]
```

It returns the name of the city with the highest average temperature, or `None` if the
list is empty.

---

## 🌡️ Question 4 — Normalize temperatures (°C → °F)

Write a function:

```scala
def normalizeTemperatures(data: List[Record]): List[Record]
```

It returns a new list where every record's temperature has been converted from Celsius
to Fahrenheit using the formula:

$$F = C \times \frac{9}{5} + 32$$

The other fields (`city`, `date`, `humidity`) must be preserved.

---

## 🎯 Question 5 — Filter by temperature range

Write a function:

```scala
def filterByTemperature(data: List[Record], min: Double, max: Double): List[Record]
```

It returns the records whose temperature is **between `min` and `max` (inclusive)**.

---

## 📈 Question 6 — City with the largest temperature variation

Write a function:

```scala
def cityWithMostVariation(data: List[Record]): Option[String]
```

For each city, compute the difference between its maximum and minimum recorded
temperature. Return the name of the city with the **largest** such variation, or `None`
if the list is empty.

**Bonus / optimization:** compute `min` and `max` in a **single pass** (e.g. with
`foldLeft`) instead of two traversals.

---

## 📅 Question 7 — Daily summary

Write a function:

```scala
def dailySummary(data: List[Record]): Map[String, (Double, Double)]
```

It returns a `Map` associating each date with a tuple `(averageTemperature,
averageHumidity)` for that day.

**Bonus / optimization:** compute both averages in a **single fold** over the records
of the day.

---

## ✅ Expected program output

A `main` method should exercise the seven functions and print results in the form:

```text
1) The average temperature across all records is: ...
2) The average temperature by city is: ...
3) The city with the highest average temperature is: ...
4) The new list: ...
5) The records whose temperature is between 0 and 10 are: ...
6) The city with the largest gap between max and min temperature is: ...
7) Daily summary: ...
```

---

## 📦 Deliverable

A single file `MockExam.scala` placed in `src/main/scala/exams/` that compiles with
`sbt compile` and runs via:

```bash
sbt "runMain exams.MockExam"
```

> A reference solution is available in
> [`MockExamSolution.scala`](MockExamSolution.scala). Try the exam **first** without
> looking at it.
