package Exercise2

object Exercise2_1 {
  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int =
      if (n == 0) prev
      else loop(n - 1, cur, prev + cur)
    loop(n, 0, 1)
  }
}

object Exercise2_2 {
  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (gt(as(n), as(n + 1))) false
      else loop(n + 1)
    loop(0)
  }
}

object Exercise2_3 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)
}

object Exercise2_4 {
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)
}

object Exercise2_5 {
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))
}
