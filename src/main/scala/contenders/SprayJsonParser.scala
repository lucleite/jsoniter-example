package contenders

import contenders.MyJsonProtocol.{jsonFormat10, jsonFormat2, jsonFormat3, jsonFormat5, jsonFormat9}
import model.*
import spray.json.*

import java.time.ZonedDateTime

object SprayJsonParser {
  
  import MyJsonProtocol.given

  def parse(jsonString: String) = 
    jsonString
      .parseJson
      .convertTo[List[TrafficSign]]
}

object MyJsonProtocol extends DefaultJsonProtocol {

  given countyFormat: RootJsonFormat[County] = jsonFormat3(County.apply)
  given roadFormat: RootJsonFormat[Road] = jsonFormat5(Road.apply)
  given rdFormat: RootJsonFormat[RD] = jsonFormat2(RD.apply)
  given wgs84Format: RootJsonFormat[WGS84] = jsonFormat2(WGS84.apply)
  given detailsFormat: RootJsonFormat[Details] = jsonFormat3(Details.apply)
  given locationFormat: RootJsonFormat[Location] = jsonFormat9(Location.apply)
  given zonedDateTmeFormat: RootJsonFormat[ZonedDateTime] = new RootJsonFormat[ZonedDateTime] {
    def write(obj: ZonedDateTime): JsValue = JsString(obj.toString)
    def read(json: JsValue): ZonedDateTime = ZonedDateTime.parse(json.convertTo[String])
  }
  given textSignFormat: RootJsonFormat[TextSign] = jsonFormat2(TextSign.apply)
  
  given trafficSignFormat: RootJsonFormat[TrafficSign] = jsonFormat10(TrafficSign.apply)
}