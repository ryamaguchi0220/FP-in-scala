package main.scala.laziness

object Exercise5_6 {
  def headOptionViaFoldRight[A](as: Stream[A]): Option[A] = as.foldRight[Option[A]](None)((a, _) => Some(a))
}

