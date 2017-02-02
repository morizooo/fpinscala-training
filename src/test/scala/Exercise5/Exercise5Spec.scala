package Exercise5

import org.specs2.mutable.Specification

class Exercise5_1Spec extends Specification {
  "Exercise5_1_toList" should {
    "Listに変換できること" in {
      Stream(1, 2, 3).toList must be_==(List(1, 2, 3))
    }
    "空のストリームが空のリストに変換できること" in {
      Stream().toList must be_==(List())
    }
  }
}

class Exercise5_2Spec extends Specification {
  "Exercise5_2_take" should {
    "単一の要素を取得できること" in {
      Stream(1, 2, 3).take(1).toList must be_==(List(1))
      //      scala標準のStreamだと、List変換しなくてもうまくいく。
      //      scala.collection.immutable.Stream(1, 2, 3).take(1) must be_==(scala.collection.immutable.Stream(1))
    }
    "複数の要素を取得できること" in {
      Stream(1, 2, 3).take(2).toList must be_==(List(1, 2))
    }
    "全体の要素より大きい要素を指定" in {
      Stream(1, 2, 3).take(4).toList must be_==(List(1, 2, 3))
    }
    "空のStreamだった場合、空のStreamが返って来ること" in {
      Stream().take(1).toList must be_==(List())
      Stream().take(2).toList must be_==(List())
    }
    "0を指定した場合、空のStreamが返って来ること" in {
      Stream().take(0).toList must be_==(List())
    }
  }
  "Exercise5_2_drop" should {
    "1個目の要素をスキップできること" in {
      Stream(1, 2, 3).drop(1).toList must be_==(List(2, 3))
      //scala標準のStreamだと、List変換しなくてもうまくいく。
      //scala.collection.immutable.Stream(1, 2, 3).drop(1) must be_==(scala.collection.immutable.Stream(2,3))
    }
    "複数の要素を取得できること" in {
      Stream(1, 2, 3).drop(2).toList must be_==(List(3))
    }
    "全体の要素より大きい要素を指定" in {
      Stream(1, 2, 3).drop(4).toList must be_==(List())
    }
    "空のStreamだった場合、空のStreamが返って来ること" in {
      Stream().drop(1).toList must be_==(List())
      Stream().drop(2).toList must be_==(List())
    }
    "0を指定した場合、空のStreamが返って来ること" in {
      Stream().drop(0).toList must be_==(List())
    }
  }
}

class Exercise5_3Spec extends Specification {
  "Exercise5_3_takeWhile" should {
    "マッチする要素を取り出せた場合" in {
      Stream(1, 3, 2, 5).takeWhile(n => n % 2 == 1).toList must be_==(List(1, 3))
    }
    "マッチする要素がなく取り出せなかった場合" in {
      Stream(0).takeWhile(n => n % 2 == 1).toList must be_==(List())
    }
  }
}

class Exercise5_4Spec extends Specification {
  "Exercise5_4_forAll" should {
    "全ての要素が条件に合致した場合" in {
      Stream(1, 2, 3).forAll(n => n < 4) must be_==(true)
    }
    "一部の要素しか条件に合致しなかった場合" in {
      Stream(1, 2, 3).forAll(n => n > 2) must be_==(false)
    }
    "全ての要素が条件に合致しなかった場合" in {
      Stream(1, 2, 3).forAll(n => n > 4) must be_==(false)
    }
  }
}

class Exercise5_5Spec extends Specification {
  "Exercise5_5_takeWhileViaFoldRight" should {
    "マッチする要素を取り出せた場合" in {
      Stream(1, 3, 2, 5).takeWhileViaFoldRight(n => n % 2 == 1).toList must be_==(List(1, 3))
    }
    "マッチする要素がなく取り出せなかった場合" in {
      Stream(0).takeWhileViaFoldRight(n => n % 2 == 1).toList must be_==(List())
    }
  }
}

class Exercise5_6Spec extends Specification {
  "Exercise5_6_headOptionViaFoldRight" should {
    "先頭の要素を取り出せた場合" in {
      Stream(1, 3, 2, 5).headOptionViaFoldRight.toList must be_==(List(1))
    }
    "要素がないStreamで先頭の要素を取り出せなかった場合" in {
      Stream().headOptionViaFoldRight.toList must be_==(List())
    }
  }
}

class Exercise5_7Spec extends Specification {
  "Exercise5_7_map" should {
    "mapが適用できて、各要素を2倍できた場合" in {
      Stream(1, 2, 3).map(n => n * 2).toList must be_==(List(2, 4, 6))
    }
  }
  "Exercise5_7_filter" should {
    "filterが適用できて、奇数の要素を抽出できた場合" in {
      Stream(1, 2, 3, 4, 5).filter(n => n % 2 == 1).toList must be_==(List(1, 3, 5))
    }
  }
  "Exercise5_7_append" should {
    "Streamの結合ができた場合" in {
      Stream(1, 2, 3, 4, 5).append(Stream(6, 7)).toList must be_==(List(1, 2, 3, 4, 5, 6, 7))
    }
    "空Streamとの結合ができた場合" in {
      Stream(1, 2, 3, 4, 5).append(Stream()).toList must be_==(List(1, 2, 3, 4, 5))
    }
    "Streamの要素の型が違った場合" in {
      Stream(1, 2, 3, 4, 5).append(Stream("a")).toList must be_==(List(1, 2, 3, 4, 5, "a"))
    }
  }
  "Exercise5_7_flatMap" should {
    "flatMapが適用できて、一部の要素に'A'(65)を足した要素を追加できた場合" in {
      Stream(0, 1, 2).flatMap(n => Stream(n, 'A' + n)).toList must be_==(List(0, 65, 1, 66, 2, 67))
    }
  }
}

