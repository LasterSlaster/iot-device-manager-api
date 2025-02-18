package de.bbqb.backend.gcp.firestore;

import de.bbqb.backend.gcp.firestore.document.DeviceDoc;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Read/Write device information from/to a gcp firestore NoSql database An
 * instance of this interface is provided by spring and injected into the
 * context at runtime
 *
 * @author Marius Degen
 */
@Repository
public interface DeviceRepo extends FirestoreReactiveRepository<DeviceDoc> {
    Mono<DeviceDoc> findFirstByDeviceId(String id);
}
