package main.scala.state

import Exercise6_1.nonNegativeInt
import Exercise6_2.double

object Exercise6_3 {
  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (randomInt, nextRng1) = nonNegativeInt(rng)
    val (randomDouble, next2Rng) = double(nextRng1)
    ((randomInt, randomDouble), next2Rng)
  }
  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val ((randomInt, randomDouble), nextRng) = intDouble(rng)
    ((randomDouble, randomInt), nextRng)
  }
  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val (randomDouble1, nextRng1) = double(rng)
    val (randomDouble2, nextRng2) = double(nextRng1)
    val (randomDouble3, nextRng3) = double(nextRng2)
    ((randomDouble1, randomDouble2, randomDouble3), nextRng3)
  }
}
