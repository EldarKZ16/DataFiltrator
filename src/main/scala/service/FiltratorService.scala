package service

import entities.Filter
import serialization.Json4sSerialization
import utils.FileReader
import validation.FilterValidator

abstract class FiltratorService[A](filterValidator: FilterValidator[A]) extends Json4sSerialization {

  def readAndFilterTheData(csvFileName: String, jsonFilterFileName: String): List[A] = {
    val filteredEntities = for {
      csvFileData <- FileReader.readCsvFile(csvFileName)
      entity = extractEntity(csvFileData)
      filters = FileReader.readJsonFile(jsonFilterFileName).flatMap(_.extractOpt[Filter])
      filteredEntity <- filterValidator.applyFiltersOnEntity(entity, filters)
    } yield filteredEntity

    filteredEntities
  }

  def getTopEntitiesByKnownParameter(entities: List[A], limit: Int = 3): List[A]

  protected def extractEntity(csvData: Array[String]): Option[A]

}
