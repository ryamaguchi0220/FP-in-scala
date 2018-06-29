package main.scala.laziness

object Exercise5_16 {
  sealed trait Stream[+A] {
    import Stream._
    def scanRight[B](z: B)(f: (A, B) => B): Stream[B] = this match {
      case Cons(head, tail) =>
        val b = tail().scanRight(z)(f)
        cons(f(head(), b.headOption.get), b)
      case Empty => Stream(z)
    }
    def headOption: Option[A] = this match {
      case Cons(head, _) => Some(head())
      case Empty => None
    }
  }
  case object Empty extends Stream[Nothing]
  case class Cons[+A](head: () => A, tail: () => Stream[A]) extends Stream[A]

  object Stream {
    def cons[A](head: => A, tail: => Stream[A]): Stream[A] = {
      lazy val lazyHead = head
      lazy val lazyTail = tail
      Cons(() => lazyHead, () => lazyTail)
    }
    def empty[A]: Stream[A] = Empty
    def apply[A](as: A*): Stream[A] = if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
  }
}
