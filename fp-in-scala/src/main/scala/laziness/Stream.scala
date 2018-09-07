package main.scala.laziness

sealed trait Stream[+A] {
  def append[B >: A](bs: Stream[B]): Stream[B] = {
    this match {
      case Cons(head, tail) => Stream.cons(head(), tail().append(bs))
      case Empty => bs
    }
  }
  def foldRight[B](z: B)(f: (A, => B) => B): B = this match {
    case Cons(head, tail) => f(head(), tail().foldRight(z)(f))
    case Empty => z
  }
  def headOption: Option[A] = this match {
    case Cons(head, _) => Some(head())
    case Empty => None
  }
}

case class Cons[+A](head: () => A, tail: () => Stream[A]) extends Stream[A]
case object Empty extends Stream[Nothing]

object Stream {
  def cons[A](head: => A, tail: => Stream[A]): Stream[A] = {
    lazy val lazyHead = head
    lazy val lazyTail = tail
    Cons(() => lazyHead, () => lazyTail)
  }
  def empty[A]: Stream[A] = Empty
  def apply[A](as: A*): Stream[A] = if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
}