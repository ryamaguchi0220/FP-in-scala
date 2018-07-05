package main.scala.data_structures

import scala.collection.immutable.{::, List, Nil}

object Exercise3_10 {
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case head :: tail => foldLeft(tail, f(z, head))(f)
    }
  }
}

