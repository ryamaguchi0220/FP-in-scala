package main.scala.data_structures

import scala.collection.immutable.List

object Exercise3_15 {
  def append[A](left: List[A], right: List[A]): List[A] = {
    left.foldRight(right)(_ :: _)
  }
  def flattenModoki[A](ass: List[List[A]]): List[A] = {
    ass.foldLeft(List.empty[A])(append)
  }
}

