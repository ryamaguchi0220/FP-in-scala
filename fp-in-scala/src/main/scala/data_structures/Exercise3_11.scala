package main.scala.data_structures

import scala.collection.immutable.List

object Exercise3_11 {
  def sumViaFoldLeft(as: List[Int]): Int = {
    as.foldLeft(0)(_ + _)
  }
  def productViaFoldLeft(as: List[Double]): Double = {
    as.foldLeft(1.0)(_ * _)
  }
  def lengthViaFoldLeft[A](as: List[A]): Int = {
    as.foldLeft(0)((accumulator, _) => accumulator + 1)
  }
}

