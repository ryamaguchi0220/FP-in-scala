package main.scala

object Exercise10_12_WIP {
  trait Monoid[A] {
    def combine(a: A, b: A): A
    def empty: A
  }
  trait Foldable[F[_]] {
    def foldRight[A, B](as: F[A])(z: B)(f: (A, B) => B): B
    def foldLeft[A, B](as: F[A])(z: B)(f: (B, A) => B): B
    def foldMap[A, B](as: F[A])(f: A => B)(m: Monoid[B]): B
    def concatenate[A](as: F[A])(m: Monoid[A]): A
  }

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
      as match {a
        case Nil => m.empty
        case head :: tail => m.combine(head, concatenate(tail)(m))
      }
    }
  }
}

