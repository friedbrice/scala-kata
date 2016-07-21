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

      var visited : List[ListNode] = List()

      def helper
        : ListNode => ListNode
        = current  => {
          if (visited.contains(current)) current
          else {
            visited = current :: visited
            helper(current.next())
          }
        }

      helper(start)
    }
}
