package Exercise2

import org.specs2.mutable.Specification

class Exercise2Spec extends Specification {
  "Exercise2_1" should {
    "フィボナッチ数列を取得できること" in {
      Exercise2_1.fib(0) must be_==(0)
      Exercise2_1.fib(1) must be_==(1)
      Exercise2_1.fib(2) must be_==(1)
      Exercise2_1.fib(3) must be_==(2)
      Exercise2_1.fib(4) must be_==(3)
      Exercise2_1.fib(5) must be_==(5)
      Exercise2_1.fib(10) must be_==(55)
      Exercise2_1.fib(40) must be_==(102334155)
    }
  }

  "Exercise2_2" should {
    "Int配列がソートされている場合にTrueを返す" in {
      Exercise2_2.isSorted(Array(1, 2, 3, 4, 5), (x: Int, y: Int) => x > y) must beTrue
    }

    "Int配列がソートされていない場合にFalseを返す" in {
      Exercise2_2.isSorted(Array(1, 3, 2, 4, 5), (x: Int, y: Int) => x < y) must beFalse
    }
  }

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

  "Exercise2_5" should {
    "intから数字変換と10の掛け算が合成できること" in {
      val int2str = (x: Int) => x.toString
      val multiply10 = (y: Int) => y * 10
      val compose = Exercise2_5.compose(int2str, multiply10)
      compose(10) must be_==("100")
    }
  }

}
