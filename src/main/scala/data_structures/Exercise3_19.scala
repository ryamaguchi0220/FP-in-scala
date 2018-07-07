package main.scala.data_structures

object Exercise3_19 {
  def filterViaFoldRight[A](as: List[A])(predicate: A => Boolean): List[A] = {
    as.foldRight(List.empty[A])((a, acc) => if(predicate(a)) a :: acc else acc)
  }
  def even(as: List[Int]): List[Int] = {
    filterViaFoldRight(as)(_ % 2 == 0)
  }
}

