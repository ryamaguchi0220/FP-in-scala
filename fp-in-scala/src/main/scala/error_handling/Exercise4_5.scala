package main.scala.error_handling

import scala.collection.immutable.{::, List, Nil}

object Exercise4_5 {
  def traverse[A, B](as: List[A])(f: A => Option[B]): Option[List[B]] = as match {
    case Nil => Some(Nil)
    case head :: tail => for {
      b <- f(head)
      bs <- traverse(tail)(f)
    } yield {
      b :: bs
    }
  }
}

