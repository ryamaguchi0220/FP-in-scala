package main.scala.data_structures

object Exercise3_21 {
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = {
    as match {
      case Nil => Nil
      case head :: tail => f(head) ::: flatMap(tail)(f)
    }
  }

  def filterViaFlatMap[A](as: List[A])(predicate: A => Boolean): List[A] = {
    flatMap(as) {
      case a if (predicate(a)) => List(a)
      case _ => Nil
    }
  }
}

