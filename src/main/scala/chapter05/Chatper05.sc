// 1
val max = (a: Int, b: Int) => if (a > b) a else b
max(2, 3)

def maxHigherOrder(x: (Int, Int, Int), f: (Int, Int) => Int): Int = {
  f(f(x._1, x._2), x._3)
}
maxHigherOrder((1, 5, 3), max)

// 2
val randomMax = {
  val a = util.Random.nextInt()
  val b = util.Random.nextInt()
  if (a > b) a else b
}
randomMax

val randomMin = {
  val a = util.Random.nextInt()
  val b = util.Random.nextInt()
  if (a < b) a else b
}
randomMin

val randomSecond = {
  val a = util.Random.nextInt()
  val b = util.Random.nextInt()
  b
}
randomSecond

// 3
def multiplier(x: Int)(y: Int): Int = {
  x * y
}
val mulThree = multiplier(3) _
mulThree(5)

// 4
// A 타입의 x 값과 A 타입의 값을 받아 리턴을 하지 않는 함수 f를 받음.
// f(x)를 실행 후, x 값을 그대로 반환.
def fzero[A](x: A)(f: A => Unit): A = {
  f(x);
  x
}
val a = fzero(3) {
  s =>
    println(s"$s is printing!")
}
a == 3

// 5
def square(m: Double) = m * m
val sq = square _
sq(3)

// 6
def conditional[A](x: A, p: A => Boolean, f: A => A): A = {
  if (p(x)) f(x) else x
}
val result = conditional[Int](3, {
  x => x > 2
}, {
  x => x + 3
})

// 7
def newConditional[A](x: A, p: A => Boolean, f: A => String): String = {
  if (p(x)) f(x) else x.toString
}
for (i <- 1 to 100) {
  println(newConditional[Int](i, {
    x => x % 3 == 0 || x % 5 == 0
  }, {
    x => if (x % 15 == 0) "typesafe" else if (x % 3 == 0) "type" else "safe"
  }))
}

