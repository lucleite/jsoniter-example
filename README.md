# Jsoniter example and JSON parsing Benchmark

This repository contains a Dockerized application designed to benchmark JSON parsing performance of the following
libraries:

- Jsoniter
- Circe
- Spray
- Zio-Json

The same JSON is parsed 10 times with each library and the average time is calculated. The first run is discarded to
avoid any warm-up effects.

## Prerequisites

- [Docker](https://www.docker.com/get-started) must be installed on your machine.

## Running the application

Use the provided [shell script](run_benchmark.sh) to run the application.
The script will build the Docker image and run the benchmark with designated resources.

```bash
chmod +x ./run_benchmark.sh
./run_benchmark.sh
```

The  --force-rebuild flag can be used to force a rebuild of the Docker image.

```bash
./run_benchmark.sh --force-rebuild
```

