package main.scala.data_structures

import scala.collection.immutable.{::, List, Nil}

object Exercise3_3 {
  def setHead[A](list: List[A], head: A): List[A] = {
    list match {
      case Nil => List(head)
      case _ :: tail => head :: tail
    }
  }
}

