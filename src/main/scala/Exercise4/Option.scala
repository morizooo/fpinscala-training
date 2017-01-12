package Exercise4

sealed trait Option[+A] {
  // Exercise4_1 下記の関数を実装せよ
  // OptionがNoneでない場合はfを適用する
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a) => Some(f(a))
  }

  // OptionがNoneでない場合は、失敗する可能性があるfを適用する
  def flatMap[B](f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(a) => f(a)
  }

  // OptionがNoneの時に、指定したデフォルト値を適用する
  def getOrElse[B >: A](default: => B): B = this match {
    case None => default
    case Some(a) => a
  }

  // OptionがNoneだったら、指定したデフォルトのOption型を返す
  def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
    case None => ob
    case _ => this
  }

  // 値がfの条件を満たさない場合は、SomeをNoneに変換する
  def filter(f: A => Boolean): Option[A] = this match {
    case Some(a) if f(a) => this
    case _ => None
  }
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

