package Exercise4

object Exercise4_2 {
  def variance(xs: Seq[Double]): Option[Double] = ???
}

object Exercise4_3 {
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = ???
}

object Exercise4_4 {
  def sequence[A](a: List[Option[A]]): Option[List[A]] = ???
}

object Exercise4_5 {
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = ???
}

object Exercise4_7 {
  def traverse[E, A, B](es: List[A])(f: A => Either[E, B]): Either[E, List[B]] = ???

  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = ???
}