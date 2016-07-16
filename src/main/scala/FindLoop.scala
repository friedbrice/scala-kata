import FindLoop._
import org.scalatest.FlatSpec

object FindLoop {

  /**
    * IV. FindLoop
    *
    * Given: a linked list of characters that is known to loop back on itself at
    * some entry,
    *
    * When: your function is called on said list,
    *
    * Then: your function returns the node at which the list rejoins itself.
    */

  case class ListNode(value : Char, next : ListNode)

  def findLoop
  : ListNode => ListNode
  = start    => ???
}

object FindLoopTests extends FlatSpec {

  "findLoop" should "return the first node in a two-node cycle" in {
    // given: a two-node cycle
    lazy val node1 = ListNode('A', node2)
    lazy val node2 = ListNode('B', node1)
  }
}
