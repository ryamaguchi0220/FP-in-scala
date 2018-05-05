package main.scala.data_structures

import scala.collection.immutable.{::, List, Nil}

object Exercise3_1 {

  def main(args: Array[String]): Unit = {
    println(s"I expect that ${exercise3_1()} is 3")
  }

  def exercise3_1(): Int = {
    List(1, 2, 3, 4, 5) match {
      case x :: 2 :: 4 :: _ => x
      case Nil => 42
      case x :: y :: 3 :: 4 :: _ => x + y
      case _ => 101
    }
  }
}
