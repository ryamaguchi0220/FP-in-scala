package main.scala.laziness

object Exercise5_8 {
  sealed trait Stream[+A]
  case object Empty extends Stream[Nothing]
  case class Cons[+A](head: () => A, tail: () => Stream[A]) extends Stream[A]

  object Stream {
    def cons[A](head: => A, tail: => Stream[A]): Stream[A] = {
      lazy val lazyHead = head
      lazy val lazyTail = tail
      Cons(() => lazyHead, () => lazyTail)
    }
    def constant[A](a: A): Stream[A] = {
      lazy val inf: Stream[A] = cons(a, inf)
      inf
    }
    def empty[A]: Stream[A] = Empty
    def apply[A](as: A*): Stream[A] = if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
  }
}

