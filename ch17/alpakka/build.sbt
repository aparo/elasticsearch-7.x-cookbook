organization := "com.packtpub"

name := """alpakka-example"""

version := "0.0.4"

scalaVersion := "2.12.10"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val scalaTestV = "3.0.8"
  Seq(
    "com.github.pathikrit" %% "better-files" % "3.8.0",
    "com.lightbend.akka" %% "akka-stream-alpakka-csv" % "1.1.1",
    "com.lightbend.akka" %% "akka-stream-alpakka-elasticsearch" % "1.1.1",
    "org.mongodb.scala" %% "mongo-scala-bson" % "2.7.0",
    "com.lightbend.akka" %% "akka-stream-alpakka-mongodb" % "1.1.1",
    "org.scalatest" %% "scalatest" % scalaTestV % "test"
  )
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.jcenterRepo
)
