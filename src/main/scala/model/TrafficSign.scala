package model

import java.time.ZonedDateTime

case class Location(
                     wgs84: WGS84,
                     rd: RD,
                     placement: String,
                     side: String,
                     bearing: Int,
                     fraction: Option[Double],
                     driving_direction: Option[String],
                     road: Road,
                     county: County
                   )

case class WGS84(
                  latitude: String,
                  longitude: String
                )

case class RD(
               x: String,
               y: String
             )

case class Road(
                 name: String,
                 wvk_id: Option[String],
                 nwb_version: Option[String],
                 `type`: Option[String] = None,
                 number: Option[String] = None
               )

case class County(
                   name: String,
                   code: String,
                   townname: String
                 )

case class Details(
                    image: String,
                    first_seen: String,
                    last_seen: String
                  )

case class TextSign(
                     `type`: String,
                     text: String
                   )

case class TrafficSign(
                        id: Long,
                        ndw_id: String,
                        `type`: String,
                        schema_version: String,
                        validated: String,
                        rvv_code: String,
                        text_signs: List[TextSign],
                        location: Location,
                        details: Details,
                        publication_timestamp: ZonedDateTime
                      )