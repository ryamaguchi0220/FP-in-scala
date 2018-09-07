package main.scala.laziness

object Exercise5_14 {
  def startWith[A, B](as: Stream[A], bs: Stream[B]): Boolean = (as, bs) match {
    case (Cons(head1, tail1), Cons(head2, tail2)) if head1() == head2() => startWith(tail1(), tail2())
    case (_, Empty) => true
    case _ => false
  }
}
