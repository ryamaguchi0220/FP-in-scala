package main.scala.data_structures

import scala.collection.immutable.List

object Exercise3_9 {
  def length[A](as: List[A]): Int = {
    as.foldRight(0)((_, tAccumulator) => tAccumulator + 1)
  }
}

