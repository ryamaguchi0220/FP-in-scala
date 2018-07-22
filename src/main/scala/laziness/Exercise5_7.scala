package main.scala.laziness

object Exercise5_7 {
  def mapViaFoldRight[A, B](as: Stream[A])(f: A => B): Stream[B] = as.foldRight(Stream.empty[B])((a, b) => Stream.cons(f(a), b))
  def filterViaFoldRight[A](as: Stream[A])(p: A => Boolean): Stream[A] = as.foldRight(Stream.empty[A])((a, b) => if (p(a)) Stream.cons(a, b) else b)
  def appendViaFoldRight[A, B >: A](as: Stream[A], bs: Stream[B]): Stream[B] = as.foldRight(bs)((a, b) => Stream.cons(a, b))
  def flatMapViaFoldRight[A, B](as: Stream[A])(f: A => Stream[B]): Stream[B] = as.foldRight(Stream.empty[B])((a, b) => appendViaFoldRight(f(a), b))
}


