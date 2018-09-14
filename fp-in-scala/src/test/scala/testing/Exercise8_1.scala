package testing

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

object Exercise8_1 extends Properties("sum of ints") {
  val smallInt = Gen.choose(0, 100)

  property("pure") = forAll(Gen.nonEmptyListOf(smallInt)) { xs: List[Int] =>
    xs.sum == xs.sum
  }
  property("when no element, equals 0") = forAll(Gen.const(List.empty[Int])) { xs: List[Int] =>
    xs.sum == 0
  }
  property("when one element, equals head") = forAll(Gen.listOfN(1, smallInt)) { xs: List[Int] =>
    xs.sum == xs.head
  }
  property("equals sum of reversed list") = forAll { xs: List[Int] =>
    xs.sum == xs.reverse.sum
  }
  property("when same elements, the element * list size") = forAll(smallInt, smallInt) { (x: Int, y: Int) =>
    List.fill(x)(y).sum == x * y
  }
}