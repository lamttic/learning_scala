import scala.collection.mutable.ArrayBuffer

// 1.a
def fibonacci(x: Int): List[Int] = {
  val result = new ArrayBuffer[Int]
  var i = 0
  while (i < x) {
    if (i == 0) result += 0
    else if (i == 1) result += 1
    else result += result(i - 2) + result(i - 1)
    i += 1
  }
  result.toList
}
fibonacci(7)

def fibonacciWithBuilder(x: Int): List[Int] = {
  val builder = List.newBuilder[Int]
  var i = 0
  var left = 0
  var right = 0
  while (i < x) {
    if (i == 0) builder += 0
    else if (i == 1) {
      builder += 1
      right = 1
    }
    else {
      val value = left + right
      builder += value
      left = right
      right = value
    }
    i += 1
  }
  builder.result
}
fibonacciWithBuilder(7)

// 1.b
def appendFibonacci(x: List[Int], count: Int): List[Int] = {
  val fibonacciList = fibonacci(count)
  x ::: fibonacciList
}
appendFibonacci(List(1, 2, 3), 5)

// 1.c
val fibonacciWithStream: LazyList[BigInt] = {
  BigInt(0) #:: BigInt(1) #:: fibonacciWithStream.zip(fibonacciWithStream.tail).map({ n =>
    n._1 + n._2
  })
}
fibonacciWithStream.take(100).toList.zipWithIndex.foreach({
  case (a, b) => if (b > 0 && b % 10 == 0) println(s"$a,") else print(s"$a,")
})

// 1.d
def fibNext(x: BigInt): Option[BigInt] = {
  var i = 0
  var left = 0
  var right = 0
  while (right <= x) {
    if (i == 1) right = 1
    else {
      val value = left + right
      left = right
      right = value
    }
    i += 1
  }

  if (left == x) Option(right) else None
}
fibNext(8).getOrElse(println("input value is not fibonacci element"))
fibNext(9).getOrElse(println("input value is not fibonacci element"))

// 2

import java.io.File

val files = new File("/Users/charles").listFiles
println(files.map(_.getName).filter(!_.startsWith(".")).reduce((a, b) => s"$a;$b"))

// 3
val fileList = files.map(_.getName).filter(!_.startsWith(".")).reduce((a, b) => s"$a;$b")
val groupedPrefix = fileList.split(";").map(_.charAt(0)).groupBy(_.toString)
for (key <- groupedPrefix.keys.toList.sorted) {
  println(s"${key} => ${groupedPrefix.get(key).get.size}")
}

// 4
def multiplier(x: String, y: String): String = {
  (x.toDoubleOption, y.toDoubleOption) match {
    case (Some(x), Some(y)) => (x * y).toString
    case _ => "invalid parameter"
  }
}
multiplier("3.5", "3")
multiplier("3.5", "3fdf")

// 5

import java.lang.System

def monadicProperty(key: String) = {
  util.Try(System.getProperty(key))
}
monadicProperty("java.home")
monadicProperty("blah")

// 6
def getDataFromUrl(url: String) = {
  val s = io.Source.fromURL(url)
  s.getLines().map(_.trim).mkString("")
}

def getCommitHistory(x: (String, String, String)) = {
  val u = s"https://github.com/${x._1}/${x._2}/commits/${x._3}.atom"
  val text = getDataFromUrl(u)

  val pattern = """.*<title>(.+?)</title>.*<updated>(.+?)</updated>.*<author><name>(.+?)</name>.*""".r
  for (entry <- text.split("</entry>")) {
    entry match {
      case pattern(title, updated, author) => println(s"'${title}' is committed by ${author} at ${updated}")
      case _ => None
    }
  }
}

getCommitHistory(("scala", "scala", "2.11.x"))
