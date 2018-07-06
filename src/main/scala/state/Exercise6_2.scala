package main.scala.state

import Exercise6_1.nonNegativeInt

// Saw the answer.
object Exercise6_2 {
  def double(rng: RNG): (Double, RNG) = {
    val (randomInt, nextRng) = nonNegativeInt(rng)
    (randomInt / (Int.MaxValue.toDouble + 1), nextRng)
  }
}
