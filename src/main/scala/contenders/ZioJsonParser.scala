package contenders

import model.*
import zio.json.*

import java.time.ZonedDateTime

object ZioJsonParser {

  given countyDecoder: JsonDecoder[County] = DeriveJsonDecoder.gen[County]
  given roadDecoder: JsonDecoder[Road] = DeriveJsonDecoder.gen[Road]
  given rdDecoder: JsonDecoder[RD] = DeriveJsonDecoder.gen[RD]
  given wgs84Decoder: JsonDecoder[WGS84] = DeriveJsonDecoder.gen[WGS84]
  given detailsDecoder: JsonDecoder[Details] = DeriveJsonDecoder.gen[Details]
  given locationDecoder: JsonDecoder[Location] = DeriveJsonDecoder.gen[Location]
  given textSignDecoder: JsonDecoder[TextSign] = DeriveJsonDecoder.gen[TextSign]
  given trafficSignDecoder: JsonDecoder[TrafficSign] = DeriveJsonDecoder.gen[TrafficSign]
  
  def parse(jsonString: String) = jsonString.fromJson[List[TrafficSign]]
}