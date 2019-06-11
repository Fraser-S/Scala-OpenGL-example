import java.awt.event.{KeyEvent, KeyListener}

import com.jogamp.opengl.awt.GLCanvas
import com.jogamp.opengl.util.FPSAnimator
import com.jogamp.opengl._
import javax.swing.{JFrame, WindowConstants}
import primatives.{Circle, _}
import utils.{Colour, Coord}

class Example(windowName: String) extends JFrame with GLEventListener with KeyListener {

  //Class Data
  protected val windowWidth: Int = 600
  protected val windowHeight: Int = 600
  protected val clearColor: Colour = Colour.BLACK

  protected var objToRender: String = "line"
  protected val line: Line = new Line(Coord(-0.60, 0.10), Coord(0.60, 0.10))
  protected val lineLoop = new LineLoop(Seq(Coord(-0.5, -0.5),Coord(0.5, -0.5), Coord(0.5, 0.5), Coord(-0.5, 0.5)))
  protected val lineStrip = new LineStrip(Seq(Coord(-0.5, -0.5),Coord(0.5, -0.5), Coord(0.5, 0.5), Coord(-0.5, 0.5)))
  protected val polygon = new Polygon(Seq(Coord(-0.5, -0.5),Coord(0.5, -0.5), Coord(0.5, 0.5), Coord(-0.5, 0.5)))
  protected val triangle = new Triangle(Seq(Coord(-0.5, -0.5), Coord(0.5, -0.5), Coord(0.0, 0.5)), Seq(Colour.RED, Colour.GREEN, Colour.BLUE))
  protected val circle = new Circle(Coord(0.0, 0.0), radius = 0.5f)

  //OpenGl Setup
  private val profiles: Array[String] = Array(GLProfile.GL2)
  private val profile = GLProfile.get(profiles, true)
  private val capabilities = new GLCapabilities(profile)
  private val animator: FPSAnimator = new FPSAnimator(5)
  private val canvas: GLCanvas = new GLCanvas(capabilities)
  canvas.addGLEventListener(this)
  canvas.addKeyListener(this)
  animator.add(canvas)

  //JFrame Setup
  this.setTitle(windowName)
  this.setName(windowName)
  this.getContentPane.add(canvas)
  this.setSize(windowWidth, windowHeight)
  this.setLocationRelativeTo(null)
  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  this.setVisible(true)
  this.setResizable(false)
  canvas.requestFocusInWindow()

  //default constructor
  def this() = {
    this("OpenGL Scala Demo")
  }

  def play(): Unit = {
    animator.start()
  }

  def render(drawable: GLAutoDrawable): Unit = {
    val gl: GL2 = drawable.getGL.getGL2
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT)
    objToRender match {
      case "line" => line.display(gl)
      case "lineStrip" => lineStrip.display(gl)
      case "lineLoop" => lineLoop.display(gl)
      case "polygon" => polygon.display(gl)
      case "triangle" => triangle.display(gl)
      case "circle" => circle.display(gl)
    }
    gl.glFlush()
  }

  override def display(drawable: GLAutoDrawable): Unit = {
    render(drawable)
  }

  override def dispose(drawable: GLAutoDrawable): Unit = {
    animator.stop()
  }

  override def init(drawable: GLAutoDrawable): Unit = {
    val gl: GL2 = drawable.getGL.getGL2
    gl.glClearColor(clearColor.red, clearColor.green, clearColor.blue, clearColor.alpha)
  }

  override def reshape(drawable: GLAutoDrawable, x: Int, y: Int, width: Int, height: Int): Unit = {

  }

  override def keyTyped(keyEvent: KeyEvent): Unit = {

  }

  override def keyPressed(keyEvent: KeyEvent): Unit = {
    keyEvent.getKeyCode match {
      case KeyEvent.VK_1 => objToRender = "line"
      case KeyEvent.VK_2 => objToRender = "lineStrip"
      case KeyEvent.VK_3 => objToRender = "lineLoop"
      case KeyEvent.VK_4 => objToRender = "polygon"
      case KeyEvent.VK_5 => objToRender = "triangle"
      case KeyEvent.VK_6 => objToRender = "circle"
      case _ => ()
    }
  }

  override def keyReleased(keyEvent: KeyEvent): Unit = {

  }
}

//main entry point
object Example {

  def main(args: Array[String]): Unit = {
    val example = new Example()
    example.play()
  }
}
