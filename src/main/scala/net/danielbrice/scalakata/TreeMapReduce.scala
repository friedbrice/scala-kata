package net.danielbrice.scalakata

object TreeMapReduce {

  /**
   * IX. TreeMapReduce
   *
   * Implement a function with type signature
   * `(A => B) => ((B, B) => B) => B => Tree[A] => B`.
   *
   * The only requirements are that it must be possible for the return value to
   * be different from the third argument and that it "preserves" the order of
   * the passed tree (whatever that means).
   */

  sealed trait Tree[+T]
  case object Leaf extends Tree[Nothing]
  case class Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

  def treeMapReduce[A,B]
    : (A => B) => ((B, B) => B) => B => Tree[A] => B
    = f        => g             => z => t       => {

      ??? // TODO: Solve Me!

    }
}
