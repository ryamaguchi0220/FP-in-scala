package main.scala.state

import RNG._

object Exercise6_8 {
  def flatMap[A, B](f: Rand[A]])(g: A => Rand[B]): Rand[B] = {
    r => {
      val (a, nextRng) = f(r)
      g(a)(nextRng)
    }
  }
}