package main.scala.data_structures

import scala.collection.immutable.List
import Exercise3_10.foldLeft

object Exercise3_11 {
  def sumViaFoldLeft(as: List[Int]): Int = {
    foldLeft(as, 0)(_ + _)
  }
  def productViaFoldLeft(as: List[Double]): Double = {
    foldLeft(as, 1.0)(_ * _)
  }
  def lengthViaFoldLeft[A](as: List[A]): Int = {
    foldLeft(as, 0)((accumulator, _) => accumulator + 1)
  }
}

