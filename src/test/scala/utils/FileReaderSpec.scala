package utils

import org.json4s.{JObject, JString}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FileReaderSpec
  extends AnyFlatSpec
    with Matchers {

  import FileReader._

  behavior of "FileReader"

  it should "read the human csv file" in {
    val csvFileName = "test-human.csv"
    val result = readCsvFile(csvFileName)

    val expectedResult = List(Array("Eldar", "Albossyn", "3000"), Array("Darrick", "Patton", "2000"))
    result should contain theSameElementsInOrderAs expectedResult
  }

  it should "read the empty csv file" in {
    val csvFileName = "test-empty.csv"
    val result = readCsvFile(csvFileName)

    result shouldBe empty
  }

  it should "read the non-empty json file" in {
    val jsonFileName = "test-json-file.json"
    val result = readJsonFile(jsonFileName)

    val expectedResult = List(JObject("filterType" -> JString("IsProfitable")))
    result should contain theSameElementsInOrderAs expectedResult
  }

  it should "read the empty json file" in {
    val jsonFileName = "test-empty.json"
    val result = readJsonFile(jsonFileName)

    result shouldBe empty
  }

}
