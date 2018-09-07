package main.scala.state

import Exercise6_1.nonNegativeInt
import RNG._

object Exercise6_8 {
  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    r => {
      val (a, nextRng) = f(r)
      g(a)(nextRng)
    }
  }
  def nonNegativeLessThan(n: Int): Rand[Int] = {
    flatMap(nonNegativeInt) { i =>
      val mod = i % n
      if (i + (n - 1) - mod >= 0) rng => (mod, rng) else nonNegativeLessThan(n)
    }
  }
}