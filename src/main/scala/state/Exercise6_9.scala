package main.scala.state

import Exercise6_8.flatMap
import RNG._

object Exercise6_9 {
  def mapViaFlatMap[A, B](r: Rand[A])(f: A => B): Rand[B] = flatMap(r)(a => unit(f(a)))
  def map2ViaFlatMap[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = flatMap(ra)(a => mapViaFlatMap(rb)(b => f(a, b)))
}