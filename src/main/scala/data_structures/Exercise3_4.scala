package main.scala.data_structures

import scala.collection.immutable.{::, List, Nil}

object Exercise3_4 {
  @annotation.tailrec
  def drop[A](list: List[A], num: Int): List[A] = {
    (list, num) match {
      case (Nil, _) => Nil
      case (_, n) if (n <= 0) => list
      case (_ :: tail, n) => drop(tail, n - 1)
    }
  }
}

