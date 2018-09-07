package main.scala.state

import RNG._

object Exercise6_7 {
  def sequence[A](ras: List[Rand[A]]): Rand[List[A]] = {
    r => {
      ras.foldRight((List.empty[A], r)) { case (ra, (as, rng)) =>
        val (a, nextRng) = ra(rng)
        (a :: as, nextRng)
      }
    }
  }
  def ints(count: Int): Rand[List[Int]] = {
    val intRand = (x: RNG) => x.nextInt
    sequence(List.fill(count)(intRand))
  }
}
