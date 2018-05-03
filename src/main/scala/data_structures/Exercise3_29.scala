package main.scala.data_structures

object Exercise3_29 {
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  def fold[A, B](tree: Tree[A])(f: A => B)(ff: (B,B) => B): B = {
    tree match {
      case Leaf(x) => f(x)
      case Branch(left, right) => ff(fold(left)(f)(ff), fold(right)(f)(ff))
    }
  }

  def size[A](tree: Tree[A]): Int = fold(tree)(_ => 1)(_ + _ + 1)
  def maximum(tree: Tree[Int]): Int = fold(tree)(identity)(_ max _)
  def depth[A](tree: Tree[A]): Int = fold(tree)(_ => 0)((x, y) => 1 + (x max y))
  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = fold[A, Tree[B]](tree)(x => Leaf(f(x)))(Branch(_, _))
}

