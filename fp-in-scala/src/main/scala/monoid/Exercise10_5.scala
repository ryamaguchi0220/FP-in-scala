package main.scala.monoid

object Exercise10_5 {
  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B = {
    as.foldLeft(m.empty)((acc, a) => m.combine(acc, f(a)))
  }
}
