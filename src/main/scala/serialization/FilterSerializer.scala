package serialization

import entities.{Filter, IsProfitableFilter, NameContainsFilter}
import org.json4s.JsonAST.{JObject, JValue}
import org.json4s._

object FilterSerializer extends CustomSerializer[Filter](implicit formats => (
  {
    case json: JValue =>
      val resultOpt = json \ "filterType" match {
        case JString("NameContains") => json.extractOpt[NameContainsFilter]
        case JString("IsProfitable") => json.extractOpt[IsProfitableFilter]
      }

      resultOpt.getOrElse(
        throw new MatchError(s"Unknown filter type: \n $json")
      )
    case any =>
      throw new MatchError(s"Unknown filter type: \n $any")
  },
  {
    case filter: Filter => filter match {
      case obj: NameContainsFilter =>
        JObject(
          "filterType" -> Extraction.decompose(obj.filterType),
          "text" -> Extraction.decompose(obj.text)
        )
      case obj: IsProfitableFilter =>
        JObject(
          "filterType" -> Extraction.decompose(obj.filterType)
        )
    }
  }
))