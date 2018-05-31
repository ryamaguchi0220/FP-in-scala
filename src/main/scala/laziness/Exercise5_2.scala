package main.scala.laziness

object Exercise5_2 {
  sealed trait Stream[+A] {
    import Stream._
    def take(n: Int): Stream[A] = this match {
      case Cons(head, tail) if (n > 0) => cons(head(), tail().take(n - 1))
      case _ => Empty
    }
    @annotation.tailrec
    final def drop(n: Int): Stream[A] = this match {
      case Cons(_, tail) if (n > 0) => tail().drop(n - 1)
      case _ => this
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

