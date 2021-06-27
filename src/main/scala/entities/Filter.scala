package entities

sealed trait Filter {
  def filterType: String
}

case class NameContainsFilter(text: String) extends Filter {
  override val filterType: String = "NameContains"
}

case class IsProfitableFilter() extends Filter {
  override val filterType: String = "IsProfitable"
}
