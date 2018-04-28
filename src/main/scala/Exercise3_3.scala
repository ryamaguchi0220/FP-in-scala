package main.scala

import scala.collection.immutable.{::, List, Nil}

object Exercise3_3 {

  def main(args: Array[String]): Unit = {
    println(s"I expect that ${setHead(List(1, 2, 3), 4)} is List(4, 2, 3)")
    println(s"I expect that ${setHead(List.empty[Int], 1)} is List(1)")
  }

  def setHead[A](list: List[A], head: A): List[A] = {
    list match {
      case Nil => ::(head, Nil)
      case ::(_, tail) => ::(head, tail)
    }
  }
}

