package main.scala.laziness

import Exercise5_11.unfold

object Exercise5_15 {
  def tails[A](as: Stream[A]): Stream[Stream[A]] = {
    unfold(as) {
      case Cons(head, tail) => Some((Cons(head, tail), tail()))
      case Empty => None
    }.append(Stream(Stream.empty))
  }
}
