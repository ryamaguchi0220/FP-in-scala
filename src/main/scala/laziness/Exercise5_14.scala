package main.scala.laziness

object Exercise5_14 {
  sealed trait Stream[+A] {
    def startWith[B](as: Stream[B]): Boolean = (this, as) match {
      case (Cons(head1, tail1), Cons(head2, tail2)) if head1() == head2() => tail1().startWith(tail2())
      case (_, Empty) => true
      case _ => false
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
    def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = {
      @annotation.tailrec
      def loop(as: Stream[A], lz: S): Stream[A] = {
        f(lz) match {
          case Some((a, s)) => loop(cons(a, as), s)
          case None => as
        }
      }
      loop(empty, z)
    }
  }
}
