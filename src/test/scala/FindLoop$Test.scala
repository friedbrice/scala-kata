import FindLoop._
import org.scalatest.{FlatSpec, Matchers}

class FindLoop$Test extends FlatSpec with Matchers {

  "findLoop" should "return node A in list ABA" in {
    // given: a list ABA
    lazy val nodeA = ListNode('A', nodeB)
    lazy val nodeB = ListNode('B', nodeA)

    // when: findLoop is called with node A
    lazy val result = findLoop(nodeA)

    // then: the result should be node A
    result should be (nodeA)
  }

  "findLoop" should "return node B in list ABCB" in {
    // given: a list ABCB
    lazy val nodeA = ListNode('A', nodeB)
    lazy val nodeB = ListNode('B', nodeC)
    lazy val nodeC = ListNode('C', nodeB)

    // when: findLoop is called with node A
    lazy val result = findLoop(nodeA)

    // then: the result should be node B
    result should be (nodeB)
  }

  "findLoop" should "return node A in list ABCA" in {
    // given: a list ABCA
    lazy val nodeA = ListNode('A', nodeB)
    lazy val nodeB = ListNode('B', nodeC)
    lazy val nodeC = ListNode('C', nodeA)

    // when: findLoop is called with node A
    lazy val result = findLoop(nodeA)

    // then: the result should be node A
    result should be (nodeA)
  }
}
