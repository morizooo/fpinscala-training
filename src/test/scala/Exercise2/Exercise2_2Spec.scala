package Exercise2

import org.specs2.mutable.Specification

class Exercise2_2Spec extends Specification {
  "Exercise2_2" should {
    "Int配列がソートされている場合にTrueを返す" in {
      Exercise2_2.isSorted(Array(1,2,3,4,5),(x:Int, y:Int) => x>y) must beTrue
    }

    "Int配列がソートされていない場合にFalseを返す" in {
      Exercise2_2.isSorted(Array(1,3,2,4,5),(x:Int, y:Int) => x<y) must beFalse
    }
  }

}
