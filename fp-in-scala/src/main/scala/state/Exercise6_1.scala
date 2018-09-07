package main.scala.state

object Exercise6_1 {
  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (randomInt, nextRng) = rng.nextInt
    (if (randomInt < 0) -(randomInt + 1) else randomInt, nextRng)
  }
}
