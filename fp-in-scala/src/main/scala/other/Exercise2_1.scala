package main.scala.other

object Exercise2_1 {
  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, pp: Int, p: Int): Int = if (n == 0) pp else loop(n - 1, p, pp + p)
    loop(n, 0, 1)
  }
}
