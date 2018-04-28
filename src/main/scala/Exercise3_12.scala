package main.scala

import scala.collection.immutable.{::, List, Nil}

object Exercise3_12 {
  def main(args: Array[String]): Unit = {
    println(s"I expect that ${reverse(List.empty)} is List()")
    println(s"I expect that ${reverse(List(1))} is List(1)")
    println(s"I expect that ${reverse(List(1, 2, 3))} is List(3, 2, 1)")
  }

  def reverse[A](as: List[A]): List[A] = {
    as match {
      case Nil => Nil
      case head :: tail => tail.foldLeft(List(head))((b, a) => a :: b)
    }
  }
}

