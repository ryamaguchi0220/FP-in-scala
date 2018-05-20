package main.scala.error_handling

object Exercise4_6 {
  sealed trait Either[+E, +A] {
    def map[B](f: A => B): Either[E, B] = this match {
      case Left(e) => Left(e)
      case Right(a) => Right(f(a))
    }
    def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
      case Left(e) => Left(e)
      case Right(a) => f(a)
    }
    def orElse[EE >: E, B >: A](eb: => Either[EE, B]): Either[EE, B] = this match {
      case Left(_) => eb
      case Right(a) => Right(a)
    }
    def map2[EE >: E, B, C](eb: Either[EE, B])(f: (A, B) => C): Either[EE, C] = {
      for {
        a <- this
        b <- eb
      } yield {
        f(a, b)
      }
    }
  }

  case class Right[+A](val x: A) extends Either[Nothing, A]
  case class Left[+E](val x: E) extends Either[E, Nothing]
}

