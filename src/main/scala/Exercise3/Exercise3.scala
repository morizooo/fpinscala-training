package Exercise3

object Exercise3_1 {
  def main(args: Array[String]): Unit = {
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }
    println(x)
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }
}

object Exercise3_2 {
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("empty list")
    case Cons(_, xs) => xs
  }
}

object Exercise3_3 {
  def setHead[A](l: List[A], h: A): List[A] = l match {
    case Nil => sys.error("empty list")
    case Cons(_, xs) => Cons(h, xs)
  }
}

object Exercise3_4 {
  def drop[A](l: List[A], n: Int): List[A] =
    if (n <= 0) l
    else l match {
      case Nil => Nil
      case Cons(_, xs) => drop(xs, n - 1)
    }
}

object Exercise3_5 {
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(x, xs) if f(x) => dropWhile(xs, f)
    case _ => l
  }
}

object Exercise3_6 {
  def init[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("empty list")
    case Cons(_, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }
}

object Exercise3_8 {
  def main(args: Array[String]): Unit = {
    println(List.foldRight(Cons(1, Cons(2, Cons(3, Nil))), Nil: List[Int])(Cons(_, _)))
  }
}

object Exercise3_9 {
  def length[A](l: List[A]): Int = List.foldRight(l, 0)((_, acc) => acc + 1)
}

object Exercise3_10 {
  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = l match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)

  }
}

object Exercise3_11 {
  def sum(l: List[Int]) = Exercise3_10.foldLeft(l, 0)(_ + _)

  def product(l: List[Double]) = Exercise3_10.foldLeft(l, 1.0)(_ * _)

  def length[A](l: List[A]): Int = Exercise3_10.foldLeft(l, 0)((acc, _) => acc + 1)
}

object Exercise3_12 {
  def reverse[A](l: List[A]): List[A] = ???
}

object Exercise3_13 {
  def foldRightViaFoldLeft[A, B](l: List[A], z: B)(f: (A, B) => B): B = ???

  def foldLeftViaFoldRight[A, B](l: List[A], z: B)(f: (B, A) => B): B = ???
}

object Exercise3_14 {
  def append[A](a1: List[A], a2: List[A]): List[A] = ???
}

object Exercise3_15 {
  def concat[A](l: List[List[A]]): List[A] = ???
}

object Exercise3_16 {
  def plusOne(l: List[Int]): List[Int] = ???
}

object Exercise3_17 {
  def doubleToString(l: List[Double]): List[String] = ???
}

object Exercise3_18 {
  def map[A, B](l: List[A])(f: A => B): List[B] = ???
}

object Exercise3_19 {
  def filter[A](l: List[A])(f: A => Boolean): List[A] = ???
}

object Exercise3_20 {
  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = ???
}

object Exercise3_21 {
  def filterViaFlatMap[A](l: List[A])(f: A => Boolean): List[A] = ???
}

object Exercise3_22 {
  def addPairwise(a: List[Int], b: List[Int]): List[Int] = ???
}

object Exercise3_23 {
  def zipWith[A, B, C](a: List[A], b: List[B])(f: (A, B) => C): List[C] = ???
}

object Exercise3_24 {
  //  @annotation.tailrec
  def startsWith[A](l: List[A], prefix: List[A]): Boolean = ???

  //  @annotation.tailrec
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = ???
}

object Exercise3_25 {
  def size[A](t: Tree[A]): Int = ???
}

object Exercise3_26 {
  def maximum(t: Tree[Int]): Int = ???
}

object Exercise3_27 {
  def depth[A](t: Tree[A]): Int = ???
}

object Exercise3_28 {
  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = ???
}

object Exercise3_29 {
  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = ???

  def sizeViaFold[A](t: Tree[A]): Int = ???

  def maximumViaFold(t: Tree[Int]): Int = ???

  def depthViaFold[A](t: Tree[A]): Int = ???

  def mapViaFold[A, B](t: Tree[A])(f: A => B): Tree[B] = ???
}