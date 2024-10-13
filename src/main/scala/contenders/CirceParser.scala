package contenders

import io.circe.*
import io.circe.generic.semiauto.*
import io.circe.parser.*
import model.*

object CirceParser {

  given countyDecoder: Decoder[County] = deriveDecoder
  given roadDecoder: Decoder[Road] = deriveDecoder
  given rdDecoder: Decoder[RD] = deriveDecoder
  given wgs84Decoder: Decoder[WGS84] = deriveDecoder
  given detailsDecoder: Decoder[Details] = deriveDecoder
  given locationDecoder: Decoder[Location] = deriveDecoder
  given textSignDecoder: Decoder[TextSign] = deriveDecoder
  given trafficSignDecoder: Decoder[TrafficSign] = deriveDecoder
  
  def parse(jsonString: String) = decode[List[TrafficSign]](jsonString)
}