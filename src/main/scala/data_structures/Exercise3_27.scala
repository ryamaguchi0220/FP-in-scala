package main.scala.data_structures

object Exercise3_27 {
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  def depth[A](tree: Tree[A]): Int = {
    tree match {
      case Leaf(_) => 0
      case Branch(left, right) => (1 + depth(left)) max (1 + depth(right))
    }
  }
}

