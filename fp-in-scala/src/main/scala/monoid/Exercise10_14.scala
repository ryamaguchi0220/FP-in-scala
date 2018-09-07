package main.scala.monoid

object Exercise10_14 {
  val foldableOption = new Foldable[Option] {
    override def foldRight[A, B](as: Option[A])(z: B)(f: (A, B) => B): B = {
      as match {
        case None => z
        case Some(a) => f(a, z)
      }
    }
    override def foldLeft[A, B](as: Option[A])(z: B)(f: (B, A) => B): B = {
      as match {
        case None => z
        case Some(a) => f(z, a)
      }
    }
    override def foldMap[A, B](as: Option[A])(f: A => B)(m: Monoid[B]): B = {
      as match {
        case None => m.empty
        case Some(a) => f(a)
      }
    }
    override def concatenate[A](as: Option[A])(m: Monoid[A]): A = {
      as match {
        case None => m.empty
        case Some(a) => a
      }
    }
  }
}

