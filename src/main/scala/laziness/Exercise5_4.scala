package main.scala.laziness

object Exercise5_4 {
  sealed trait Stream[+A] {
    def forAll(p: A => Boolean): Boolean = this match {
      case Cons(head, tail) => p(head()) && tail().forAll(p)
      case Empty => true
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

