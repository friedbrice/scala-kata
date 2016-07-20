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
  }

  case object Leaf extends Tree[Nothing] {
    def mapReduce[S] = _ => _ => acc => acc
  }

  case class Branch[T](v: T, l: Tree[T], r: Tree[T]) extends Tree[T] {
    def mapReduce[S] = map => reduce => acc => {
      val acc2 = reduce(map(v), r.mapReduce(map)(reduce)(acc))
      l.mapReduce(map)(reduce)(acc2)
    }
  }
}
