package net.danielbrice.scalakata

object Pathfinding {

  /**
   * VI. Pathfinding
   *
   * Given: two nodes of a strongly-connected directed graph
   * (meaning, for any two nodes A and B, there is gauranteed
   * to be a path from A to B),
   *
   * When: your function is called with said nodes,
   *
   * Then: your function returns one minimal path between the two nodes.
   */

  case class GraphNode(label : Char, neighbors : Unit => List[GraphNode])

  def pathfinding
  : GraphNode => GraphNode => List[GraphNode]
  = start     => end       => {

    type Path = List[GraphNode]

    def step
    // takes a path and extends it in all possible directions
    : Path => List[Path]
    = path => for {
      next <- path.head.neighbors()
    } yield next :: path

    def steps
    // takes a bunch of paths and extends each
    // one in all of its possible directions
    : List[Path] => List[Path]
    = paths      => paths.flatMap(step)

    def done
    // takes a path and checks if it's complete
    : Path => Boolean
    = path => path.head.label == end.label

    // the rest is basically Java, but with slightly nicer syntax
    var pathsSoFar : List[Path] = List(List(start))
    var currPaths : List[Path] = pathsSoFar
    var currPath : Path = List()

    var result : Path = List()

    while (result.isEmpty) {

      while (currPaths.nonEmpty && result.isEmpty) {
        currPath = currPaths.head
        currPaths = currPaths.tail

        if (done(currPath)) result = currPath
      }

      pathsSoFar = steps(pathsSoFar)
      currPaths = pathsSoFar
    }

    result.reverse
  }
}
