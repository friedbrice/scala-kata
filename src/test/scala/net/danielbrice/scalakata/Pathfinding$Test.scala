package net.danielbrice.scalakata

import net.danielbrice.scalakata.Pathfinding._
import org.scalatest.{FlatSpec, Matchers}

class Pathfinding$Test extends FlatSpec with Matchers {

  "pathfinding" should "return start when start == end" in {
    // given: a graph node A
    lazy val nodeA : GraphNode = new GraphNode('A', _ => List())

    // when: pathfinding is called with node A and node A
    lazy val result = pathfinding(nodeA)(nodeA)

    // then: the result should be List(A)
    result should be (List(nodeA))
  }

  "pathfinding" should "find a minimal path" in {
    // given: a graph A->B->A
    lazy val nodeA : GraphNode = new GraphNode('A', _ => List(nodeB))
    lazy val nodeB : GraphNode = new GraphNode('A', _ => List(nodeA))

    // when: pathfinding is called with node A and node A
    lazy val result = pathfinding(nodeA)(nodeA)

    // then: the result should be List(A)
    result should be (List(nodeA))
  }
}
