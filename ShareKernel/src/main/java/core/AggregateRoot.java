package core;

import java.util.List;

public abstract class AggregateRoot extends Entity{

    protected AggregateRoot(List<DomainEvent> domainEvents) {
        super(domainEvents);
    }
}
