package net.danielbrice.scalakata

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

  case class ListNode(label : Char, next : Unit => ListNode)

  def findLoop
    : ListNode => ListNode
    = start    => {

      def helper
        : List[ListNode] => ListNode => ListNode
        = visited        => current  => {
          if (visited.contains(current)) current
          else {
            val newVisited = current :: visited
            helper(newVisited)(current.next())
          }
        }

      helper(List())(start)
    }
}
