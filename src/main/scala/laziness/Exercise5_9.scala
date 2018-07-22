package main.scala.laziness

object Exercise5_9 {
  def from(n: Int): Stream[Int] = Stream.cons(n, from(n + 1))
}

