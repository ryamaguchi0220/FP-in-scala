package main.scala.laziness

object Exercise5_12 {
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
    def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
      case Some((h,s)) => cons(h, unfold(s)(f))
      case None => empty
    }
    def fibsViaUnfold(): Stream[Int] = unfold((0, 1)) { case (pre, i) => Some((pre, (i, pre + i))) }
    def fromViaUnfold(n: Int): Stream[Int] = unfold(n)(s => Some((s, s + 1)))
    def constantViaUnfold[A](a: A): Stream[A] = unfold(a)(s => Some((s, s)))
    val onesViaUnfold: Stream[Int] = unfold(1)(s => Some((s, s)))
  }
}
