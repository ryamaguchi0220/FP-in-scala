package main.scala

object Exercise10_6 {

  trait Monoid[A] {
    def combine(a: A, b: A): A
    def empty: A
  }

  def endoAndThenMonoid[A] = new Monoid[A => A] {
    override def combine(a: A => A, b: A => A): A => A = ((x: A) => b(a(x)))
    override def empty: A => A = ((x: A) => x)
  }

  def endoComposeMonoid[A] = new Monoid[A => A] {
    override def combine(a: A => A, b: A => A): A => A = ((x: A) => a(b(x)))
    override def empty: A => A = ((x: A) => x)
  }

  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B = {
    as.foldLeft(m.empty)((acc, a) => m.combine(acc, f(a)))
  }

  def foldLeftViaFoldMap[A, B](as: List[A])(z: B)(f: (B, A) => B): B = {
    foldMap(as, endoComposeMonoid[B])(a => b => f(b, a))(z)
  }

  def foldRightViaFoldMap[A, B](as: List[A])(b: B)(f: (A, B) => B): B = {
    foldMap(as, endoAndThenMonoid[B])(f.curried)(b)
  }
}
