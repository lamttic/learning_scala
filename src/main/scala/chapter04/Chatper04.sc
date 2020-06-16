// 1
def getCircleArea(radius: Int) = {
  Math.PI * radius * radius
}
getCircleArea(3)

// 2
def getCircleAreaFromString(radius: String) = {
  Math.PI * radius.toInt * radius.toInt
}
getCircleAreaFromString("3")
//getCircleAreaFromString("")

// 3
@annotation.tailrec
def recursiveFive(currentValue: Int = 5): Unit = {
  println(currentValue)
  if (currentValue < 50) recursiveFive(currentValue + 5)
}
recursiveFive()

// 4
// 문제를 이해하지 못함.

// 5
def power(x: Int, n: Int) = {
  math.pow(x, n)
}
power(2, 4)

@annotation.tailrec
def powerManual(x: Int, n: Int, total: Double = 1.0): Double = {
  if (n == 0) total
  else powerManual(x, n - 1, total * x)
}
powerManual(2, 1)

// 6
def getDistance(p1: (Int, Int), p2: (Int, Int)): (Int, Int) = {
  (Math.abs(p1._1 - p2._1), Math.abs(p1._2 - p2._2))
}
getDistance((1,2), (3,4))

// 7
def getOrderedTuple[A, B](x: (A, B)) = {
  if (x._2.isInstanceOf[Int]) (x._2, x._1)
  else x
}
getOrderedTuple((123, "1235"))
getOrderedTuple(("test", 123))

// 8
def getStringTuple[A, B, C](x: (A, B, C)) = {
  (x._1, x._1.toString, x._2, x._2.toString, x._3, x._3.toString)
}
getStringTuple(true, 22.25, "yes")

