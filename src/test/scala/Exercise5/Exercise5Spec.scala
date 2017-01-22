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
      //scala標準のStreamだと、List変換しなくてもうまくいく。
      //scala.collection.immutable.Stream(1, 2, 3).take(1) must be_==(scala.collection.immutable.Stream(1))
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
}

class Exercise5_5Spec extends Specification {
}

class Exercise5_6Spec extends Specification {
}

class Exercise5_7Spec extends Specification {
}

class Exercise5_8Spec extends Specification {
}

class Exercise5_9Spec extends Specification {
}

class Exercise5_10Spec extends Specification {
}

class Exercise5_11Spec extends Specification {
}

class Exercise5_12Spec extends Specification {
}

class Exercise5_13Spec extends Specification {
}

//class Exercise5_14Spec extends Specification {
//}
class Exercise5_15Spec extends Specification {
}

//class Exercise5_16Spec extends Specification {
//}