package main.scala.monoid

trait Monoid[A] {
  def combine(a: A, b: A): A
  def empty: A
}
