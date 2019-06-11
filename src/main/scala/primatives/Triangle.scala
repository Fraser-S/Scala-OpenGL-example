package primatives

import com.jogamp.opengl.{GL, GL2, GLAutoDrawable}
import utils.{Colour, Coord}

class Triangle(coords: Seq[Coord], colours: Seq[Colour]) {
  //simpler constructor that defaults colour to white
  def this(coords: Seq[Coord]) ={
    this(coords, Seq(Colour.WHITE))
  }

  def init(drawable: GLAutoDrawable): Unit = {

  }

  def display(gl: GL2): Unit = {
    gl.glBegin(GL.GL_TRIANGLES)
    colours.length match {
      case size if size == coords.size => displayMultipleColours(gl)
      case 1 => displayOneColour(gl, colours.head)
      case 0 => displayOneColour(gl, Colour.WHITE)
    }
    gl.glEnd()
  }

  def reshape(drawable: GLAutoDrawable): Unit = {

  }

  private def displayOneColour(gl: GL2, colour: Colour): Unit = {
    gl.glColor4f(colour.red, colour.green, colour.blue, colour.alpha)
    for(coord <- coords) {
      gl.glVertex2d(coord.x, coord.y)
    }
  }

  private def displayMultipleColours(gl: GL2): Unit = {
    for(index <- coords.indices) {
      gl.glColor4f(colours(index).red, colours(index).green, colours(index).blue, colours(index).alpha)
      gl.glVertex2d(coords(index).x, coords(index).y)
    }
  }
}
