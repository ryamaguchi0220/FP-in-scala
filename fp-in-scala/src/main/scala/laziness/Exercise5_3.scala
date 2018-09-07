package main.scala.laziness

object Exercise5_3 {
  def takeWhile[A](as: Stream[A])(p: A => Boolean): Stream[A] = as match {
    case Cons(head, tail) if p(head()) =>  Stream.cons(head(), takeWhile(tail())(p))
    case Empty => as
  }
}

