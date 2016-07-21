package net.danielbrice.scalakata

object Pathfinding {

  /**
   * VI. Pathfinding
   *
   * Given: two nodes of a connected directed graph,
   *
   * When: your function is called with said nodes,
   *
   * Then: your function returns one minimal path between the two nodes.
   */

  class GraphNode(label : Char, neighbors : => List[GraphNode])

  def pathfinding
    : GraphNode => GraphNode => List[GraphNode]
    = start     => end       => ???
}
