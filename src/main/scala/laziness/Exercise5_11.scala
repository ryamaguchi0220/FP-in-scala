package main.scala.laziness

object Exercise5_11 {
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
    case Some((h,s)) => Stream.cons(h, unfold(s)(f))
    case None => Stream.empty
  }
}
