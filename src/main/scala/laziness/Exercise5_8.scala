package main.scala.laziness

object Exercise5_8 {
  def constant[A](a: A): Stream[A] = {
    lazy val inf: Stream[A] = Stream.cons(a, inf)
    inf
  }
}

