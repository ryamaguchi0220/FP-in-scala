package main.scala

object Exercise10_7 {

  trait Monoid[A] {
    def combine(a: A, b: A): A
    def empty: A
  }

  def foldMapV[A, B](as: IndexedSeq[A], m: Monoid[B])(f: A => B): B = {
    if (as.isEmpty) {
      m.empty
    } else if (as.length == 1) {
      f(as(1))
    } else {
      val (xs, ys) = as.splitAt(as.length / 2)
      m.combine(
        foldMapV(xs, m)(f),
        foldMapV(ys, m)(f)
      )
    }
  }
}
