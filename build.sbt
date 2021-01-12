import com.twilio.guardrail.sbt.CodingConfig.Optional

name := "guardrail-test"

version := "0.1"

scalaVersion := "2.13.4"

val http4sVersion = "0.21.7"
val circeVersion = "0.13.0"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-effect" % "2.2.0",
  "org.http4s" %% "http4s-core" % http4sVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  "org.http4s" %% "http4s-testing" % http4sVersion,
  "org.http4s" %% "http4s-client" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-literal" % circeVersion,
)

guardrailTasks in Compile := List(
  ScalaClient(
    file("spec.yml"),
    pkg = "com.some",
    framework = "http4s",
    encodeOptionalAs = Optional
  )
)
