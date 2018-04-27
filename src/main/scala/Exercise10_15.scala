package main.scala

object Exercise10_15 {
  trait Monoid[A] {
    def combine(a: A, b: A): A
    def empty: A
  }
  def listMonoid[A] = new Monoid[List[A]] {
    def combine(a: List[A], b: List[A]): List[A] = {
      a match {
        case Nil => b
        case head :: tail => head :: combine(tail, b)
      }
    }
    def empty: List[A] = List.empty[A]
  }

  trait Foldable[F[_]] {
    def foldRight[A, B](as: F[A])(z: B)(f: (A, B) => B): B
    def foldLeft[A, B](as: F[A])(z: B)(f: (B, A) => B): B
    def foldMap[A, B](as: F[A])(f: A => B)(m: Monoid[B]): B
    def concatenate[A](as: F[A])(m: Monoid[A]): A
    def toList[A](fa: F[A]): List[A] = foldMap[A, List[A]](fa)(List(_))(listMonoid[A])
    def toList[A](fa: F[A]): List[A] = foldRight(fa)(List.empty[A])(_ :: _)
  }
}

