package main.scala.laziness

import Exercise5_11.unfold

object Exercise5_12 {
  def fibsViaUnfold(): Stream[Int] = unfold((0, 1)) { case (pre, i) => Some((pre, (i, pre + i))) }
  def fromViaUnfold(n: Int): Stream[Int] = unfold(n)(s => Some((s, s + 1)))
  def constantViaUnfold[A](a: A): Stream[A] = unfold(a)(s => Some((s, s)))
  val onesViaUnfold: Stream[Int] = unfold(1)(s => Some((s, s)))
}
