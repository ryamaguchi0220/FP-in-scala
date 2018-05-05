package main.scala.data_structures

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
      case head :: tail => reverse(tail) ::: List(head)
    }
  }
  def reverseViaFoldRight[A](as: List[A]): List[A] = as.foldRight(List.empty[A])((a, b) => b ::: List(a))
  def reverseViaFoldLeft[A](as: List[A]): List[A] = as.foldLeft(List.empty[A])((b, a) => a :: b)
}