class Exercise5_8Spec extends Specification {
  "Exercise5_8_constant" should {
    "特定の値の無限ストリームを作成できた場合" in {
      Stream().constant(5).take(10).toList must be_==(List(5, 5, 5, 5, 5, 5, 5, 5, 5, 5))
    }
  }
}

class Exercise5_9Spec extends Specification {
  "Exercise5_9_from" should {
    "特定の値に+1がされていった値の無限ストリームを作成できた場合" in {
      Stream.from(5).take(10).toList must be_==(List(5, 6, 7, 8, 9, 10, 11, 12, 13, 14))
    }
  }
}

//class Exercise5_10Spec extends Specification {
//  "Exercise5_10_fibs" should {
//    "フィボナッチ数列の無限ストリームを作成できた場合" in {
//      Stream.fibs.take(7).toList must be_==(List(0, 1, 1, 2, 3, 5, 8))
//    }
//  }
//}

class Exercise5_11Spec extends Specification {
  "Exercise5_11_unfold" should {
    "余再帰で無限ストリームを作成できた場合" in {
      Stream.unfold(2)(x => Some(x, x * x)).take(6).toList must be_==(List(2, 4, 16, 256, 65536, 0))
    }
  }
}

//class Exercise5_12Spec extends Specification {
//  "Exercise5_12_onesViaUnfold" should {
//    "特定の値の無限ストリームを作成できた場合" in {
//      Stream.onesViaUnfold.take(10).toList must be_==(List(1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
//    }
//  }
//  "Exercise5_12_constantViaUnfold" should {
//    "特定の値の無限ストリームを作成できた場合" in {
//      Stream.constantViaUnfold(5).take(10).toList must be_==(List(5, 5, 5, 5, 5, 5, 5, 5, 5, 5))
//    }
//  }
//  "Exercise5_12_fromViaUnfold" should {
//    "特定の値に+1がされていった値の無限ストリームを作成できた場合" in {
//      Stream.fromViaUnfold(5).take(10).toList must be_==(List(5, 6, 7, 8, 9, 10, 11, 12, 13, 14))
//    }
//  }
//  "Exercise5_12_fibsViaUnfold" should {
//    "フィボナッチ数列の無限ストリームを作成できた場合" in {
//      Stream.fibsViaUnfold.take(7).toList must be_==(List(0, 1, 1, 2, 3, 5, 8))
//    }
//  }
//}

class Exercise5_13Spec extends Specification {

  "Exercise5_13_mapViaUnfold" should {
    "mapが適用できて、各要素を2倍できた場合" in {
      Stream(1, 2, 3).mapViaUnfold(n => n * 2).toList must be_==(List(2, 4, 6))
    }
  }

  "Exercise5_13_takeViaUnfold" should {
    "単一の要素を取得できること" in {
      Stream(1, 2, 3).takeViaUnfold(1).toList must be_==(List(1))
      //      scala標準のStreamだと、List変換しなくてもうまくいく。
      //      scala.collection.immutable.Stream(1, 2, 3).take(1) must be_==(scala.collection.immutable.Stream(1))
    }
    "複数の要素を取得できること" in {
      Stream(1, 2, 3).takeViaUnfold(2).toList must be_==(List(1, 2))
    }
    "全体の要素より大きい要素を指定" in {
      Stream(1, 2, 3).takeViaUnfold(4).toList must be_==(List(1, 2, 3))
    }
    "空のStreamだった場合、空のStreamが返って来ること" in {
      Stream().takeViaUnfold(1).toList must be_==(List())
      Stream().takeViaUnfold(2).toList must be_==(List())
    }
    "0を指定した場合、空のStreamが返って来ること" in {
      Stream().takeViaUnfold(0).toList must be_==(List())
    }
  }
  "Exercise5_13_takeWhileViaUnfold" should {
    "マッチする要素を取り出せた場合" in {
      Stream(1, 3, 2, 5).takeWhileViaUnfold(n => n % 2 == 1).toList must be_==(List(1, 3))
    }
    "マッチする要素がなく取り出せなかった場合" in {
      Stream(0).takeWhileViaUnfold(n => n % 2 == 1).toList must be_==(List())
    }
  }
  "Exercise5_13_zipWithViaUnfold" should {
    "マッチする要素を取り出せた場合" in {
      Stream(1, 2, 3, 4).zipWithViaUnfold(Stream(10, 20, 30, 40))(_ + _).toList must be_==(List(11, 22, 33, 44))
    }
  }
  "Exercise5_13_zipWithAll" should {
    "マッチする要素を取り出せた場合" in {
      Stream(1, 2, 3, 4).zipWithAll(Stream(10, 20, 30, 40))((a,b) => a.getOrElse(100) + b.getOrElse(100)).toList must be_==(List(11, 22, 33, 44))
    }
  }
}

//class Exercise5_14Spec extends Specification {
//}
//class Exercise5_15Spec extends Specification {
//}
//class Exercise5_16Spec extends Specification {
//}