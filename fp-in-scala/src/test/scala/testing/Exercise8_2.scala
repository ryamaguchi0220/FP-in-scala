package testing

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

import scala.util.{Failure, Try}

object Exercise8_2 extends Properties("max of ints") {
  val smallInt = Gen.choose(0, 100)

  property("pure") = forAll(Gen.nonEmptyListOf(smallInt)) { xs: List[Int] =>
    xs.max == xs.max
  }
  property("when one element, equals head") = forAll(Gen.listOfN(1, smallInt)) { xs: List[Int] =>
    xs.max == xs.head
  }
  property("when no element, causes the exception") = forAll(Gen.const(List.empty[Int])) { xs: List[Int] =>
    Try(xs.max) match {
      case Failure(_: UnsupportedOperationException) => true
      case _ => false
    }
  }
  property("gte all elements") = forAll(Gen.nonEmptyListOf(smallInt)) { xs: List[Int] =>
    val max = xs.max
    xs.forall(_ <= max)
  }
}