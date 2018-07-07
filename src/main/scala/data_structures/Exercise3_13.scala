package main.scala.data_structures

import scala.collection.immutable.List

object Exercise3_13 {
  // This can avoid SOF, but O(2N)
  def foldRightViaFoldLeft[A, B](as: List[A])(z: B)(f: (A, B) => B): B = {
    as.reverse.foldLeft(z)((b, a) => f(a, b))
  }
  def foldLeftViaFoldRight[A, B](as: List[A])(z: B)(f: (B, A) => B): B = {
    as.reverse.foldRight(z)((a, b) => f(b, a))
  }
}

