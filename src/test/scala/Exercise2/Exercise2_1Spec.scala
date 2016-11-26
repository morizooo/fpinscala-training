package Exercise2

import org.specs2.mutable.Specification

class Exercise2_1Spec extends Specification {
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

}
