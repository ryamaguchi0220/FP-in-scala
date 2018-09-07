package main.scala.error_handling

import scala.collection.immutable.{::, List, Nil}

object Exercise4_4 {
  def sequence[A](as: List[Option[A]]): Option[List[A]] = as match {
    case Nil => Some(Nil)
    case head :: tail => for {
      h <- head
      t <- sequence(tail)
    } yield {
      h :: t
    }
  }
}

