package Exercise4

sealed trait Option[+A] {
  // Exercise4_1
  def map[B](f: A => B): Option[B] = ???

  def getOrElse[B >: A](default: => B): B = ???

  def flatMap[B](f: A => Option[B]): Option[B] = ???

  def orElse[B >: A](ob: => Option[B]): Option[B] = ???

  def filter(f: A => Boolean): Option[A] = ???
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

