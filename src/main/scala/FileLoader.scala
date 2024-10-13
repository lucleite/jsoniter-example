import java.io.FileInputStream
import java.util.zip.GZIPInputStream
import scala.io.Source
import scala.util.{Try, Using}

object FileLoader {
  def loadGzippedFileToString(path: String): Try[String] = {
    Using.Manager { use =>
      val gzInputStream = use(new GZIPInputStream(new FileInputStream(path)))
      val source = use(Source.fromInputStream(gzInputStream, "UTF-8"))
      source.getLines().mkString("\n")
    }
  }
}
