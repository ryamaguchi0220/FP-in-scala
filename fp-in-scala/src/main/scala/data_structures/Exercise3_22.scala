package main.scala.data_structures

object Exercise3_22 {
  def addEachOther(xs: List[Int], ys: List[Int]): List[Int] = {
    (xs, ys) match {
      case (xHead :: xTail, yHead :: yTail) => xHead + yHead :: addEachOther(xTail, yTail)
      case (_ :: _, Nil) => xs
      case (Nil, _ :: _) => ys
      case (Nil, Nil) => Nil
    }
  }
}

