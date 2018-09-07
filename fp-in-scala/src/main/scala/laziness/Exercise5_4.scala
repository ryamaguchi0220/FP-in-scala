package main.scala.laziness

object Exercise5_4 {
  def forAll[A](as: Stream[A])(p: A => Boolean): Boolean = as match {
    case Cons(head, tail) => p(head()) && forAll(tail())(p)
    case Empty => true
  }
}

