package main.scala.data_structures

import scala.collection.immutable.{::, List, Nil}

object Exercise3_6 {
  def init[A](list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case _ :: Nil => Nil
      case head :: tail => head :: init(tail)
    }
  }
}

