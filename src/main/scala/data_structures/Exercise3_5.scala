package main.scala.data_structures

import scala.annotation.tailrec
import scala.collection.immutable.{::, List, Nil}

object Exercise3_5 {

  @tailrec
  def dropWhile[A](list: List[A])(predicate: A => Boolean): List[A] = {
    list match {
      case Nil => Nil
      case head :: tail => if(predicate(head)) dropWhile(tail)(predicate) else list
    }
  }
}

