package net.danielbrice.scalakata

object ValidateTree {

  /**
   * V. ValidateTree
   *
   * Given: a binary tree of integer nodes,
   *
   * When: your function is called on said tree,
   *
   * Then: your function returns `true` if the tree satisfies the property that
   * for all nodes the nodes to the left have a smaller integer and the nodes
   * to the right have a larger integer, your function returns false otherwise.
   */

  // Below, we define a data struct `Tree[T]` with the following shape:
  // Tree[T] = Leaf | Branch(value : T, left : Tree[T], right : Tree[T])
  sealed trait Tree[+T]
  case object Leaf extends Tree[Nothing]
  case class Branch[T](value : T, left : Tree[T], right : Tree[T]) extends Tree[T]

  def validateTree
    : Tree[Int] => Boolean
    = {
      case Leaf => true
      case Branch(value, left, right) =>
        val maxFromLeft = ??? // TODO: implement
        val minFromRight = ??? // TODO: implement
        (value > maxFromLeft) &&
        (value < minFromRight) &&
        validateTree(left) &&
        validateTree(right)
    }

  def treeValues
    : Tree[Int] => List[Int]
    = {
      case Leaf => List()
      case Branch(value, left, right) =>
        List(value) ++ treeValues(left) ++ treeValues(right)
    }
}
