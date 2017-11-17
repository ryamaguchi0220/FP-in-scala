package main.scala

import scala.annotation.tailrec

object Exercise2_2 {

  def main(args: Array[String]): Unit = {
    println(isSorted(Array(1, 2, 3 ,4 ,5), (_: Int) < (_: Int)))
    println(isSorted(Array(1, 1, 1 ,1 ,2), (_: Int) == (_: Int)))
    println(isSorted(Array(), (_: Int) == (_: Int)))
    println(isSorted(Array(1), (_: Int) == (_: Int)))
  }

  // Saw hint
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @tailrec
    def loop(i: Int): Boolean = {
      if(i >= as.size - 1) true
      else if (ordered(as(i), as(i + 1))) loop(i + 1)
      else false
    }
    loop(0)
  }
}
