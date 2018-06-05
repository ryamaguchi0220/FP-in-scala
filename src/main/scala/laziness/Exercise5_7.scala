package main.scala.laziness

object Exercise5_7 {
  sealed trait Stream[+A] {
    import Stream._
    def foldRight[B](z: B)(f: (A, => B) => B): B = this match {
      case Cons(head, tail) => f(head(), tail().foldRight(z)(f))
      case Empty => z
    }
    def mapViaFoldRight[B](f: A => B): Stream[B] = foldRight(empty[B])((a, b) => cons(f(a), b))
    def filterViaFoldRight(p: A => Boolean): Stream[A] = foldRight(empty[A])((a, b) => if (p(a)) cons(a, b) else b)
    // B'z
    def appendViaFoldRight[B >: A](bs: Stream[B]): Stream[B] = foldRight(bs)((a, b) => cons(a, b))
    def flatMapViaFoldRight[B](f: A => Stream[B]): Stream[B] = foldRight(empty[B])((a, b) => f(a) appendViaFoldRight b)
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

