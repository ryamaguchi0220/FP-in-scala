package main.scala.other

import scala.annotation.tailrec

object Exercise2_1 {

  def main(args: Array[String]): Unit = {
    println(fib(10))
  }

  def fib(n: Int): Int = {
    @tailrec
    def loop(n: Int, pp: Int, p: Int): Int = if (n == 0) pp else loop(n - 1, p, pp + p)
    loop(n, 0, 1)
  }
}
