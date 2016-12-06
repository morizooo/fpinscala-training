package Exercise3

import org.specs2.mutable.Specification

import scala.util.Try

class Exercise3_2Spec extends Specification {
  "Exercise3_2" should {
    "最初の要素を削除できること" in {
      Exercise3_2.tail(List("1", "2", "3")) must be_==(List("2", "3"))
    }

    "要素がない場合はエラーとなること" in {
      Try(Exercise3_2.tail(Nil)) must beFailedTry
    }
  }
}

class Exercise3_3Spec extends Specification {
  "Exercise3_3" should {
    "最初の要素を置き換えできること" in {
      Exercise3_3.setHead(List("1", "2", "3"), "4") must be_==(List("4", "2", "3"))
    }
  }

  "要素がない場合はエラーとなること" in {
    Try(Exercise3_3.setHead(Nil, "1")) must beFailedTry
  }
}

class Exercise3_4Spec extends Specification {
  "Exercise3_4" should {
    "要素を2個削除できること" in {
      Exercise3_4.drop(List("1", "2", "3"), 2) must be_==(List("3"))
    }

    "要素数より指定サイズが大きいとNilになること" in {
      Exercise3_4.drop(List("1", "2", "3"), 4) must be_==(Nil)
    }
  }
}

class Exercise3_5Spec extends Specification {
  "Exercise3_5" should {
    "3より小さい要素を削除できること" in {
      Exercise3_5.dropWhile(List(1, 2, 3, 4, 5), (x: Int) => x < 3) must be_==(List(3, 4, 5))
    }

    "途中の値は影響されないこと" in {
      Exercise3_5.dropWhile(List(5, 4, 3, 2, 1), (x: Int) => x < 3) must be_==(List(5, 4, 3, 2, 1))
    }
  }
}

class Exercise3_6Spec extends Specification {
  "Exercise3_6" should {
    "最後の要素を削除できること" in {
      Exercise3_6.init(List("1", "2", "3")) must be_==(List("1", "2"))
    }
  }

  "要素がない場合はエラーとなること" in {
    Try(Exercise3_6.init(Nil)) must beFailedTry
  }
}

class Exercise3_9Spec extends Specification {
  "Exercise3_9" should {
    "要素数を取得できること" in {
      Exercise3_9.length(List("1", "2", "3")) must be_==(3)
    }
  }
}

class Exercise3_10Spec extends Specification {
  "Exercise3_10" should {
    "foldLeftで要素数を取得できること" in {
      Exercise3_10.foldLeft(List("1", "2", "3"), 0)((acc, _) => acc + 1) must be_==(3)
    }
  }
}

class Exercise3_11Spec extends Specification {
  "Exercise3_11" should {
    "sumで合計を取得できること" in {
      Exercise3_11.sum(List(1, 2, 3, 4)) must be_==(10)
    }

    "productで積を取得できること" in {
      Exercise3_11.product(List(1, 2, 3, 4)) must be_==(24)
    }

    "lengthで長さを取得できること" in {
      Exercise3_11.length(List(1, 2, 3, 4)) must be_==(4)
    }
  }
}

class Exercise3_12Spec extends Specification {
  "Exercise3_12" should {
    "reverseで要素を逆順にできること" in {
      Exercise3_12.reverse(List("1", "2", "3")) must be_==(List("3", "2", "1"))
    }
  }
}

class Exercise3_13Spec extends Specification {
  "Exercise3_13" should {
    "foldRightで合計が取得できること" in {
      Exercise3_13.foldRightViaFoldLeft(List(1, 2, 3), 0)(_ + _) must be_==(6)
    }

    "foldLeftで要素数を取得できること" in {
      Exercise3_13.foldLeftViaFoldRight(List("1", "2", "3"), 0)((acc, _) => acc + 1) must be_==(3)
    }
  }
}

class Exercise3_14Spec extends Specification {
  "Exercise3_14" should {
    "foldRightでappendが取得できること" in {
      Exercise3_14.appendViaFoldRight(List(1, 2), List(3, 4)) must be_==(List(1, 2, 3, 4))
    }

    "foldLeftでappendが取得できること" in {
      Exercise3_14.appendViaFoldLeft(List(1, 2), List(3, 4)) must be_==(List(1, 2, 3, 4))
    }
  }
}

class Exercise3_15Spec extends Specification {
  "Exercise3_15" should {
    "concatができること" in {
      Exercise3_15.concat(List(List(1, 2, 3, 4))) must be_==(List(1, 2, 3, 4))
    }
  }
}

class Exercise3_16Spec extends Specification {
  "Exercise3_16" should {
    "各要素に1が足されていることができること" in {
      Exercise3_16.plusOne(List(1, 2, 3, 4)) must be_==(List(2, 3, 4, 5))
    }
  }
}

class Exercise3_17Spec extends Specification {
  "Exercise3_17" should {
    "各要素がdoubleからStringに変換されること" in {
      Exercise3_17.doubleToString(List(1, 2, 3, 4)) must be_==(List("1.0", "2.0", "3.0", "4.0"))
    }
  }
}

