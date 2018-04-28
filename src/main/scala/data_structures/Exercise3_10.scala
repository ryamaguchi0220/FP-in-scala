package main.scala.data_structures

import scala.collection.immutable.{::, List, Nil}

object Exercise3_10 {

  def main(args: Array[String]): Unit = {
    println(s"I expect that ${foldLeft(List.empty, 10)(_ + _)} is 10")
    println(s"I expect that ${foldLeft(List(1, 2, 3), 100)(_ + _)} is 106")
  }

  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case head :: tail => foldLeft(tail, f(z, head))(f)
    }
  }
}

