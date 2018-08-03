package main.scala.parallelism

trait Par[A] {
  def get: A
}

object Par {
  def unit[A](a: => A): Par[A] = ???
}
