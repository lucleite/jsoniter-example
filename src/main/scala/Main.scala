import JsonParsingBenchmark.benchmark
import contenders.{CirceParser, JsoniterParser, SprayJsonParser, ZioJsonParser}

@main def runBenchmarks(): Unit =

  FileLoader
    .loadGzippedFileToString("src/main/resources/sample_verkeersborden_actueel_beeld.json.gz")
    .foreach {
      jsonString =>
        println(s"Loaded JSON string of length: ${jsonString.length}")
        // Benchmark each library by running it N times and discarding the first run
        benchmark("Jsoniter", JsoniterParser.parse(jsonString), 5)
        benchmark("Circe", CirceParser.parse(jsonString), 5)
        benchmark("Spray", SprayJsonParser.parse(jsonString), 5)
        benchmark("Zio-Json", ZioJsonParser.parse(jsonString), 5)
    }
