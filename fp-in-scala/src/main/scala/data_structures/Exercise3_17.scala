package main.scala.data_structures

object Exercise3_17 {
  def dsToStr(doubles: List[Double]): List[String] = {
    @annotation.tailrec
    def loop(s: List[Double], accumulator: List[String]): List[String] = {
      s match {
        case head :: tail => loop(tail, head.toString :: accumulator)
        case Nil => accumulator
      }
    }
    loop(doubles, List.empty[String])
  }
}

