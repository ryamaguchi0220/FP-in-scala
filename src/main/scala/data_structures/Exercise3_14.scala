package main.scala.data_structures

import scala.collection.immutable.List

object Exercise3_14 {
  def appendViaFoldRight[A](left: List[A], right: List[A]): List[A] = {
    left.foldRight(right)(_ :: _)
  }

  def appendViaFoldLeft[A](left: List[A], right: List[A]): List[A] = {
    left.reverse.foldLeft(right)((b, a) => a :: b)
  }
}

