package main.scala.state

object Exercise6_4 {
  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    if (0 < count) {
      val (randomInt, nextRng1) = rng.nextInt
      val (randomInts, nextRng2) = ints(count - 1)(nextRng1)
      (randomInt +: randomInts, nextRng2)
    } else {
      (List.empty[Int], rng)
    }
  }
}
