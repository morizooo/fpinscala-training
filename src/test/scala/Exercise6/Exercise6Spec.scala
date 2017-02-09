package Exercise6

import org.specs2.mutable.Specification
import Exercise6.RNG.Simple

class Exercise6_1Spec extends Specification {
  "Exercise6_1_nonNegativeInt" should {
    "正の値でもランダムな整数を生成できること" in {
      val rng = Simple(1)
      RNG.nonNegativeInt(rng) must be_==((rng.nextInt))
    }
    "負の値でもランダムな整数を生成できること" in {
      val rng = Simple(-1)
      RNG.nonNegativeInt(rng) must be_==((-(rng.nextInt._1 + 1), rng.nextInt._2))
    }
    "正の値の最大値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MaxValue)
      RNG.nonNegativeInt(rng) must be_==((rng.nextInt))
    }
    "負の値の最小値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MinValue)
      RNG.nonNegativeInt(rng) must be_==((-(rng.nextInt._1 + 1), rng.nextInt._2))
    }
  }
}

class Exercise6_2Spec extends Specification {
  "Exercise6_2_double" should {
    "正の値でもランダムな整数を生成できること" in {
      val rng = Simple(1)
      RNG.double(rng) must be_==((rng.nextInt._1 / (Int.MaxValue.toDouble + 1), rng.nextInt._2))
    }
    "負の値でもランダムな整数を生成できること" in {
      val rng = Simple(-1)
      RNG.double(rng) must be_==((-(rng.nextInt._1 + 1) / (Int.MaxValue.toDouble + 1), rng.nextInt._2))
    }
    "正の値の最大値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MaxValue)
      RNG.double(rng) must be_==((rng.nextInt._1 / (Int.MaxValue.toDouble + 1), rng.nextInt._2))
    }
    "負の値の最小値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MinValue)
      RNG.double(rng) must be_==((-(rng.nextInt._1 + 1) / (Int.MaxValue.toDouble + 1), rng.nextInt._2))
    }
  }
}

class Exercise6_3_intDoubleSpec extends Specification {
  "Exercise6_3_intDouble" should {
    "正の値でもランダムな整数を生成できること" in {
      val rng = Simple(1)
      val (i, r1) = rng.nextInt
      val (d, r2) = RNG.double(r1)
      RNG.intDouble(rng) must be_==(((i, d), r2))
    }
    "負の値でもランダムな整数を生成できること" in {
      val rng = Simple(-1)
      val (i, r1) = rng.nextInt
      val (d, r2) = RNG.double(r1)
      RNG.intDouble(rng) must be_==(((i, d), r2))
    }
    "正の値の最大値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MaxValue)
      val (i, r1) = rng.nextInt
      val (d, r2) = RNG.double(r1)
      RNG.intDouble(rng) must be_==(((i, d), r2))
    }
    "負の値の最小値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MinValue)
      val (i, r1) = rng.nextInt
      val (d, r2) = RNG.double(r1)
      RNG.intDouble(rng) must be_==(((i, d), r2))
    }
  }
}

class Exercise6_3_doubleIntSpec extends Specification {
  "Exercise6_3_doubleInt" should {
    "正の値でもランダムな整数を生成できること" in {
      val rng = Simple(1)
      val ((i, d), r) = AnswerRNG.intDouble(rng)
      RNG.doubleInt(rng) must be_==(((d, i), r))
    }
    "負の値でもランダムな整数を生成できること" in {
      val rng = Simple(-1)
      val ((i, d), r) = AnswerRNG.intDouble(rng)
      RNG.doubleInt(rng) must be_==(((d, i), r))
    }
    "正の値の最大値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MaxValue)
      val ((i, d), r) = AnswerRNG.intDouble(rng)
      RNG.doubleInt(rng) must be_==(((d, i), r))
    }
    "負の値の最小値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MinValue)
      val ((i, d), r) = AnswerRNG.intDouble(rng)
      RNG.doubleInt(rng) must be_==(((d, i), r))
    }
  }
}

class Exercise6_3_double3 extends Specification {
  "Exercise6_3_double3" should {
    "正の値でもランダムな整数を生成できること" in {
      val rng = Simple(1)
      val (d1, r1) = AnswerRNG.double(rng)
      val (d2, r2) = AnswerRNG.double(r1)
      val (d3, r3) = AnswerRNG.double(r2)
      RNG.double3(rng) must be_==(((d1, d2, d3), r3))
    }
    "負の値でもランダムな整数を生成できること" in {
      val rng = Simple(-1)
      val (d1, r1) = AnswerRNG.double(rng)
      val (d2, r2) = AnswerRNG.double(r1)
      val (d3, r3) = AnswerRNG.double(r2)
      RNG.double3(rng) must be_==(((d1, d2, d3), r3))
    }
    "正の値の最大値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MaxValue)
      val (d1, r1) = AnswerRNG.double(rng)
      val (d2, r2) = AnswerRNG.double(r1)
      val (d3, r3) = AnswerRNG.double(r2)
      RNG.double3(rng) must be_==(((d1, d2, d3), r3))
    }
    "負の値の最小値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MinValue)
      val (d1, r1) = AnswerRNG.double(rng)
      val (d2, r2) = AnswerRNG.double(r1)
      val (d3, r3) = AnswerRNG.double(r2)
      RNG.double3(rng) must be_==(((d1, d2, d3), r3))
    }
  }
}

