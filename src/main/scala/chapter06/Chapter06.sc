import scala.collection.mutable.ListBuffer

// 1
val oddList = Range(1, 40).filter(_ % 2 == 1).map(_.toLong).toList
val oddVector = for (i <- 1 to 40 if i % 2 == 1) yield i
val oddList2 = oddVector.map(_.toLong).toList

// 2
def factors(x: Int): List[Int] = {
  val factorVector = for (i <- 2 until x if x % i == 0) yield i
  factorVector.toList
}
factors(16)

def factorList(x: List[Int]): List[Int] = {
  def getFactorList(element: Int): List[Int] = {
    val factorVector = for (i <- 2 until element if element % i == 0) yield i
    factorVector.toList
  }

  x.map(getFactorList(_)).reduce(_ ::: _)
}
factorList(List(15, 16, 20))

// 3
def first[A](items: List[A], count: Int): List[A] = {
  var buf = new ListBuffer[A]
  for (i <- 0 until Math.min(count, items.size)) {
    buf += items(i)
  }
  buf.toList
}
first(List('1', '2', '3'), 0)
first(List('1', '2', '3'), 2)
first(List('1', '2', '3'), 1)
first(List('1', '2', '3'), 9)

// 4
def longestString[A](x: List[A]): A = {
  x.reduce { (a, b) =>
    if (a.toString.size > b.toString.size) a else b
  }
}
longestString(List("1123", "54757", "349683", "asdf"))
longestString(List(1123, 54757, 349683))

// 5
def reversed[A](x: List[A]): List[A] = {
  var buf = new ListBuffer[A]
  var target = x
  while (!target.isEmpty) {
    buf += target.last
    target = target.take(target.size - 1)
  }
  buf.toList
}
val reversedList = reversed(List(1, 2, 3, 4, 5, 6))

// 6
def makeListTuple(x: List[String]): (List[String], List[String]) = {
  x.partition(element => {
    element.reverse == element
  })
}
makeListTuple(List("racecar", "1235", "carrac", "facebook"))
