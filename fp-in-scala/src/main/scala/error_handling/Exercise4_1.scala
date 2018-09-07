package main.scala.error_handling

object Exercise4_1 {
  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B] = this match {
      case None => None
      case Some(v) => Some(f(v))
    }
    def flatMap[B](f: A => Option[B]): Option[B] = this match {
      case None => None
      case Some(v) => f(v)
    }
    def getOrElse[B >: A](default: => B): B = this match {
      case None => default
      case Some(v) => v
    }
    def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
      case None => ob
      case some => some
    }
    def filter(f: A => Boolean): Option[A] = this match {
      case None => None
      case Some(v) => if (f(v)) Some(v) else None
    }
  }

  case class Some[+A](val x: A) extends Option[A]
  case object None extends Option[Nothing]
}

