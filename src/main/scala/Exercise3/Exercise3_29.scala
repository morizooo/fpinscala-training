package Exercise3

object Exercise3_29 {

  def fold[A,B](t: Tree[A])(f: A => B)(g: (B,B) => B): B = ???

  def sizeViaFold[A](t: Tree[A]): Int = ???

  def maximumViaFold(t: Tree[Int]): Int = ???

  def depthViaFold[A](t: Tree[A]): Int = ???

  def mapViaFold[A,B](t: Tree[A])(f: A => B): Tree[B] = ???
}
