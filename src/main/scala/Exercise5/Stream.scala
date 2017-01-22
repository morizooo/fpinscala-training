package Exercise5

trait Stream[+A] {
  // Exercise5_1 StreamをListに変換し、それによりストリームを強制的に評価する関数を実装せよ
  def toList: List[A] = {
    @annotation.tailrec
    def go(s: Stream[A], acc: List[A]): List[A] = s match {
      case Cons(h, t) => go(t(), h() :: acc)
      case _ => acc
    }

    go(this, List()).reverse
  }

  // Exercise5_2
  // Streamの先頭からn個の要素を取り出す関数を実装せよ
  def take(n: Int): Stream[A] = this match {
    case Cons(h, t) if n > 1 => Stream.cons(h(), t().take(n - 1))
    case Cons(h, _) if n == 1 => Stream.cons(h(), Stream.empty)
    case _ => Stream.empty
  }

  // Streamの先頭からn個の要素をスキップする関数を実装せよ
  @annotation.tailrec
  final def drop(n: Int): Stream[A] = this match {
    case Cons(_, t) if n > 0 => t().drop(n - 1)
    case _ => this
  }

  // Exercise5_3 Streamの先頭から指定された述語とマッチする要素をすべて取り出す関数を実装せよ
  def takeWhile(f: A => Boolean): Stream[A] = this match {
    case Cons(h, t) if f(h()) => Stream.cons(h(), t() takeWhile f)
    case _ => Stream.empty
  }

  def foldRight[B](z: => B)(f: (A, => B) => B): B = // The arrow `=>` in front of the argument type `B` means that the function `f` takes its second argument by name and may choose not to evaluate it.
    this match {
      case Cons(h, t) => f(h(), t().foldRight(z)(f)) // If `f` doesn't evaluate its second argument, the recursion never occurs.
      case _ => z
    }

  // Exercise5_4 Streamの要素のうち、指定された述語とマッチするするものをすべてチェックする関数を実装せよ
  // この実装ではマッチしない値が検出された時点でチェックを終了しなければならない
  def forAll(f: A => Boolean): Boolean = foldRight(true)((a, b) => f(a) && b)

  // Exercise5_5 foldRightを使ってtakeWhileを実装せよ
  def takeWhileViaFoldRight(p: A => Boolean): Stream[A] = foldRight(Stream.empty[A])((h, t) =>
    if (p(h)) Stream.cons(h, t)
    else Stream.empty)

  // Exercise5_6 foldRightを使ってheadOptionを実装せよ
  def headOptionViaFoldRight: Option[A] = foldRight(None: Option[A])((h, _) => Some(h))


  // Exercise5_7 foldRightを使ってmap, filter, append, flatMapを実装せよ。
  def map[B](f: A => B): Stream[B] =
    foldRight(Stream.empty[B])((h, t) => Stream.cons(f(h), t))

  def filter(f: A => Boolean): Stream[A] =
    foldRight(Stream.empty[A])((h, t) =>
      if (f(h)) Stream.cons(h, t)
      else t)

  // 引数に対して非正格でなければならない
  def append[B >: A](s: => Stream[B]): Stream[B] = foldRight(s)((h, t) => Stream.cons(h, t))

  def flatMap[B](f: A => Stream[B]): Stream[B] = foldRight(Stream.empty[B])((h, t) => f(h) append t)


  // Exercise5_8 onesを少し一般化した、指定された値の無限ストリームを返す関数を実装せよ
  def constant[A](a: A): Stream[A] = {
    lazy val tail: Stream[A] = Cons(() => a, () => tail)
    tail
  }

  // Exercise5_13 unfoldを使ってmap, take, takeWhile, zipWith, zipAllを実装せよ
  def mapViaUnfold[B](f: A => B): Stream[B] = Stream.unfold(this) {
    case Cons(h, t) => Some((f(h()), t()))
    case _ => None
  }

  def takeViaUnfold(n: Int): Stream[A] = Stream.unfold((this, n)) {
    case (Cons(h, t), 1) => Some((h(), (Stream.empty, 0)))
    case (Cons(h, t), n) if n > 1 => Some((h(), (t(), n - 1)))
    case _ => None
  }

  def takeWhileViaUnfold(f: A => Boolean): Stream[A] = Stream.unfold(this) {
    case Cons(h, t) if f(h()) => Some((h(), t()))
    case _ => None
  }

  def zipWithViaUnfold[B, C](s2: Stream[B])(f: (A, B) => C): Stream[C] = Stream.unfold((this, s2)) {
    case (Cons(h1, t1), Cons(h2, t2)) =>
      Some((f(h1(), h2()), (t1(), t2())))
    case _ => None
  }

  // special case of `zipWith`
  def zip[B](s2: Stream[B]): Stream[(A, B)] = zipWithViaUnfold(s2)((_, _))

  def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = zipWithAll(s2)((_, _))

  def zipWithAll[B, C](s2: Stream[B])(f: (Option[A], Option[B]) => C): Stream[C] = Stream.unfold((this, s2)) {
    case (Empty, Empty) => None
    case (Cons(h, t), Empty) => Some(f(Some(h()), Option.empty[B]) -> (t(), Stream.empty[B]))
    case (Empty, Cons(h, t)) => Some(f(Option.empty[A], Some(h())) -> (Stream.empty[A] -> t()))
    case (Cons(h1, t1), Cons(h2, t2)) => Some(f(Some(h1()), Some(h2())) -> (t1() -> t2()))
  }

  // Exercise5_14 あるStreamが別のStreamのprefixであるかどうか調べる関数を実装せよ
  def startsWith[A](s: Stream[A]): Boolean =
    zipAll(s).takeWhile(!_._2.isEmpty) forAll {
      case (h, h2) => h == h2
    }

  // Exercise5_15 unfoldを使ってtailsを実装せよ
  def tails: Stream[Stream[A]] =
    Stream.unfold(this) {
      case Empty => None
      case s => Some((s, s drop 1))
    } append Stream(Stream.empty)

  // Exercise5_16 tailsを一般化した関数を実装せよ
  def scanRight[B](z: B)(f: (A, => B) => B): Stream[B] =
    foldRight((z, Stream(z)))((a, p0) => {
      // p0 is passed by-name and used in by-name args in f and cons. So use lazy val to ensure only one evaluation...
      lazy val p1 = p0
      val b2 = f(a, p1._1)
      (b2, Stream.cons(b2, p1._2))
    })._2
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
  def from(n: Int): Stream[Int] = Stream.cons(n, from(n + 1))

  // Exercise5_10 フィボナッチ数列(0,1,1,2,3,5,8...)の無限ストリームを生成する関数を実装せよ
  val fibs = {
    def go(f0: Int, f1: Int): Stream[Int] =
      cons(f0, go(f1, f0 + f1))

    go(0, 1)
  }

  // Exercise5_11 汎用的なストリーム生成関数を実装せよ
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] =
    f(z) match {
      case Some((h, s)) => cons(h, unfold(s)(f))
      case None => empty
    }

  // Exercise5_12 unfoldを使ってfibs,from,constant,onesを実装せよ
  val fibsViaUnfold = unfold((0, 1)) { case (f0, f1) => Some((f0, (f1, f0 + f1))) }

  def fromViaUnfold(n: Int) = unfold(n)(n => Some((n, n + 1)))

  def constantViaUnfold[A](a: A) = unfold(a)(_ => Some((a, a)))

  val onesViaUnfold = unfold(1)(_ => Some((1, 1)))
}