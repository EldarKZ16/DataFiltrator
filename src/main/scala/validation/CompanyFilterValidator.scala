package validation

import entities.{Company, Filter, IsProfitableFilter, NameContainsFilter}

class CompanyFilterValidator extends FilterValidator[Company] {

  override protected def validate(entity: Company, filter: Filter): Boolean = {
    filter match {
      case NameContainsFilter(text) =>
        entity.companyName.contains(text)
      case IsProfitableFilter() =>
        entity.isProfitable
      case _ =>
        true
    }
  }

}
