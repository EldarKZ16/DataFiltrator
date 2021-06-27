package serialization

import org.json4s.{DefaultFormats, Formats, Serialization, jackson}

trait Json4sSerialization {
  implicit val formats: Formats = new DefaultFormats {} + FilterSerializer
  implicit val serialization: Serialization = jackson.Serialization
}