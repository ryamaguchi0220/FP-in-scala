package main.scala.error_handling

// Saw the answer
object Exercise4_2 {
  def variance(xs: Seq[Double]): Option[Double] = mean(xs).flatMap(m => mean(xs.map(x => math.pow(x - m, 2))))
  def mean(xs: Seq[Double]): Option[Double] = if (xs.isEmpty) None else Some(xs.max / xs.length)
}

