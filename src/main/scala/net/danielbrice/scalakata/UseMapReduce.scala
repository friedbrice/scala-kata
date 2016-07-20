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
    = f        => g             => z => ts      => {

      ???

    }

  def smallestTwo
    : List[Int] => (Int, Int)
    = ints      => ???

  def sumsProds
    : List[(Double, Double)] => (Double, Double, Double, Double)
    = pairs                  => ???
}
