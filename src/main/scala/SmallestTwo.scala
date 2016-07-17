import SmallestTwo._
import org.scalatest._

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
    = ints      => ???
}

object SmallestTwoTests extends FlatSpec {

  "smallestTwo" should "work for a two element list with smaller first" in {
    // given: a list with two elements, the smaller coming first
    lazy val ints = List(1,2)

    // when: smallestTwo is called
    lazy val result = smallestTwo(ints)

    // then: result should be (1,2)
    result should be ((1,2))
  }

  "smallestTwo" should "work for a two element list with smaller last" in {
    // given: a list with two elements, the smaller coming first
    lazy val ints = List(2,1)

    // when: smallestTwo is called
    lazy val result = smallestTwo(ints)

    // then: result should be (1,2)
    result should be ((1,2))
  }

  "smallestTwo" should "work for a three element list" in {
    // given: a list with two elements, the smaller coming first
    lazy val ints = List(5,1,7)

    // when: smallestTwo is called
    lazy val result = smallestTwo(ints)

    // then: result should be (1,5)
    result should be ((1,5))
  }
}
