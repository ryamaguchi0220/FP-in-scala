package main.scala.laziness

import Exercise5_11.unfold

object Exercise5_13 {
  def mapViaUnfold[A, B](as: Stream[A])(f: A => B): Stream[B] = unfold(as) {
    case Cons(head, tail) => Some((f(head()), tail()))
    case Empty => None
  }
  def takeViaUnfold[A](as: Stream[A], n: Int): Stream[A] = unfold((as, n)) {
    case (Cons(head, tail), s) if s > 0 => Some((head(), (tail(), s - 1)))
    case _ => None
  }
  def takeWhileViaUnfold[A](as: Stream[A])(p: A => Boolean): Stream[A] = unfold(as) {
    case Cons(head, tail) if p(head()) => Some((head(), tail()))
    case _ => None
  }
  def zipWithViaUnfold[A, B, C](as: Stream[A], bs: Stream[B])(f: (A, B) => C): Stream[C] = unfold((as, bs)) {
    case (Cons(aHead, aTail), Cons(bHead, bTail)) => Some(f(aHead(), bHead()), (aTail(), bTail()))
    case _ => None
  }
  def zipAllViaUnfold[A, B](as: Stream[A], bs: Stream[B]): Stream[(Option[A], Option[B])] = unfold((as, bs)) {
    case (Cons(aHead, aTail), Cons(bHead, bTail)) => Some((Some(aHead()), Some(bHead())), (aTail(), bTail()))
    case (Cons(aHead, aTail), Empty) => Some((Some(aHead()), None), (aTail(), Empty))
    case (Empty, Cons(bHead, bTail)) => Some((None, Some(bHead())), (Empty, bTail()))
    case _ => None
  }
}
