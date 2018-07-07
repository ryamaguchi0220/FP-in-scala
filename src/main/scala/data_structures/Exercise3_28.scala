package main.scala.data_structures

object Exercise3_28 {
  def map[A,B](tree: Tree[A])(f: A => B): Tree[B] = {
    tree match {
      case Leaf(x) => Leaf(f(x))
      case Branch(left, right) => Branch(map(left)(f), map(right)(f))
    }
  }
}

