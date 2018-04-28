package main.scala

import scala.annotation.tailrec
import scala.collection.immutable.{::, List, Nil}

object Exercise3_5 {

  def main(args: Array[String]): Unit = {
    println(s"I expect that ${dropWhile(List(1, 2, 3), (n: Int) => n <= 2)} is List(3)")
    println(s"I expect that ${dropWhile(List(1, 2, 3), _ => true)} is Nil")
    println(s"I expect that ${dropWhile(List.empty[Int], _ => true)} is Nil")
  }

  def dropWhile[A](list: List[A], f: A => Boolean): List[A] = {
    @tailrec
    def loop(l: List[A], f: A => Boolean): List[A] = {
      l match {
        case Nil => Nil
        case ::(head, tail) => if(f(head)) loop(tail, f) else l
      }
    }
    loop(list, f)
  }
}

