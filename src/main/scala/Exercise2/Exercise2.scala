package Exercise2

object Exercise2_1 {
  // n番目のフィボナッチ数列を取得するfibを実装せよ
  def fib(n: Int): Int = ???
}

object Exercise2_2 {
  // Array[A]がソートされているか調べるisSortedを実装せよ
  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = ???
}

object Exercise2_3 {
  // 引数2つの関数fが、fを部分的に適用する引数1つの関数に変換されるcurryを実装せよ
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = ???
}

object Exercise2_4 {
  // curryによる変換を逆向きに行うuncurryを実装せよ。
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = ???
}

object Exercise2_5 {
  // 2つの関数を合成する高階関数composeを実装せよ
  def compose[A, B, C](f: B => C, g: A => B): A => C = ???
}
