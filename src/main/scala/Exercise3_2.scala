package main.scala

import scala.collection.immutable.{List, Nil, ::}

object Exercise3_2 {

  def main(args: Array[String]): Unit = {
    println(s"I expect that ${tail(List(1, 2, 3))} is List(2, 3)")
    println(s"I expect that ${tail(List())} is Nil")
  }

  def tail[A](list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case ::(_, tail) => tail
    }
  }
}

