package main.scala

object Exercise2_5 {

  def main(args: Array[String]): Unit = {
    println(compose((b: Int) => b * 10, (a: Int) => a + 10)(10))
  }

  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }
}
