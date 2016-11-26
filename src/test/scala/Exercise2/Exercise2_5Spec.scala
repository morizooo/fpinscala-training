package Exercise2

import org.specs2.mutable.Specification

class Exercise2_5Spec extends Specification {
  "Exercise2_5" should {
    "intから数字変換と10の掛け算が合成できること" in {
      val int2str = (x: Int) => x.toString
      val multiply10 = (y: Int) => y * 10
      val compose = Exercise2_5.compose(int2str, multiply10)
      compose(10) must be_==("100")
    }
  }

}
