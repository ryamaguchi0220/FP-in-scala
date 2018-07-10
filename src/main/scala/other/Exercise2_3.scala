package main.scala.other

object Exercise2_3 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => f(a, _)
  }
}
