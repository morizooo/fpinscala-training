package Exercise5

trait Stream[+A] {
  // Exercise5_1 StreamをListに変換し、それによりストリームを強制的に評価する関数を実装せよ
  def toList: List[A] = ???
  // @annotation.tailrec

  // Exercise5_2
  // Streamの先頭からn個の要素を取り出す関数を実装せよ
  def take(n: Int): Stream[A] = ???

  // Streamの先頭からn個の要素をスキップする関数を実装せよ
  def drop(n: Int): Stream[A] = ???

  // Exercise5_3 Streamの先頭から指定された述語とマッチする要素をすべて取り出す関数を実装せよ
  def takeWhile(p: A => Boolean): Stream[A] = ???

  // Exercise5_4 Streamの要素のうち、指定された述語とマッチするするものをすべてチェックする関数を実装せよ
  // この実装ではマッチしない値が検出された時点でチェックを終了しなければならない
  def forAll(p: A => Boolean): Boolean = ???

  // Exercise5_5 foldRightを使ってtakeWhileを実装せよ
  def takeWhileViaFoldRight(p: A => Boolean): Stream[A] = ???

  // Exercise5_6 foldRightを使ってheadOptionを実装せよ
  def headOptionViaFoldRight: Option[A] = ???

  // Exercise5_7 foldRightを使ってmap, filter, append, flatMapを実装せよ。
  def map[B](f: A => B): Stream[B] = ???

  def filter(f: A => Boolean): Stream[A] = ???

  // 引数に対して非正格でなければならない
  def append[B >: A](s: => Stream[B]): Stream[B] = ???

  def flatMap[B](f: A => Stream[B]): Stream[B] = ???

  // Exercise5_8 onesを少し一般化した、指定された値の無限ストリームを返す関数を実装せよ
  def constant[A](a: A): Stream[A] = ???

  // Exercise5_13 unfoldを使ってmap, take, takeWhile, zipWith, zipAllを実装せよ
  def mapViaUnfold[B](f: A => B): Stream[B] = ???

  def takeViaUnfold(n: Int): Stream[A] = ???

  def takeWhileViaUnfold(f: A => Boolean): Stream[A] = ???

  def zipWithViaUnfold[B, C](s2: Stream[B])(f: (A, B) => C): Stream[C] = ???

  // special case of `zipWith`
  def zip[B](s2: Stream[B]): Stream[(A, B)] = ???

  def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = ???

  def zipWithAll[B, C](s2: Stream[B])(f: (Option[A], Option[B]) => C): Stream[C] = ???

  // Exercise5_14 あるStreamが別のStreamのprefixであるかどうか調べる関数を実装せよ
  def startsWith[B](s: Stream[B]): Boolean = ???

  // Exercise5_15 unfoldを使ってtailsを実装せよ
  def tails: Stream[Stream[A]] = ???

  // Exercise5_16 tailsを一般化した関数を実装せよ
  def scanRight[B](z: B)(f: (A, => B) => B): Stream[B] = ???
}

case object Empty extends Stream[Nothing]

case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) empty
    else cons(as.head, apply(as.tail: _*))

  val ones: Stream[Int] = Stream.cons(1, ones)

  // Exercise5_9 nで始まってn+1,n+2と続く整数の無限ストリームを生成する関数を実装せよ
  def from(n: Int): Stream[Int] = ???

  // Exercise5_10 フィボナッチ数列(0,1,1,2,3,5,8...)の無限ストリームを生成する関数を実装せよ
  val fibs = ???

  // Exercise5_11 汎用的なストリーム生成関数を実装せよ
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = ???

  // Exercise5_12 unfoldを使ってfibs,from,constant,onesを実装せよ
  val fibsViaUnfold = ???

  def fromViaUnfold(n: Int) = ???

  def constantViaUnfold[A](a: A) = ???

  val onesViaUnfold = ???
}