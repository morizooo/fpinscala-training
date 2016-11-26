package Exercise2

import org.specs2.mutable.Specification

class Exercise2_3Spec extends Specification {
  "Exercise2_3" should {
    "Intの加算がカリー化できること" in {
      val plus = (a: Int, b: Int) => a + b
      val intPlusCurry = Exercise2_3.curry(plus)
      intPlusCurry(1)(2) must be_==(3)
    }

    "Stringの結合がカリー化できること" in {
      val concatenation = (a: String, b: String) => a + b
      val strConcatenationCurry = Exercise2_3.curry(concatenation)
      strConcatenationCurry("1")("2") must be_==("12")
    }

  }

}
