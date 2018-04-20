package main.scala


object Exercise10_1 {
  trait Monoid[A] {
    def combine(a: A, b: A): A
    def empty: A
  }

  val intAddition = new Monoid[Int] {
    override def combine(a: Int, b: Int): Int = a + b
    override def empty: Int = 0
  }

  val intMultiplication = new Monoid[Int] {
    override def combine(a: Int, b: Int): Int = a * b
    override def empty: Int = 1
  }

  val booleanOr = new Monoid[Boolean] {
    override def combine(a: Boolean, b: Boolean): Boolean = a || b
    override def empty: Boolean = false
  }

  val booleanAnd = new Monoid[Boolean] {
    override def combine(a: Boolean, b: Boolean): Boolean = a && b
    override def empty: Boolean = true
  }
}

