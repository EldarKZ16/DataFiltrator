import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.LazyLogging
import service.CompanyFiltratorService
import validation.CompanyFilterValidator

object Boot extends App with LazyLogging {

  logger.info("Started the DataFiltrator")
  val config: Config = ConfigFactory.load()

  val csvFileName = config.getString("app.csv-file-name")
  val filterFileName = config.getString("app.filter-file-name")

  val filterValidator = new CompanyFilterValidator
  val filtratorService = new CompanyFiltratorService(filterValidator)

  val filtratedEntities = filtratorService.readAndFilterTheData(csvFileName, filterFileName)

  val result = filtratorService.getTopEntitiesByKnownParameter(filtratedEntities)
  logger.info(s"Filtration result: ${result.toString}")
}
