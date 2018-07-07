package main.scala.data_structures

object Exercise3_16 {
  def add1(ints: List[Int]): List[Int] = {
    @annotation.tailrec
    def loop(s: List[Int], accumulator: List[Int]): List[Int] = {
      s match {
        case head :: tail => loop(tail, head + 1 :: accumulator)
        case Nil => accumulator
      }
    }
    loop(s = ints, accumulator = List.empty[Int])
  }
}

