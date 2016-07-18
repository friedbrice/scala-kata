package net.danielbrice.scalakata

object PolymorphicMapReduce {

  /*
   * VII. PolymorphicMapReduce
   *
   * Implement a function with type signature
   * `(T => S) => (S => R => R) => R => List[T] => R`.
   *
   * The only requirement is that it must be possible for the return value to be
   * different from the third argument.
   */

  def mapReduce[T,S,R]
  : (T => S) => (S => R => R) => R => List[T] => R
  = f        => g             => z => l       => {

    ???

  }
}
