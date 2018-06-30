package main.scala.state

trait RNG {
  def nextInt: (Int, RNG)
}