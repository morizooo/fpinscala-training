package Exercise5


object Exercise5_9 {
  // nで始まってn+1,n+2と続く整数の無限ストリームを生成する関数を実装せよ
  def from(n: Int): Stream[Int] = ???
}

object Exercise5_10 {
  // フィボナッチ数列(0,1,1,2,3,5,8...)の無限ストリームを生成する関数を実装せよ
  val fibs = ???
}

object Exercise5_11 {
  // 汎用的なストリーム生成関数を実装せよ
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = ???
}

object Exercise5_12 {
  // unfoldを使ってfibs,from,constant,onesを実装せよ
  val fibsViaUnfold = ???

  def fromViaUnfold(n: Int) = ???

  def constantViaUnfold[A](a: A) = ???

  val onesViaUnfold = ???
}

