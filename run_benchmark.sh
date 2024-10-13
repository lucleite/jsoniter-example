#!/bin/bash

IMAGE_NAME="json-benchmark"
FORCE_REBUILD=false

# Parse command line arguments
for arg in "$@"
do
  case $arg in
    --force-rebuild)
    FORCE_REBUILD=true
    shift
    ;;
  esac
done

# Check if the Docker image already exists
if [[ "$FORCE_REBUILD" == true || "$(docker images -q $IMAGE_NAME 2> /dev/null)" == "" ]]; then
  echo "Building the Docker image..."
  docker build -t $IMAGE_NAME .
else
  echo "Image already exists. Skipping build."
fi

# Run the Docker container with resource limits
docker run --rm \
  --cpus="1" \
  --memory="4g" \
  --memory-swap="4g" \
  $IMAGE_NAME

