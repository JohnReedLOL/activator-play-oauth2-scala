name := """play-oauth2-scala"""

version := "1.0-SNAPSHOT"

lazy val root: Project = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

resolvers += "johnreed2 bintray" at "http://dl.bintray.com/content/johnreed2/maven"

libraryDependencies += "com.github.johnreedlol" %% "scala-trace-debug" % "3.0.3"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)


fork in run := true