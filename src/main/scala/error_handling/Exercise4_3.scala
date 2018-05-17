package main.scala.error_handling

object Exercise4_3 {
  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =  {
    (a, b) match {
      case (Some(av), Some(bv)) => Some(f(av,bv))
      case _ => None
    }
  }
}

