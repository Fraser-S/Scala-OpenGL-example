package primatives

import com.jogamp.opengl.{GL, GL2, GLAutoDrawable}

import utils.{Colour, Coord}

class LineLoop(coords: Seq[Coord], colour: Colour) {
  //simpler constructor that defaults colour to white
  def this(coords: Seq[Coord]) ={
    this(coords, Colour.WHITE)
  }

  def init(drawable: GLAutoDrawable): Unit = {

  }

  def display(gl: GL2): Unit = {
    gl.glBegin(GL.GL_LINE_LOOP)
    gl.glColor4f(colour.red, colour.green, colour.blue, colour.alpha)
    for(coord <- coords) {
      gl.glVertex2d(coord.x, coord.y)
    }
    gl.glEnd()
  }

  def reshape(drawable: GLAutoDrawable): Unit = {

  }
}
