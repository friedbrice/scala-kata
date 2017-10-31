package net.danielbrice.scalakata

import net.danielbrice.scalakata.Pathfinding._
import org.scalatest.{FlatSpec, Matchers}

class PathfindingTest extends FlatSpec with Matchers {

  "pathfinding" should "return start when start == end" in {
    // given: a graph node A
    lazy val nodeA : GraphNode = GraphNode('A', _ => List())

    // when: pathfinding is called with node A and node A
    lazy val result = pathfinding(nodeA)(nodeA)

    // then: the result should be List(A)
    result should be (List(nodeA))
  }

  "pathfinding" should "find a minimal path" in {
    // given: a graph A->B->A
    lazy val nodeA : GraphNode = GraphNode('A', _ => List(nodeB))
    lazy val nodeB : GraphNode = GraphNode('B', _ => List(nodeA))

    // when: pathfinding is called with node A and node A
    lazy val result = pathfinding(nodeA)(nodeA)

    // then: the result should be List(A)
    result should be (List(nodeA))
  }

  "pathfinding" should "work" in {
    // given: this graph
    lazy val node1 : GraphNode = GraphNode('1', _ => List(node2, node5))
    lazy val node2 : GraphNode = GraphNode('2', _ => List(node1, node3, node5))
    lazy val node3 : GraphNode = GraphNode('3', _ => List(node2, node4))
    lazy val node4 : GraphNode = GraphNode('4', _ => List(node3, node5, node6))
    lazy val node5 : GraphNode = GraphNode('5', _ => List(node1, node2, node4))
    lazy val node6 : GraphNode = GraphNode('6', _ => List(node4))

    // when: pathfinding is called with node1 and node6
    lazy val result = pathfinding(node1)(node6)

    // then: the result should be
    result.head should be (node1)
    result.last should be (node6)
    result.length should be (4)
  }
}
