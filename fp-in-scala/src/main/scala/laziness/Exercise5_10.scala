package main.scala.laziness

object Exercise5_10 {
  def fibs(): Stream[Int] = {
    def loop(prevN: Int, n: Int): Stream[Int] = Stream.cons(prevN, loop(prevN = n, n = prevN + n))
    loop(prevN = 0, n = 1)
  }
}

