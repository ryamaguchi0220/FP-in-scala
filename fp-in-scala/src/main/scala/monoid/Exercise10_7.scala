package main.scala.monoid

// Saw the hint.
object Exercise10_7 {
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
