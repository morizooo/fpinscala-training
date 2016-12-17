package Exercise4

sealed trait Option[+A] {
  // Exercise4_1 下記の関数を実装せよ
  // OptionがNoneでない場合はfを適用する
  def map[B](f: A => B): Option[B] = ???

  // OptionがNoneでない場合は、失敗する可能性があるfを適用する
  def flatMap[B](f: A => Option[B]): Option[B] = ???

  // OptionがNoneの時に、指定したデフォルト値を適用する
  def getOrElse[B >: A](default: => B): B = ???

  // OptionがNoneだったら、指定したデフォルトのOption型を返す
  def orElse[B >: A](ob: => Option[B]): Option[B] = ???

  // 値がfの条件を満たさない場合は、SomeをNoneに変換する
  def filter(f: A => Boolean): Option[A] = ???
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

