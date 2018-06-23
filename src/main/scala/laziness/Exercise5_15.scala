package main.scala.laziness

object Exercise5_15 {
  sealed trait Stream[+A] {
    import Stream._
    def tails: Stream[Stream[A]] = {
      unfold(this) {
        case Cons(head, tail) => Some((Cons(head, tail), tail()))
        case Empty => None
      }.append(Stream(empty))
    }
    def append[B >: A](bs: Stream[B]): Stream[B] = {
      this match {
        case Cons(head, tail) => cons(head(), tail().append(bs))
        case Empty => bs
      }
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
    def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
      case Some((h,s)) => cons(h, unfold(s)(f))
      case None => empty
    }
  }
}
