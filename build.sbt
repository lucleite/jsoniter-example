val scala3Version = "3.5.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "jsoniter-example",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      // jsoniter
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % "2.30.15",
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.30.15" % "provided",

      // circe
      "io.circe" %% "circe-core"    % "0.14.9",
      "io.circe" %% "circe-generic" % "0.14.9",
      "io.circe" %% "circe-parser"  % "0.14.9",

      // spray
      "io.spray" %%  "spray-json" % "1.3.6",

      // zio
      "dev.zio" %% "zio-json" % "0.6.2"
    )
  )
