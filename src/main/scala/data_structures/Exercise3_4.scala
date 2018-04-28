package main.scala.data_structures

import scala.annotation.tailrec
import scala.collection.immutable.{::, List, Nil}

object Exercise3_4 {

  def main(args: Array[String]): Unit = {
    println(s"I expect that ${drop(List(1, 2, 3), 2)} is List(3)")
    println(s"I expect that ${drop(List(1, 2, 3), 0)} is List(1, 2, 3)")
    println(s"I expect that ${drop(List.empty[Int], 3)} is Nil")
  }

  def drop[A](list: List[A], num: Int): List[A] = {
    @tailrec
    def loop(l: List[A], n: Int): List[A] = {
      (l, n) match {
        case (_, 0) => l
        case (Nil, _) => Nil
        case (::(_, tail), n) => loop(tail, n - 1)
      }
    }
    loop(list, num)
  }
}

