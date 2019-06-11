package primatives

import com.jogamp.opengl.{GL, GL2, GLAutoDrawable}
import utils.{Colour, Coord}

class Circle(position: Coord, radius: Float, points: Int, colour: Colour) {
  def this(position: Coord) = {
    this(position, 0.5f, 60, Colour.WHITE)
  }

  def this(position: Coord, radius: Float) = {
    this(position, radius, 60, Colour.WHITE)
  }

  def init(drawable: GLAutoDrawable): Unit = {

  }

  def display(gl: GL2): Unit = {
    gl.glBegin(GL.GL_LINE_LOOP)
    for(i <- 0 until points) {
      val theta = 2 * Math.PI * i / points
      val xCoord = position.x + radius * Math.cos(theta)
      val yCoord = position.y + radius * Math.sin(theta)
      gl.glVertex2d(xCoord, yCoord)
    }
    gl.glEnd()
  }

  def reshape(drawable: GLAutoDrawable): Unit = {

  }
}
