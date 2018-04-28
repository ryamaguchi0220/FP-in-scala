package main.scala

import scala.annotation.tailrec

object Exercise3_17 {
  def map[A, B](as: List[A])(f: A => B): List[B] = {
    @tailrec
    def loop(as: List[A], acc: List[B]): List[B] = {
      as match {
        case Nil => acc
        case head :: tail => loop(tail, f(head) :: acc)
      }
    }
    // I'd hate to reverse...
    loop(as.reverse, List.empty[B])
  }

  def mapViaFoldLeft[A, B](as: List[A])(f: A => B): List[B] = {
    // I'd hate to reverse...
    as.reverse.foldLeft(List.empty[B])((acc, a) => f(a) :: acc)
  }

  def mapViaFoldRight[A, B](as: List[A])(f: A => B): List[B] = {
    // good...
    as.foldRight(List.empty[B])((a, acc) => f(a) :: acc)
  }

  def dsToStr(as: List[Double]): List[String] = {
    mapViaFoldRight(as)(_.toString)
  }
}

