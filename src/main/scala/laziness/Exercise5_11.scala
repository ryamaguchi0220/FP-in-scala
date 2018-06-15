package main.scala.laziness

object Exercise5_11 {
  sealed trait Stream[+A]
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
