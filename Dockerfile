FROM sbtscala/scala-sbt:eclipse-temurin-alpine-22_36_1.10.2_3.5.1

# Copy the build files and source code
COPY . .

# Build the project using sbt
RUN sbt compile

# Run the benchmarks
CMD ["sbt", "run"]

