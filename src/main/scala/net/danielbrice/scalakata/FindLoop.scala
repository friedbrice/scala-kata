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

  // TODO: This data struct will cause an infinite loop.
  // TODO: Fix before giving this kata to anyone.
  case class ListNode(label : Char, next : ListNode)

  def findLoop
    : ListNode => ListNode
    = start    => ???
}
