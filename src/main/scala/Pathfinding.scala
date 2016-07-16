object Pathfinding {

  /**
   * VI. Pathfinding
   *
   * Given: a connected graph,
   *
   * When: your function is called with said graph and two nodes,
   *
   * Then: your function returns one minimal path between the two nodes.
   */

  type GraphNode = (Char, List[GraphNode])
  type Graph = List[GraphNode]

  def pathfinding
    : Graph => GraphNode => GraphNode => List[GraphNode]
    = g     => start     => end       => ???
}

object PathfindingTests {

}
