package main.scala.data_str

object Exercise3_20 {
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = {
    as match {
      case Nil => Nil
      case head :: tail => f(head) ::: flatMap(tail)(f)
    }
  }
}

