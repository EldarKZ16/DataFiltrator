package service

import entities.Company
import validation.FilterValidator

import scala.util.Try

class CompanyFiltratorService(filterValidator: FilterValidator[Company]) extends FiltratorService[Company](filterValidator) {

  override protected def extractEntity(csvData: Array[String]): Option[Company] = {
    Try(Company(csvData(0), csvData(1).toInt, csvData(2).toBoolean)).toOption
  }

  override def getTopEntitiesByKnownParameter(entities: List[Company], limit: Int): List[Company] = {
    entities.sortBy(_.revenue)(Ordering[Int].reverse).take(limit)
  }
}
