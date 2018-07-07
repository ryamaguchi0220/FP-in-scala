package main.scala.data_structures

object Exercise3_21 {
  def filterViaFlatMap[A](as: List[A])(predicate: A => Boolean): List[A] = {
    as.flatMap {
      case a if (predicate(a)) => List(a)
      case _ => Nil
    }
  }
}

