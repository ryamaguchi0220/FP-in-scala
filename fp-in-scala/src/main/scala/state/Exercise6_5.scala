package main.scala.state

import Exercise6_1.nonNegativeInt
import RNG._

object Exercise6_5 {
  val double: Rand[Double] = map(nonNegativeInt)(_ / (Int.MaxValue.toDouble + 1))
}
