organization := "com.packtpub"

name := """alpakka-example"""

version := "0.0.3"

scalaVersion := "2.12.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val scalaTestV = "3.0.5"
  Seq(
    "com.github.pathikrit" %% "better-files" % "3.7.1",
    "com.lightbend.akka" %% "akka-stream-alpakka-csv" % "1.0.0",
    "com.lightbend.akka" %% "akka-stream-alpakka-elasticsearch" % "1.0.0",
    "org.mongodb.scala" %% "mongo-scala-bson" % "2.4.2",
    "com.lightbend.akka" %% "akka-stream-alpakka-mongodb" % "1.0.0",
    "org.scalatest" %% "scalatest" % scalaTestV % "test"
  )
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.jcenterRepo
)
