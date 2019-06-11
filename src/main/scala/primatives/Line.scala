package primatives

import com.jogamp.opengl.{GL, GL2, GLAutoDrawable}
import utils.{Colour, Coord}

class Line(start: Coord, end: Coord, colour: Colour) extends  {
  //simpler constructor that defaults colour to white
  def this(start: Coord, end: Coord) ={
    this(start, end, Colour.WHITE)
  }

  def init(drawable: GLAutoDrawable): Unit = {

  }

  def display(gl: GL2): Unit = {
    gl.glBegin(GL.GL_LINES)
    gl.glColor4f(colour.red, colour.green, colour.blue, colour.alpha)
    gl.glVertex2d(start.x, start.y)
    gl.glVertex2d(end.x, end.y)
    gl.glEnd()
  }

  def reshape(drawable: GLAutoDrawable): Unit = {

  }
}
