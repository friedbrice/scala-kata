package net.danielbrice.scalakata

object UseMapReduce {

  /**
   * VIII. UseMapReduce
   *
   * Re-implement "SmallestTwo" and "SumsProds" using the polymorphic
   * map reduce higher-order function.
   */

  def mapReduce[A,B]
    : (A => B) => ((B, B) => B) => B => List[A] => B
    = f        => g             => z => {
      case Nil => z
      case x :: xs => g(f(x), mapReduce(f)(g)(z)(xs))
    }

  def smallestTwoMapper
    : Int => (Int, Int)
    = x   => (x, x)

  def smallestTwoReducer
    : ((Int, Int), (Int, Int)) => (Int, Int)
    = { case ((x, _), (a, b)) => if (x < a) (x, a) else if (x < b) (a, x) else (a, b) }

  def smallestTwo
    : List[Int] => (Int, Int)
    = ints      => {
      val a = Math.min(ints.head, ints.drop(1).head)
      val b = Math.max(ints.head, ints.drop(1).head)
      mapReduce(smallestTwoMapper)(smallestTwoReducer)(a, b)(ints.drop(2))
    }

  def sumsProdsMapper
    : ((Double, Double)) => (Double, Double, Double, Double)
    = { case (x, y) => (x, y, x, y) }

  def sumsProdsReducer
    : ((Double, Double, Double, Double), (Double, Double, Double, Double)) => (Double, Double, Double, Double)
    = { case ((a1, b1, c1, d1), (a2, b2, c2, d2)) => (a1+a2, b1+b2, c1*c2, d1*d2) }

  def sumsProds = mapReduce(sumsProdsMapper)(sumsProdsReducer)((0.0, 0.0, 1.0, 1.0))
}
