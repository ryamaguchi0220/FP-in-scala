package main.scala.laziness

object Exercise5_5 {
  sealed trait Stream[+A] {
    import Stream._
    def foldRight[B](z: B)(f: (A, => B) => B): B = this match {
      case Cons(head, tail) => f(head(), tail().foldRight(z)(f))
      case Empty => z
    }
    def takeWhileViaFoldRight(p: A => Boolean): Stream[A] = this.foldRight(empty[A])((a, b) => if (p(a)) cons(a, b) else empty)
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

