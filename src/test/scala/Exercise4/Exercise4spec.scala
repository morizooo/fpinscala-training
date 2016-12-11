package Exercise4

import org.specs2.mutable.Specification

import scala.util.Try

class Exercise4_1Spec extends Specification {
  "Exercise4_1" should {
    "map" should {
      "IntからStringに変換できること" in {
        val a = Some(3)
        a.map(_.toString) must be_==(Some("3"))

        "Noneに適用した場合はNoneを返すこと" in {
          val a = None
          a.map(_.toString) must be_==(None)
        }
      }

      "getOrElse" should {
        "getできる場合はそのまま値を返すこと" in {
          Some(5).getOrElse(0) must be_==(5)
        }

        "Noneの場合はデフォルト値を返すこと" in {
          None.getOrElse(0) must be_==(0)
        }
      }

      "flatMap" should {
        "flatMapできること " in {
          Some(3).flatMap(value => Some(value + 20)) must be_==(Some(23))
        }

        "Noneの場合はNoneを返すこと" in {
          None.flatMap(value => Some(value)) must be_==(None)
        }
      }

      "orElse" should {
        "値が存在する場合はそのまま帰すこと" in {
          Some(5).orElse(Some(0)) must be_==(Some(5))
        }

        "値が存在しない場合はデフォルト値を帰すこと" in {
          None.orElse(Some(0)) must be_==(Some(0))
        }
      }

      "filter" should {
        "条件を満たした場合は値が返ること" in {
          Some(3).filter(_ > 2) must be_==(Some(3))
        }

        "条件を満たさなければNoneになること" in {
          Some(1).filter(_ > 2) must be_==(None)
        }
      }
    }
  }

}

class Exercise4_2Spec extends Specification {
  "Exercise4_2" should {
    "分散が計算できること" in {
      val input = Seq(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
      Exercise4_2.variance(input) must be_==(Some(2.9166666666666665))
    }
  }

}

class Exercise4_3Spec extends Specification {
  "Exercise4_3" should {
    "map2が(Option[Int],Option[Double])(Int,Double)=>Stingに適用できること" in {
      Exercise4_3.map2(Some(10), Some(21.5))(_.toString + _.toString) must be_==(Some("1021.5"))
    }
  }

}

class Exercise4_4Spec extends Specification {
  "Exercise4_4" should {
    "1つでもNoneがあるとNoneを返すこと" in {
      Exercise4_4.sequence(List(Some(1), None, Some(2), Some(3), None)) must be_==(None)
    }

    "すべて値があるとListを返すこと" in {
      Exercise4_4.sequence(List(Some(1), Some(2), Some(3))) must be_==(Some(List(1, 2, 3)))
    }
  }

}

class Exercise4_5Spec extends Specification {
  "Exercise4_5" should {
    "StringをIntに変換する処理ができること" in {
      Exercise4_5.traverse(List(1,2,3))(i => Some(i.toString)) must be_==(Some(List("1","2","3")))
    }
  }

}