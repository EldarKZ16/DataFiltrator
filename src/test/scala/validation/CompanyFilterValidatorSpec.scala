package validation

import entities.{Company, IsProfitableFilter, NameContainsFilter}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CompanyFilterValidatorSpec
  extends AnyFlatSpec
    with Matchers {

  behavior of "CompanyFilterValidator"

  val validator = new CompanyFilterValidator

  it should "apply filters and return existing company" in {
    val company = Some(Company("Test test", 100000, isProfitable = true))
    val filters = List(NameContainsFilter("test"), IsProfitableFilter())

    val result = validator.applyFiltersOnEntity(company, filters)
    result shouldBe company
  }

  it should "apply filter and return None" in {
    val company = Some(Company("Test test", 100000, isProfitable = false))
    val filters = List(NameContainsFilter("test"), IsProfitableFilter())

    val result = validator.applyFiltersOnEntity(company, filters)
    result shouldBe empty
  }

}
