package listeners;

import core.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.event.TransactionPhase.BEFORE_COMMIT;

@Component
public class DomainEventListener {

    Logger logger = LoggerFactory.getLogger(DomainEventListener.class);

    @TransactionalEventListener(phase = BEFORE_COMMIT)
    public void archiveBook(DomainEvent domainEvent) {
        logger.info("Si vino hasta aca " + domainEvent.toString());
    }
}
