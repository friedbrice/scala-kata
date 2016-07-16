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

  sealed trait Tree[+T]
  case object Leaf extends Tree[Nothing]
  case class Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

  def validateTree[Int]
    : Tree[Int] => Boolean
    = t         => ???
}

object ValidateTreeTests {

}
