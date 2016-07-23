package net.danielbrice.scalakata

object MethodTreeMapReduce {

  /**
   * X. MethodTreeMapReduce
   *
   * Refactor `treeMapReduce` so that it is a method of `Tree[T]`
   * rather than a top-level function.
   */

  sealed trait Tree[+T] {
    def mapReduce[S]
      : (T => S) => ((S, S) => S) => S => S
      = f        => g             => z => ???
  }

  case object Leaf extends Tree[Nothing]

  case class Branch[T](v: T, l: Tree[T], r: Tree[T]) extends Tree[T]
}
