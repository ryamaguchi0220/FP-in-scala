package main.scala.laziness

object Exercise5_2 {
  def take[A](as: Stream[A], n: Int): Stream[A] = as match {
    case Cons(head, tail) if (n > 0) => Stream.cons(head(), take(tail(), n - 1))
    case _ => Empty
  }
  @annotation.tailrec
  final def drop[A](as: Stream[A], n: Int): Stream[A] = as match {
    case Cons(_, tail) if (n > 0) => drop(tail(), n - 1)
    case _ => as
  }
}

