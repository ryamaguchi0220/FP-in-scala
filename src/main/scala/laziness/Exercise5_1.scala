package main.scala.laziness

object Exercise5_1 {
  sealed trait Stream[+A] {
    // thisのサイズが大きいとSOF
    def toListVerNonTailRec: List[A] = this match {
      case Empty => Nil
      case Cons(head, tail) => head() :: tail().toListVerNonTailRec
    }
    // reverse微妙
    def toListVerTailRec: List[A] = {
      def loop(as: Stream[A], acc: List[A]): List[A] = as match {
        case Empty => acc
        case Cons(head, tail) => loop(tail(), head() :: acc)
      }
      loop(this, Nil).reverse
    }
  }
  case object Empty extends Stream[Nothing]
  case class Cons[+A](head: () => A, tail: () => Stream[A]) extends Stream[A]

  object Stream {
    def cons[A](head: => A, tail: => Stream[A]): Stream[A] = {
      lazy val lazyHead = head
      lazy val lazyTail = tail
      Cons(() => lazyHead, () => lazyTail)
    }
    def empty[A]: Stream[A] = Empty
    def apply[A](as: A*): Stream[A] = if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
  }
}

