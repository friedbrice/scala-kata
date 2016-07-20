package net.danielbrice.scalakata

object SmallestTwo {

  /**
   * I. SmallestTwo
   *
   * Given: a finite list of integers, return the smallest and the second smallest,
   *
   * When: your function is called on said list,
   *
   * Then: your function returns the smallest and next smallest elements as a tuple.
   *
   * Special Requirement: This function is trivial to implement using two list traversals.
   * Try to make your solution use only one list traversal (the hidden tests will
   * pass a series of VERY large lists to justify this design requirement.)
   */

  def smallestTwo
  : List[Int] => (Int, Int)
  = ints      => {

    val firstInt = ints.head
    val secondInt = ints.drop(1).head
    val restInts = ints.drop(2)

    def helper
    : (Int, Int) => List[Int] => (Int, Int)
    = (a, b)     => {
      case Nil     => (a, b)
      case x :: xs => {
        if (x < a) helper(x, a)(xs)
        else if (x < b) helper(a, x)(xs)
        else helper(a, b)(xs)
      }
    }

    val initA = Math.min(firstInt, secondInt)
    val initB = Math.max(firstInt, secondInt)

    helper(initA, initB)(restInts)
  }
}
