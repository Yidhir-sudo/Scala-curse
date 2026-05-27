
📝 **Exercise 1**:

Write a function `describe` that takes an `Any` as parameter and uses `pattern matching` to:
1. print `"Positive number"` if it is an `Int > 0`
2. print `"Empty string"` if it is an empty `String`
3. print `"List of length N"` if it is a `List`
4. otherwise print `"Unknown type"`

--- 
📝 **Exercise 2**:

Write a function `safeSqrt(x: Double): Either[String, Double]` that:
1. returns `"Negative number"` (Left) if `x < 0`
2. otherwise returns the square root (Right)
