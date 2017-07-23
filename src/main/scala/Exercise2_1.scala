package main.scala

object Exercise2_1 {

  def main(args: Array[String]): Unit = {
    println(fib(10))
  }

  def fib(n: Int): Int = {
    def loop(n: Int): Int = {
      n match {
        case 0 => 0
        case 1 => 1
        case _ => loop(n - 1) + loop (n - 2)
      }
    }
    loop(n)
  }
}
