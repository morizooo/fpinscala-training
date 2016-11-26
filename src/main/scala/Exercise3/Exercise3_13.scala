package Exercise3

object Exercise3_13 {
  def foldRightViaFoldLeft[A,B](l: List[A], z: B)(f: (A,B) => B): B = ???

  def foldLeftViaFoldRight[A,B](l: List[A], z: B)(f: (B,A) => B): B = ???

}
