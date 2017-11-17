package main.scala

object Exercise2_4 {

  def main(args: Array[String]): Unit = {
    println(uncurry((a: Int) => (b: Int) => a + b)(10, 5))
  }

  // Saw nothing
  def uncurry[A,B,C](f: A => B => C): (A, B) => C  = {
    (a: A, b: B) => f(a)(b)
  }
}
