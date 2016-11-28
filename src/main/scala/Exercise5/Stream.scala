package Exercise5

trait Stream[+A] {
  // Exercise5_2
  def take(n: Int): Stream[A] = ???

  def drop(n: Int): Stream[A] = ???

  // Exercise5_3
  def takeWhile(p: A => Boolean): Stream[A] = ???

  // Exercise5_4
  def forAll(p: A => Boolean): Boolean = ???

  // Exercise5_5
  def takeWhileViaFoldRight(p: A => Boolean): Stream[A] = ???

  // Exercise5_6
  def headOption: Option[A] = ???

  // Exercise5_7
  def map[B](f: A => B): Stream[B] = ???

  def filter(f: A => Boolean): Stream[A] = ???

  def append[B >: A](s: => Stream[B]): Stream[B] = ???

  def flatMap[B](f: A => Stream[B]): Stream[B] = ???

  // Exercise5_8
  def constant[A](a: A): Stream[A] = ???

  // Exercise5_13
  def mapViaUnfold[B](f: A => B): Stream[B] = ???

  def takeViaUnfold(n: Int): Stream[A] = ???

  def takeWhileViaUnfold(f: A => Boolean): Stream[A] = ???

  def zipWithViaUnfold[B, C](s2: Stream[B])(f: (A, B) => C): Stream[C] = ???

  // special case of `zipWith`
  def zip[B](s2: Stream[B]): Stream[(A, B)] = ???

  def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = ???

  def zipWithAll[B, C](s2: Stream[B])(f: (Option[A], Option[B]) => C): Stream[C] = ???

  // Exercise5_14
  def startsWith[B](s: Stream[B]): Boolean = ???

  // Exercise5_15
  def tails: Stream[Stream[A]] = ???

  // Exercise5_16
  def scanRight[B](z: B)(f: (A, => B) => B): Stream[B] = ???
}

case object Empty extends Stream[Nothing]

case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]