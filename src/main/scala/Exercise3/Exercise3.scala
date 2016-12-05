package Exercise3

// 以下を実行すると結果はどうなるか
object Exercise3_1 {
  def main(args: Array[String]): Unit = {
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }
    println(x)
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }
}

object Exercise3_2 {
  // Listの最初の要素を削除するtailを実装せよ
  def tail[A](l: List[A]): List[A] = l match {
    case Cons(_, xs) => xs
    case Nil => sys.error("empty list")
  }
}

object Exercise3_3 {
  // Listの最初の要素を別の値と置き換えるsetHeadを実装せよ
  def setHead[A](l: List[A], h: A): List[A] = l match {
    case Nil => sys.error("empty list")
    case Cons(_, xs) => Cons(h, xs)
  }
}

object Exercise3_4 {
  // リストのn個を削除するdropを実装せよ
  def drop[A](l: List[A], n: Int): List[A] = {
    if (n < 1) l
    else l match {
      case Cons(x, xs) => drop(xs, n - 1)
      case Nil => Nil
    }
  }
}

object Exercise3_5 {
  // 述語とマッチする場合に限りListの要素までを削除するdropWhileを実装せよ
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(x, xs) if f(x) => dropWhile(xs, f)
    case _ => l
  }
}

object Exercise3_6 {
  // Listの末尾を除いたListを返すinitを実装せよ
  def init[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("empty list")
    case Cons(_, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }
}

// 以下を実行するとどうなるか
object Exercise3_8 {
  def main(args: Array[String]): Unit = {
    println(List.foldRight(Cons(1, Cons(2, Cons(3, Nil))), Nil: List[Int])(Cons(_, _)))
  }
}

object Exercise3_9 {
  // foldRigthを使って要素数を取得するlengthを実装せよ
  def length[A](l: List[A]): Int = List.foldRight(l, 0)((_, acc) => acc + 1)
}

object Exercise3_10 {
  // 再帰を用いてListの処理を行うfoldLeftを実装せよ
  //  @annotation.tailrec
  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = l match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }
}

object Exercise3_11 {
  // foldLeftを使って全要素の和を計算すsumを実装せよ
  def sum(l: List[Int]) = Exercise3_10.foldLeft(l, 0)(_ + _)

  // foldLeftを使って全要素の積を計算するproductを実装せよ
  def product(l: List[Double]) = Exercise3_10.foldLeft(l, 1.0)(_ * _)

  // foldLeftを使ってlengthを実装せよ
  def length[A](l: List[A]): Int = Exercise3_10.foldLeft(l, 0)((acc, h) => acc + 1)
}

object Exercise3_12 {
  // リストの逆順を返すreverseを実装せよ
  def reverse[A](l: List[A]): List[A] = Exercise3_10.foldLeft(l, List[A]())((acc, h) => Cons(h, acc))
}

object Exercise3_13 {
  // foldLeftを使ってfoldRightを実装せよ
  def foldRightViaFoldLeft[A, B](l: List[A], z: B)(f: (A, B) => B): B =
  Exercise3_10.foldLeft(l, (b: B) => b)((g, a) => b => g(f(a, b)))(z)

  // foldRightを使ってfoldLeftを実装せよ
  def foldLeftViaFoldRight[A, B](l: List[A], z: B)(f: (B, A) => B): B =
  List.foldRight(l, (c: B) => c)((a, g) => b => g(f(b, a)))(z)
}

object Exercise3_14 {
  // foldLeftを使ってappendを実装せよ
  def appendViaFoldRight[A](a1: List[A], a2: List[A]): List[A] =
  List.foldRight(a1, a2)(Cons(_, _))

  // foldRightを使ってappendを実装せよ
  def appendViaFoldLeft[A](a1: List[A], a2: List[A]): List[A] =
  Exercise3_10.foldLeft(Exercise3_12.reverse(a1), a2)((a, b) => Cons(b, a))
}

object Exercise3_15 {
  // 複数のリストからなるリストを１つのリストとして連結するconcatを実装せよ
  def concat[A](l: List[List[A]]): List[A] =
  List.foldRight(l, Nil: List[A])(List.append)
}

object Exercise3_16 {
  // 各要素に1を足しわせるplusOneを実装せよ
  def plusOne(l: List[Int]): List[Int] =
  List.foldRight(l, Nil: List[Int])((x, xs) => Cons(x + 1, xs))
}

