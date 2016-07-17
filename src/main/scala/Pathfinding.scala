object Pathfinding {

  /**
   * VI. Pathfinding
   *
   * Given: a connected directed graph,
   *
   * When: your function is called with said graph and two nodes,
   *
   * Then: your function returns one minimal path between the two nodes.
   */

  case class GraphNode(label : Char, neighbors : List[GraphNode])

  def pathfinding
    : GraphNode => GraphNode => List[GraphNode]
    = start     => end       => ???
}
