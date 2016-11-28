package Exercise3

import org.specs2.mutable.Specification

class Exercise3Spec extends Specification {
  "Exercise3_2" should {
    "最初の要素を削除できること" in {
      Exercise3_2.tail(List("1", "2", "3")) must be_==(List("2", "3"))
    }
  }

  "Exercise3_3" should {
    "最初の要素を置き換えできること" in {
      Exercise3_3.setHead(List("1", "2", "3"), "4") must be_==(List("4", "2", "3"))
    }
  }

  "Exercise3_4" should {
    "要素を2個削除できること" in {
      Exercise3_4.drop(List("1", "2", "3"), 2) must be_==(List("3"))
    }

    "要素数より指定サイズが大きいとNilになること" in {
      Exercise3_4.drop(List("1", "2", "3"), 4) must be_==(Nil)
    }
  }

  "Exercise3_5" should {
    "3より小さい要素を削除できること" in {
      Exercise3_5.dropWhile(List(1, 2, 3, 4, 5), (x: Int) => x < 3) must be_==(List(3, 4, 5))
    }

    "途中の値は影響されないこと" in {
      Exercise3_5.dropWhile(List(5, 4, 3, 2, 1), (x: Int) => x < 3) must be_==(List(5, 4, 3, 2, 1))
    }
  }

  "Exercise3_6" should {
    "最後の要素を削除できること" in {
      Exercise3_6.init(List("1", "2", "3")) must be_==(List("1", "2"))
    }
  }

  "Exercise3_9" should {
    "要素数を取得できること" in {
      Exercise3_9.length(List("1", "2", "3")) must be_==(3)
    }
  }

  "Exercise3_10" should {
    "foldLeftで要素数を取得できること" in {
      Exercise3_10.foldLeft(List("1", "2", "3"), 0)((acc, _) => acc + 1) must be_==(3)
    }
  }

}
