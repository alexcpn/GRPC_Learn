name := "test_grpc"

version := "1.0"

scalaVersion := "2.12.1"

updateOptions := updateOptions.value.withCachedResolution(true)

mainClass in assembly := some("GRpcApp")
assemblyJarName := "test_grpc.jar"

// If you need to specify main classes manually, use packSettings and packMain
packSettings

// [Optional] Creating `hello` command that calls org.mydomain.Hello#main(Array[String])
packMain := Map("service_server" -> "server.BootUp","service_client" -> "client.ClientBoot")

val grpcVersion = "1.0.3"

libraryDependencies ++= Seq(

  //for scala logging
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  //"ch.qos.logback" % "logback-classic" % "1.1.7",
  // for scala tests
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test" exclude("junit", "junit-dep"), //  this is needed to run Junit style test
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  //for protocol buffer
  "com.google.protobuf" % "protobuf-java" % "3.1.0",
  //for gRPC
  "io.grpc" % "grpc-netty" % grpcVersion,
  "io.grpc" % "grpc-protobuf" % grpcVersion,
  "io.grpc" % "grpc-stub" % grpcVersion

)


resolvers ++= Seq(
  "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype repo" at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging" at "http://oss.sonatype.org/content/repositories/staging",
  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
  "Twitter Repository" at "http://maven.twttr.com",
  Resolver.bintrayRepo("websudos", "oss-releases")
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}