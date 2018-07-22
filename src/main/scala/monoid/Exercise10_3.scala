package main.scala.monoid

object Exercise10_3 {
  def optionMonoid1[A] = new Monoid[Option[A]] {
    override def combine(a: Option[A], b: Option[A]): Option[A] = {
      (a, b) match {
        case (Some(a), None) => Some(a)
        case (None, Some(b)) => Some(b)
        case (Some(a), Some(_)) => Some(a)
        case (None, None) => None
      } 
    }
    override def empty: Option[A] = None
  }
  def optionMonoid2[A] = new Monoid[Option[A]] {
    override def combine(a: Option[A], b: Option[A]): Option[A] = {
      (a, b) match {
        case (Some(a), None) => Some(a)
        case (None, Some(b)) => Some(b)
        case (Some(_), Some(b)) => Some(b)
        case (None, None) => None
      }
    }
    override def empty: Option[A] = None
  }
}
