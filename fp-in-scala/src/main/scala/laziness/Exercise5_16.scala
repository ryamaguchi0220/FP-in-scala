package main.scala.laziness

object Exercise5_16 {
  def scanRight[A, B](as: Stream[A], z: B)(f: (A, B) => B): Stream[B] = as match {
    case Cons(head, tail) =>
      val b = scanRight(tail(), z)(f)
      Stream.cons(f(head(), b.headOption.get), b)
    case Empty => Stream(z)
  }
}
