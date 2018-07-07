package main.scala.data_structures

object Exercise3_23 {
  def zipWith[A,B,C](xs: List[A], ys: List[B])(f: (A, B) => C): List[C] = {
    (xs, ys) match {
      case (xHead :: xTail, yHead :: yTail) => f(xHead, yHead) :: zipWith(xTail, yTail)(f)
      case _ => Nil
    }
  }
}

