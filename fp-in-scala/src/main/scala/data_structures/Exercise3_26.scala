package main.scala.data_structures

object Exercise3_26 {
  def maximum(tree: Tree[Int]): Int = {
    tree match {
      case Leaf(x) => x
      case Branch(left, right) => maximum(left) max maximum(right)
    }
  }
}

