import Pathfinding._
import org.scalatest.FlatSpec

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

object PathfindingTests extends FlatSpec {

  "pathfinding" should "return start when start == end" in {
    // given: a graph node A
    lazy val nodeA = GraphNode('A', List())

    // when: pathfinding is called with node A and node A
    lazy val result = pathfinding(nodeA)(nodeA)

    // then: the result should be List(A)
    result should be (List(nodeA))
  }

  "pathfinding" should "find a minimal path" in {
    // given: a graph A->B->A
    lazy val nodeA = GraphNode('A', List(nodeB))
    lazy val nodeB = GraphNode('A', List(nodeA))

    // when: pathfinding is called with node A and node A
    lazy val result = pathfinding(nodeA)(nodeA)

    // then: the result should be List(A)
    result should be (List(nodeA))
  }
}
