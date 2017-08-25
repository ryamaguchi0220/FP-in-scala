package main.scala

object Exercise2_3 {

  def main(args: Array[String]): Unit = {
    println(curry((a: Int, b: Int) => a + b).(5).(5))
  }

  def curry[A,B,C](f: (A, B) => C): A => (B => C) == {
    (a: A) => f(a, _)
  }
}
