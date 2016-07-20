package net.danielbrice.scalakata

object UseMapReduce {

  /**
   * VIII. UseMapReduce
   *
   * Re-implement "SmallestTwo" and "SumsProds" using the polymorphic
   * map reduce higher-order function.
   */

  def mapReduce[T,S,R]
    : (T => S) => (S => R => R) => R => List[T] => R
    = f        => g             => z => {
      case Nil => z
      case x :: xs => g(f(x))(mapReduce(f)(g)(z)(xs))
    }

  def smallestTwoCombiner
    : Int => ((Int, Int))  => (Int, Int)
    = x   => { case (a, b) => if (x < a) (x, a) else if (x < b) (a, x) else (a, b) }

  def smallestTwo
    : List[Int] => (Int, Int)
    = ints      => {
      val a = Math.min(ints.head, ints.drop(1).head)
      val b = Math.max(ints.head, ints.drop(1).head)
      mapReduce((x : Int) => x)(smallestTwoCombiner)(a, b)(ints.drop(2))
    }

  def sumProdsCombiner
    : ((Double, Double)) => ((Double, Double, Double, Double)) => (Double, Double, Double, Double)
    = { case (x, y)      => { case (a, b, c, d)                => (x+a, y+b, x*c, y*d) } }

  def sumsProds
    : List[(Double, Double)] => (Double, Double, Double, Double)
    = pairs                  => mapReduce((x : (Double, Double)) => x)(sumProdsCombiner)((0.0, 0.0, 1.0, 1.0))(pairs)
}
