package Exercise2

import org.specs2.mutable.Specification

class Exercise2_4Spec extends Specification {
  "Exercise2_4" should {
    "Intの加算がアンカリー化できること" in {
      val intPlusCurry = Exercise2_3.curry((a: Int, b: Int) => a + b)
      val intPlusUnCurry = Exercise2_4.uncurry(intPlusCurry)
      intPlusUnCurry(2, 4) must be_==(6)
    }

    "Stringの結合がアンカリー化できること" in {
      val strConcatenationCurry = Exercise2_3.curry((a: String, b: String) => a + b)
      val strConcatenationUnCurry = Exercise2_4.uncurry(strConcatenationCurry)
      strConcatenationUnCurry("1", "2") must be_==("12")
    }

  }

}
