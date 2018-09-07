package main.scala.laziness

object Exercise5_5 {
  def takeWhileViaFoldRight[A](as: Stream[A])(p: A => Boolean): Stream[A] = {
    as.foldRight(Stream.empty[A])((a, b) => if (p(a)) Stream.cons(a, b) else Stream.empty)
  }
}

