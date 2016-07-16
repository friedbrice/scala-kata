object TreePolymorphicMapReduce {

  /**
   * IX. TreePolymorphicMapReduce
   *
   * Implement a function with type signature
   * `(T => S) => (S => R => R) => R => Tree[T] => R`.
   *
   * The only requirement is that it must be possible for the return value to be
   * different from the third argument.
   */

  sealed trait Tree[+T]
  case object Leaf extends Tree[Nothing]
  case class Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

  def treeMapReduce[T,S,R]
    : (T => S) => (S => R => R) => R => Tree[T] => R
    = f        => g             => z => t       => {

      ???

    }
}

object TreePolymorphicMapReduceTests {

}
