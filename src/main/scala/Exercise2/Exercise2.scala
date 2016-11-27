package Exercise2

object Exercise2_1 {
  def fib(n: Int): Int = ???
}

object Exercise2_2 {
  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = ???
}

object Exercise2_3 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = ???
}

object Exercise2_4 {
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = ???
}

object Exercise2_5 {
  def compose[A, B, C](f: B => C, g: A => B): A => C = ???
}
