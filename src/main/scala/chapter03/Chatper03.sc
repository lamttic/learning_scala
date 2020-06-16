// 1
val name: String = "charles"
val message = name match {
  case x if (!x.isEmpty) => x
  case _ => "n/a"
}

// 2
val amount: Double = 3.0
val calculateAmountUsingIfElse = {
  if (amount > 0) "greater"
  else if(amount == 0) "same"
  else "less"
}
val calculateAmount = amount match {
  case x if (x > 0) => "greater"
  case x if (x == 0) => "same"
  case _ => "less"
}

// 3
// 문제가 이해가 안됨.

// 4
for (x <- 1 to 100) {
  print(x + ",")
  if (x % 5 == 0) print("\n")
}

// 5
for (i <- 1 to 100) {
  i match {
    case x if (x % (3 * 5) == 0) => println("typesafe")
    case x if (x % 3 == 0) => println("type")
    case x if (x % 5 == 0) => println("safe")
    case _ => println(i)
  }
}

// 6
for (i <- 1 to 100) { if (i % (3 * 5) == 0) println("typesafe") else if (i % 3 == 0) println("type") else if (i % 5 == 0) println("safe") else println(i)}
