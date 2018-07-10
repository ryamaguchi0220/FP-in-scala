package main.scala.monoid

object Exercise10_2 {
  def endoMonoid[A] = new Monoid[A => A] {
    override def combine(a: A => A, b: A => A): A => A = ((x: A) => b(a(x)))
    override def empty: A => A = ((x: A) => x)
  }
  def endoMonoid[A] = new Monoid[A => A] {
    override def combine(a: A => A, b: A => A): A => A = ((x: A) => a(b(x)))
    override def empty: A => A = ((x: A) => x)
  }
}

