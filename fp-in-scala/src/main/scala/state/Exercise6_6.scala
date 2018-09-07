package main.scala.state

import RNG._

object Exercise6_6 {
  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    rng => {
      val (a, aRng) = ra(rng)
      val (b, bRng) = rb(aRng)
      (f(a, b), bRng)
    }
  }
}
