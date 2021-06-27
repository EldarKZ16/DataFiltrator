package validation

import entities.Filter

trait FilterValidator[A] {

  protected def validate(entity: A, filter: Filter): Boolean

  def applyFiltersOnEntity(entity: Option[A], filters: List[Filter]): Option[A] = {
    entity.find(ent => filters.map(filter => validate(ent, filter)).forall(identity))
  }

}
