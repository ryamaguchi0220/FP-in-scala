package main.scala.monoid

object Exercise10_5 {
  trait Monoid[A] {
    def combine(a: A, b: A): A
    def empty: A
  }

  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B = {
    as.foldLeft(m.empty)((acc, a) => m.combine(acc, f(a)))
  }
}
