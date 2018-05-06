package main.scala.data_structures

import scala.annotation.tailrec
import scala.collection.immutable.{::, List, Nil}

object Exercise3_5 {

  def main(args: Array[String]): Unit = {
    println(s"I expect that ${dropWhile(List(1, 2, 3))(_ <= 2)} is List(3)")
    println(s"I expect that ${dropWhile(List(1, 2, 3))(_ => true)} is Nil")
    println(s"I expect that ${dropWhile(List.empty[Int])(_ => true)} is Nil")
  }

  @tailrec
  def dropWhile[A](list: List[A])(predicate: A => Boolean): List[A] = {
    list match {
      case Nil => Nil
      case head :: tail => if(predicate(head)) dropWhile(tail)(predicate) else list
    }
  }
}