class Exercise6_4_Ints extends Specification {
  "Exercise6_4_Ints" should {
    "0を指定した場合に、空のリストが返って来ること" in {
      val rng = Simple(1)
      RNG.ints(0)(rng) must be_==(List(), rng)
    }
    "1を指定した場合に、空のリストが返って来ること" in {
      val rng = Simple(1)
      RNG.ints(1)(rng) must be_==(List(rng.nextInt._1), rng.nextInt._2)
    }
    "2を指定した場合に、空のリストが返って来ること" in {
      val rng = Simple(1)
      val (d1, rng2) = rng.nextInt
      RNG.ints(2)(rng) must be_==(List(rng.nextInt._1, rng2.nextInt._1), rng2.nextInt._2)
    }
  }
}

class Exercise6_5Spec extends Specification {
  "Exercise6_5_double" should {
    "正の値でもランダムな整数を生成できること" in {
      val rng = Simple(1)
      RNG._double(rng) must be_==((rng.nextInt._1 / (Int.MaxValue.toDouble + 1), rng.nextInt._2))
    }
    "負の値でもランダムな整数を生成できること" in {
      val rng = Simple(-1)
      RNG._double(rng) must be_==((-(rng.nextInt._1 + 1) / (Int.MaxValue.toDouble + 1), rng.nextInt._2))
    }
    "正の値の最大値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MaxValue)
      RNG._double(rng) must be_==((rng.nextInt._1 / (Int.MaxValue.toDouble + 1), rng.nextInt._2))
    }
    "負の値の最小値でもランダムな整数を生成できること" in {
      val rng = Simple(Int.MinValue)
      RNG._double(rng) must be_==((-(rng.nextInt._1 + 1) / (Int.MaxValue.toDouble + 1), rng.nextInt._2))
    }
  }
}

trait AnswerRNG {
  def nextInt: (Int, RNG)
}

object AnswerRNG {

  case class Simple(seed: Long) extends RNG {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      // `&` is bitwise AND. We use the current seed to generate a new seed.
      val nextRNG = Simple(newSeed)
      // The next state, which is an `RNG` instance created from the new seed.
      val n = (newSeed >>> 16).toInt // `>>>` is right binary shift with zero fill. The value `n` is our new pseudo-random integer.
      (n, nextRNG) // The return value is a tuple containing both a pseudo-random integer and the next `RNG` state.
    }
  }

  type Rand[+A] = RNG => (A, RNG)

  val int: Rand[Int] = _.nextInt

  def unit[A](a: A): Rand[A] =
    rng => (a, rng)

  def map[A, B](s: Rand[A])(f: A => B): Rand[B] =
    rng => {
      val (a, rng2) = s(rng)
      (f(a), rng2)
    }

  // Exercise6_1
  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (i, r) = rng.nextInt
    (if (i < 0) -(i + 1) else i, r)
  }

  // Exercise6_2
  def double(rng: RNG): (Double, RNG) = {
    val (i, r) = nonNegativeInt(rng)
    (i / (Int.MaxValue.toDouble + 1), r)
  }

  // Exercise6_3
  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (i, r1) = rng.nextInt
    val (d, r2) = double(r1)
    ((i, d), r2)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val ((i, d), r) = intDouble(rng)
    ((d, i), r)
  }

  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val (d1, r1) = double(rng)
    val (d2, r2) = double(r1)
    val (d3, r3) = double(r2)
    ((d1, d2, d3), r3)
  }

  // Exercise6_4
  def ints(count: Int)(rng: RNG): (List[Int], RNG) =
    if (count == 0)
      (List(), rng)
    else {
      val (x, r1) = rng.nextInt
      val (xs, r2) = ints(count - 1)(r1)
      (x :: xs, r2)
    }

  // Exercise6_6
  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    rng => {
      val (a, r1) = ra(rng)
      val (b, r2) = rb(r1)
      (f(a, b), r2)
    }

  // Exercise6_7
  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] =
    fs.foldRight(unit(List[A]()))((f, acc) => map2(f, acc)(_ :: _))

  // Exercise6_8
  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] =
    rng => {
      val (a, r1) = f(rng)
      g(a)(r1) // We pass the new state along
    }

}