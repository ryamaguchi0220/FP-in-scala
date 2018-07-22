package main.scala.laziness

object Exercise5_1 {
  // thisのサイズが大きいとSOF
  def toListVerNonTailRec[A](as: Stream[A]): List[A] = as match {
    case Empty => Nil
    case Cons(head, tail) => head() :: toListVerNonTailRec(tail())
  }
  // reverse微妙
  def toListVerTailRec[A](as: Stream[A]): List[A] = {
    def loop(as: Stream[A], acc: List[A]): List[A] = as match {
      case Empty => acc
      case Cons(head, tail) => loop(tail(), head() :: acc)
    }
    loop(as, Nil).reverse
  }
}

