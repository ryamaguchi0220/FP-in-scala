package main.scala.error_handling

import scala.collection.immutable.{::, List, Nil}
import Exercise4_6._

object Exercise4_7 {
  def sequence[E,A](as: List[Either[E, A]]): Either[E, List[A]] = as match {
    case Nil => Right(Nil)
    case head :: tail => for {
      h <- head
      t <- sequence(tail)
    } yield {
      h :: t
    }
  }
  def traverse[A,B,E](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] = as match {
    case Nil => Right(Nil)
    case head :: tail => for {
      b <- f(head)
      bs <- traverse(tail)(f)
    } yield {
      b :: bs
    }
  }
}

