import scala.util.Try

object JsonParsingBenchmark {

  // A helper function to measure time taken by a block of code
  def time[R](block: => R): (R, Long) =
    val start = System.nanoTime()
    val result = Try(block)
    val end = System.nanoTime()
    val timeTaken = end - start
    result.get -> timeTaken

  // Function to run a benchmark for each library multiple times and discard the first result
  def benchmark[R](name: String, block: => R, runs: Int = 10): Unit =
    val times = (1 to runs).map { run =>
      val (_, timeTaken) = time(block)
      println(s"Run #$run for $name took ${timeTaken / 1e6} ms") // Log each run
      timeTaken
    }

    // Discard the first run to avoid cold start effects and calculate the average of the remaining runs
    val averageTime = times.tail.sum / (runs - 1).toDouble
    println(s"\nAverage time for $name (excluding first run): ${averageTime / 1e6} ms\n")
}
