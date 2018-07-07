package main.scala.data_structures

object Exercise3_27 {
  def depth[A](tree: Tree[A]): Int = {
    tree match {
      case Leaf(_) => 0
      case Branch(left, right) => (1 + depth(left)) max (1 + depth(right))
    }
  }
}

