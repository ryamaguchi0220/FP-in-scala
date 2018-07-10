package main.scala.monoid

object Exercise10_12_WIP {
  val foldableList = new Foldable[List] {
    override def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B = {
      as match {
        case Nil => z
        case head :: tail => f(head, foldRight(tail)(z)(f))
      }
    }
    override def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B): B = {
      as match {
        case Nil => z
        case head :: tail => foldLeft(tail)(f(z, head))(f)
      }
    }
    override def foldMap[A, B](as: List[A])(f: A => B)(m: Monoid[B]): B = {
      as match {
        case Nil => m.empty
        case head :: tail  => m.combine(f(head), foldMap(tail)(f)(m))
      }
    }
    override def concatenate[A](as: List[A])(m: Monoid[A]): A = {
      as match {
        case Nil => m.empty
        case head :: tail => m.combine(head, concatenate(tail)(m))
      }
    }
  }
}

