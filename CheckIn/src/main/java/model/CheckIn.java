package model;

import core.AggregateRoot;
import core.DomainEvent;

import java.util.List;
import java.util.UUID;

public class CheckIn extends AggregateRoot {

    protected CheckIn(List<DomainEvent> domainEvents) {
        super(domainEvents);
        id = UUID.randomUUID();
    }
}
