name := "sbt-example"
organization := "org.scalamacros"
version := "2.0.0"

resolvers ++= Seq("Nexus" at "http://192.168.33.20:8081/repository/maven-public/")
scalaVersion in ThisBuild := "2.11.8"
run <<= run in Compile in core

lazy val macros = (project in file("macros")).settings(
 libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")) dependsOn macros
