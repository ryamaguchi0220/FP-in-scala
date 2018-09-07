package main.scala.state

trait RNG {
  def nextInt: (Int, RNG)
}
object RNG {
  type Rand[A] = RNG => (A, RNG)
  def map[A, B](r: Rand[A])(f: A => B): Rand[B] = {
    rng => {
      val (random, nextRng) = r(rng)
      (f(random), nextRng)
    }
  }
  def unit[A](a: A): Rand[A] = {
    rng => (a, rng)
  }
}