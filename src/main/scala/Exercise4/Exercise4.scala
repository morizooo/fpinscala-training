package Exercise4

object Exercise4_2 {
  // flatMapをベースとして分散を求めるvarianceを実装せよ
  // シーケンスの平均をm,シーケンスの各要素をxとすれば分散は math.pow(x - m, 2)
  def variance(xs: Seq[Double]): Option[Double] = {
    mean(xs).flatMap(m => mean(xs.map(x => math.pow(x - m, 2))))
  }

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
}

object Exercise4_3 {
  // 2項関数を使ってOption型の2つの値を結合する関数を実装せよ
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a.flatMap(aa => b.map(bb => f(aa, bb)))
  }
}

object Exercise4_4 {
  // Optionのリストを1つのリストにまとめる関数を実装せよ
  // 元の関数に1つでもNoneがあればNoneを返す。
  def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
    case Nil => Some(Nil)
    case h :: t => h.flatMap(hh => sequence(t).map(hh :: _))
  }
}

object Exercise4_5 {
  // 以下の特長をもつ関数を実装せよ
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case Nil => Some(Nil)
    case h :: t => Exercise4_3.map2(f(h), traverse(t)(f))(_ :: _)
  }
}

object Exercise4_7 {
  // Optionで実装した関数をEitherで実装せよ
  def traverse[E, A, B](es: List[A])(f: A => Either[E, B]): Either[E, List[B]] = es match {
    case Nil => Right(Nil)
    case h :: t => (f(h) map2 traverse(t)(f)) (_ :: _)
  }

  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = {
    traverse(es)(x => x)
  }
}