package main.scala

import scala.collection.immutable.{::, List, Nil}

// Saw nothing
object Exercise3_11 {
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case head :: tail => foldLeft(tail, f(z, head))(f)
    }
  }

  def sum(as: List[Int]): Int = {
    foldLeft(as, 0)(_ + _)
  }

  def product(as: List[Double]): Double = {
    foldLeft(as, 1.0)(_ * _)
  }

  def length[A](as: List[A]): Int = {
    foldLeft(as, 0)((accumulator, _) => accumulator + 1)
  }
}

