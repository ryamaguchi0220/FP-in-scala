package main.scala

// Saw answer
object Exercise10_8 {

  trait Monoid[A] {
    def combine(a: A, b: A): A
    def empty: A
  }

  sealed trait WC
  case class Stub(chars: String) extends WC
  case class Part(lStub: String, words: Int, rStub: String) extends WC

  val wcMonoid: Monoid[WC] = new Monoid[WC] {
    override def combine(a: WC, b: WC): WC = {
      (a, b) match {
        case (Stub(x), Part(l, w, r)) => Part(x + l, w, r)
        case (Part(l, w, r), Stub(y)) => Part(l, w, r + y)
        case (Stub(x), Stub(y)) => Stub(x + y)
        case (Part(l1, w1, r1), Part(l2, w2, r2)) =>
          val w3 = if ((r1 + l2).isEmpty) 0 else 1
          Part(l1, w1 + w2 + w3, r2)
      }
    }

    override def empty = Stub("")
  }
}