class Exercise3_18Spec extends Specification {
  "Exercise3_18" should {
    "mapができること" in {
      Exercise3_18.map(List(1, 2, 3, 4))(x => x.toString) must be_==(List("1", "2", "3", "4"))
    }
  }
}

class Exercise3_19Spec extends Specification {
  "Exercise3_19" should {
    "filterができること" in {
      Exercise3_19.filter(List(1, 2, 3, 4))(x => x > 2) must be_==(List(3, 4))
    }
  }
}

class Exercise3_20Spec extends Specification {
  "Exercise3_20" should {
    "flatMapができること" in {
      Exercise3_20.flatMap(List(1, 2, 3))(i => List(i, i)) must be_==(List(1, 1, 2, 2, 3, 3))
    }
  }
}

class Exercise3_21Spec extends Specification {
  "Exercise3_21" should {
    "filterができること" in {
      Exercise3_21.filterViaFlatMap(List(1, 2, 3, 4))(x => x > 2) must be_==(List(3, 4))
    }
  }
}

class Exercise3_22Spec extends Specification {
  "Exercise3_22" should {
    "Listどうしの対応する要素の演算ができること" in {
      Exercise3_22.addPairwise(List(1, 2, 3), List(4, 5, 6)) must be_==(List(5, 7, 9))
    }
  }
}

class Exercise3_23Spec extends Specification {
  "Exercise3_23" should {
    "zipWithができること" in {
      Exercise3_23.zipWith(List(1, 2, 3), List(4, 5, 6))(_ + _) must be_==(List(5, 7, 9))
    }
  }
}

class Exercise3_24Spec extends Specification {
  "Exercise3_24" should {
    "startsWithが確認できること" in {
      Exercise3_24.startsWith(List(1, 2, 3, 4), List(1, 2)) must beTrue
      Exercise3_24.startsWith(List(1, 2, 3, 4), List(1, 2, 3)) must beTrue
      Exercise3_24.startsWith(List(1, 2, 3, 4), List(2, 3)) must beFalse
    }
  }

  "Exercise3_24" should {
    "hasSubsequenceが確認できること" in {
      Exercise3_24.hasSubsequence(List(1, 2, 3, 4), List(1, 2)) must beTrue
      Exercise3_24.hasSubsequence(List(1, 2, 3, 4), List(2, 3)) must beTrue
      Exercise3_24.hasSubsequence(List(1, 2, 3, 4), List(4)) must beTrue
      Exercise3_24.hasSubsequence(List(1, 2, 3, 4), List(5)) must beFalse
    }
  }
}

class Exercise3_25Spec extends Specification {
  "Exercise3_25" should {
    "ノード数が数えられること" in {
      val tree = Branch(Branch(Leaf(1), Leaf(2)),   Branch(Leaf(3), Leaf(4)))
      Exercise3_25.size(tree) must be_==(7)
      Exercise3_25.size(Leaf(1)) must be_==(1)
    }
  }
}

class Exercise3_26Spec extends Specification {
  "Exercise3_26" should {
    "maximumが計算できること" in {
      val tree = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))
      Exercise3_26.maximum(tree) must be_==(4)
      Exercise3_26.maximum(Leaf(1)) must be_==(1)
    }
  }
}

class Exercise3_27Spec extends Specification {
  "Exercise3_27" should {
    "最長パスが計算ができること" in {
      Exercise3_27.depth(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))) must be_==(2)
      Exercise3_27.depth(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))) must be_==(2)
      Exercise3_27.depth(Leaf(1)) must be_==(0)
    }
  }

}

class Exercise3_28Spec extends Specification {
  "Exercise3_28" should {
    "mapができること" in {
      Exercise3_28.map(Leaf(3))(a=>a.toString) must be_==(Leaf("3"))
      Exercise3_28.map(Branch(Leaf(1),Leaf(2)))(a=>a.toString) must be_==(Branch(Leaf("1"),Leaf("2")))
    }
  }
}

class Exercise3_29Spec extends Specification {
  val tree = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))
  "Exercise3_29" should {
    "foldができること" in {
      Exercise3_29.fold(tree)(a=>a.toString)(_+_) must be_==("1234")
    }

    "foldを使ってsizeが計算できること" in {

      Exercise3_29.sizeViaFold(tree) must be_==(Exercise3_25.size(tree))
    }

    "foldを使ってmaximumが計算できること" in {
      Exercise3_29.maximumViaFold(tree) must be_==(Exercise3_26.maximum(tree))
    }

    "foldを使ってdepthが計算できること" in {
      Exercise3_29.depthViaFold(tree) must be_==(Exercise3_27.depth(tree))
    }

    "foldを使ってmapができること" in {
      Exercise3_29.mapViaFold(tree)(a=>a.toString) must be_==(Exercise3_28.map(tree)(a=>a.toString))
    }
  }
}
