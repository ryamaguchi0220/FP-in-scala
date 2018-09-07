package main.scala.other

// Saw the hint.
object Exercise2_2 {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(i: Int): Boolean = {
      if(i >= as.size - 1) true
      else if (ordered(as(i), as(i + 1))) loop(i + 1)
      else false
    }
    loop(0)
  }
}
