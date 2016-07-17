object UsePolymorphicMapReduce {

  /**
   * VIII. UsePolymorphicMapReduce
   *
   * Re-implement "SmallestTwo" and "SumsProds" using the polymorphic
   * map reduce higher-order function.
   */

  def mapReduce[T,S,R]
    : (T => S) => (S => R => R) => R => List[T] => R
    = f        => g             => z => ts      => {

      ???

    }

  def smallestTwo
    : List[Int] => (Int, Int)
    = ints      => ???

  def sumsProds
    : List[(Double, Double)] => ((Double, Double),(Double, Double))
    = pairs                  => ???
}

object UsePolymorphicMapReduceTests {

}
