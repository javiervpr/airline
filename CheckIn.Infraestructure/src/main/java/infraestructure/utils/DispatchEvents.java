package infraestructure.utils;

import core.Entity;

public class DispatchEvents {

  public void dispatchEvent(Entity entity) {
    entity.domainEvents.stream().forEach(domain -> {});
  }
}
