package main.scala.data_structures

import scala.collection.immutable.{::, List, Nil}

object Exercise3_2 {
  def tail[A](list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case _ :: tail => tail
    }
  }
}

