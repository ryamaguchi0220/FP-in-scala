package main.scala.monad

object Exercise11_1 {
  trait Monad[F[_]] {
    def unit[A](a: => A): F[A]
    def flatMap[A, B](ma: F[A])(f: A => F[B]): F[B]
    def map[A, B](ma: F[A])(f: A => B): F[B] = flatMap(ma)(a => unit(f(a)))
    def map2[A, B, C](ma: F[A], mb: F[B])(f: (A, B) => C): F[C] = flatMap(ma)(a => map(mb)(b => f(a, b)))
  }
  val optionIsMonad = new Monad[Option] {
    override def unit[A](a: => A): Option[A] = Some(a)
    override def flatMap[A, B](ma: Option[A])(f: A => Option[B]): Option[B] = ma match {
      case None => None
      case Some(a) => f(a)
    }
  }
  val listIsMonad = new Monad[List] {
    override def unit[A](a: => A): List[A] = a :: Nil
    override def flatMap[A, B](ma: List[A])(f: A => List[B]): List[B] = ma match {
      case Nil => Nil
      case head :: tail => f(head) ::: flatMap(tail)(f)
    }
  }

  // TODO parIsMonad
  // TODO ParserIsMonad
  // TODO StreamIsMonad
}

