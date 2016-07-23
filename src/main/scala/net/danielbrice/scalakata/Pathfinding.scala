package net.danielbrice.scalakata

object Pathfinding {

  /**
   * VI. Pathfinding
   *
   * Given: two nodes of a strongly-connected directed graph,
   * (http://mathworld.wolfram.com/ConnectedDigraph.html)
   *
   * When: your function is called with said nodes,
   *
   * Then: your function returns one minimal path between the two nodes.
   */

  case class GraphNode(label : Char, neighbors : Unit => List[GraphNode])

  def pathfinding
    : GraphNode => GraphNode => List[GraphNode]
    = start     => end       => {

      def helper
        : List[List[GraphNode]] => List[GraphNode] => List[GraphNode]
        = paths                 => neighbors       => {
          ???
        }

      helper(List())(start.neighbors())
    }
}
