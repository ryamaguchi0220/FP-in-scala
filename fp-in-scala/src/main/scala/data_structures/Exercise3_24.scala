package main.scala.data_structures

object Exercise3_24 {
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
    @annotation.tailrec
    def loop(xs: List[A], ys: List[A]): Boolean = {
      (xs, ys) match {
        case (xHead :: xTail, yHead :: yTail) if (xHead == yHead) => loop(xTail, yTail)
        case (xHead :: xTail, yHead :: _) if (xHead != yHead) => loop(xTail, sub)
        case (_, Nil) => true
        case (Nil, _) => false
      }
    }
    loop(sup, sub)
  }
}

