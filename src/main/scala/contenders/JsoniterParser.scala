package contenders

import com.github.plokhotnyuk.jsoniter_scala.core.*
import com.github.plokhotnyuk.jsoniter_scala.macros.*
import model.TrafficSign

object JsoniterParser {

  given codec: JsonValueCodec[Seq[TrafficSign]] = JsonCodecMaker.make
  
  def parse(jsonString: String) = readFromString(jsonString)
}