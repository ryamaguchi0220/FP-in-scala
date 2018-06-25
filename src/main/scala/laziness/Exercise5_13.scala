package main.scala.laziness

object Exercise5_13 {
  sealed trait Stream[+A] {
    import Stream._
    def mapViaUnfold[B](f: A => B): Stream[B] = unfold(this) {
      case Cons(head, tail) => Some((f(head()), tail()))
      case Empty => None
    }
    def takeViaUnfold(n: Int): Stream[A] = unfold((this, n)) {
      case (Cons(head, tail), s) if s > 0 => Some((head(), (tail(), s - 1)))
      case _ => None
    }
    def takeWhileViaUnfold(p: A => Boolean): Stream[A] = unfold(this) {
      case Cons(head, tail) if p(head()) => Some((head(), tail()))
      case _ => None
    }
    def zipWithViaUnfold[B, C](bs: Stream[B])(f: (A, B) => C): Stream[C] = unfold((this, bs)) {
      case (Cons(aHead, aTail), Cons(bHead, bTail)) => Some(f(aHead(), bHead()), (aTail(), bTail()))
      case _ => None
    }
    def zipAllViaUnfold[B](bs: Stream[B]): Stream[(Option[A], Option[B])] = unfold((this, bs)) {
      case (Cons(aHead, aTail), Cons(bHead, bTail)) => Some((Some(aHead()), Some(bHead())), (aTail(), bTail()))
      case (Cons(aHead, aTail), Empty) => Some((Some(aHead()), None), (aTail(), Empty))
      case (Empty, Cons(bHead, bTail)) => Some((None, Some(bHead())), (Empty, bTail()))
      case _ => None
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
