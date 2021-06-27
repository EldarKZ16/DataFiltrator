package utils

import org.json4s.JsonAST.{JArray, JValue}

import scala.io.Source
import org.json4s.jackson.JsonMethods._
import serialization.Json4sSerialization

object FileReader extends Json4sSerialization {

  def readCsvFile(fileName: String): List[Array[String]] = {
    val bufferedSource = Source.fromResource(fileName)
    val listOfValues = for {
      line <- bufferedSource.getLines().drop(1).toList
      values = line.split(",").map(_.trim)
    } yield values

    bufferedSource.close()
    listOfValues
  }

  def readJsonFile(fileName: String): List[JValue] = {
    val bufferedSource = Source.fromResource(fileName)

    val jsonString = bufferedSource.mkString
    val json = parse(jsonString).extract[JArray]

    bufferedSource.close()
    json.arr
  }

}
