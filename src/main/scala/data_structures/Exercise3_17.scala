package main.scala.data_structures

import Exercise3_16.mapViaFoldRight

object Exercise3_17 {
  def dsToStr(as: List[Double]): List[String] = {
    mapViaFoldRight(as)(_.toString)
  }
}

