package net.danielbrice.scalakata

object MethodTreeMapReduce {

  /**
    * X. MethodTreeMapReduce
    *
    * Refactor `treeMapReduce` so that it is a method of `Tree[T]`
    * rather than a top-level function.
    */

  sealed trait Tree[+T]
  case object Leaf extends Tree[Nothing]
  case class Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]
}
