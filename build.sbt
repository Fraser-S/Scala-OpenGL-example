name := "scala-opengl-example"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= {
  Seq(
    "org.jogamp.jogl" % "jogl-all-main" % "2.3.2",
    "org.jogamp.gluegen" % "gluegen-rt-main" % "2.3.2"
  )
}
