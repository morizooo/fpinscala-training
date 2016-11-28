package Exercise5


object Exercise5_9 {
  def from(n: Int): Stream[Int] = ???
}

object Exercise5_10 {
  val fibs = ???
}

object Exercise5_11 {
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = ???
}

object Exercise5_12 {
  val fibsViaUnfold = ???

  def fromViaUnfold(n: Int) = ???

  def constantViaUnfold[A](a: A) = ???

  val onesViaUnfold = ???
}