object Exercise3_17 {
  // Doubleの各要素をStringに変換するdoubleToStringを実装せよ
  def doubleToString(l: List[Double]): List[String] =
  List.foldRight(l, Nil: List[String])((x, xs) => Cons(x.toString, xs))
}

object Exercise3_18 {
  // リストの各要素を展開し、かつリストの構造を保つmapを実装せよ
  def map[A, B](l: List[A])(f: A => B): List[B] =
  List.foldRight(l, Nil: List[B])((x, xs) => Cons(f(x), xs))
}

object Exercise3_19 {
  // 与えられた述語条件が満たされるまでリストから要素を削除するるfilterを実装せよ
  def filter[A](l: List[A])(f: A => Boolean): List[A] =
  List.foldRight(l, Nil: List[A])((x, xs) => if (f(x)) Cons(x, xs) else xs)
}

object Exercise3_20 {
  // mapと同じような動きをするflatMapを実装せよ
  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] =
  Exercise3_15.concat(Exercise3_18.map(l)(f))
}

object Exercise3_21 {
  // flatMapを用いてfilterを実装せよ
  def filterViaFlatMap[A](l: List[A])(f: A => Boolean): List[A] =
  Exercise3_20.flatMap(l)(a => if (f(a)) List(a) else Nil)
}

object Exercise3_22 {
  // リストを２つ受け取り、対応する要素同士を足し合わせるaddPairwiseを実装せよ
  def addPairwise(a: List[Int], b: List[Int]): List[Int] = (a, b) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(x1, xs1), Cons(x2, xs2)) => Cons(x1 + x2, addPairwise(xs1, xs2))
  }
}

object Exercise3_23 {
  // addPairwiseの要素を一般化したzipWithを実装せよ
  def zipWith[A, B, C](a: List[A], b: List[B])(f: (A, B) => C): List[C] = (a, b) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(x1, xs1), Cons(x2, xs2)) => Cons(f(x1, x2), zipWith(xs1, xs2)(f))
  }
}

// Listに別のListがサブシーケンスを含んでいるか調べるhasSubsequenceを実装せよ
// 特定のリストで始まっているか調べるstartsWithを実装して呼ぶとよい
object Exercise3_24 {
  @annotation.tailrec
  def startsWith[A](l: List[A], prefix: List[A]): Boolean = (l, prefix) match {
    case (_, Nil) => true
    case (Cons(h, t), Cons(h2, t2)) if h == h2 => startsWith(t, t2)
    case _ => false
  }

  @annotation.tailrec
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = sup match {
    case Nil => sub == Nil
    case _ if startsWith(sup, sub) => true
    case Cons(_, t) => hasSubsequence(t, sub)
  }
}

object Exercise3_25 {
  // 二分木のノード数を数えるsizeを実装せよ
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => size(l) + size(r) + 1
  }
}

object Exercise3_26 {
  // 二分木の最大の要素を返すmaximumを実装せよ
  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(n) => n
    case Branch(l, r) => maximum(l).max(maximum(r))
  }
}

object Exercise3_27 {
  // 二分木のルートから任意のLeafまでの最長パスを返すdepth関数を実装せよ
  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 0
    case Branch(l, r) => (depth(l).max(depth(r))) + 1
  }
}

object Exercise3_28 {
  // 二分木の各要素を特定の関数を使って変更するmap関数を記述せよ。
  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(a) => Leaf(f(a))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }
}

object Exercise3_29 {
  // size,maximum,depth,mapを一般化し、それらの類似点を抽象化する新しいfold関数を記述せよ。
  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
    case Leaf(a) => f(a)
    case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
  }

  // foldを使ってsizeを実装せよ
  def sizeViaFold[A](t: Tree[A]): Int = {
    fold(t)(a => 1)(_ + _ + 1)
  }

  // foldを使ってmaximumを実装せよ
  def maximumViaFold(t: Tree[Int]): Int = {
    fold(t)(a => a)(_ max _)
  }

  // foldを使ってdepthを実装せよ
  def depthViaFold[A](t: Tree[A]): Int = {
    fold(t)(a => 0)(_ max _ + 1)
  }

  // foldを使ってmapを実装せよ
  def mapViaFold[A, B](t: Tree[A])(f: A => B): Tree[B] = {
    fold(t)(a => Leaf(f(a)): Tree[B])(Branch(_,_))
  }
}