package main.scala.data_structures

import scala.collection.immutable.List

object Exercise3_9 {

  def main(args: Array[String]): Unit = {
    println(s"I expect that ${length(List.empty)} is 0")
    println(s"I expect that ${length(List(1))} is 1")
    println(s"I expect that ${length(List(1, 2, 3))} is 3")
  }

  def length[A](as: List[A]): Int = {
    as.foldRight(0)((_, tAccumulator) => tAccumulator + 1)
  }
}

