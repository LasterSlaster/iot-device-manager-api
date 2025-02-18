package de.bbqb.backend.gcp.firestore;

import com.google.cloud.firestore.Firestore;
import de.bbqb.backend.api.model.entity.Address;
import de.bbqb.backend.api.model.entity.Device;
import de.bbqb.backend.api.model.entity.Location;
import de.bbqb.backend.gcp.firestore.DeviceRepo;
import de.bbqb.backend.gcp.firestore.FirestoreDeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author Marius Degen
 */
@Disabled
public class FirestoreDeviceServiceTest {

    private final String id = "id";
    private final String deviceId = "deviceId";
    private final String name = "name";
    private final String number = "123";
    private final Long publishTime = new Date().getTime();
    private final Boolean lockStatus = true;
    private final Boolean drawerStatus = true;
    private final Double wifiSignal = 89.0;
    private final Double setTemperature1 = 30.0;
    private final Double setTemperature2 = 30.0;
    private final Double isTemperature1 = 30.0;
    private final Double isTemperature2 = 30.0;
    private final Address address = new Address("Deutschland", "78467", "Konstanz", "Straße", "2", "Adressname");
    private final Location location = new Location(1.1, 1.2);
    private FirestoreDeviceService sut;
    @Mock
    private DeviceRepo deviceRepoMock;
    @Mock
    private Firestore firestoreMock;

    @BeforeEach
    public void setUp() {
        this.sut = new FirestoreDeviceService(deviceRepoMock, firestoreMock);
    }

    @Test
    public void testCreateDevice() {
        // given
        //Device device = new Device(id, deviceId, number,  publishTime, lockStatus, drawerStatus, wifiSignal, isTemperature1, isTemperature2, setTemperature1, setTemperature2, location, address);

        // when
        //Mono<Device> savedDevice = this.sut.createDevice(device);

        // then
        //Device actualSavedDevice = savedDevice.block();
        //actualSavedDevice.equals(device);
    }

    @Test
    public void testUpdateDevice() {
        // given
        //Device device = new Device(id, deviceId, number,  publishTime, lockStatus, drawerStatus, wifiSignal, isTemperature1, isTemperature2, setTemperature1, setTemperature2, location, address);

        // when
        //Mono<Device> updatedDevice = this.sut.updateDevice(device);

        // then
        //Device actualUpdatedDevice = updatedDevice.block();
        //actualUpdatedDevice.equals(device);
    }

    //@Test
    public void testReadDevice() {
        // given
        String deviceId = "Butler-2";

        // when
        Mono<Device> readDevice = this.sut.readDevice(deviceId);

        // then
        Device actualReadDevice = readDevice.block();
    }

    @Test
    public void testReadAllDevice() {
        // given

        // when
        Flux<Device> allDevices = this.sut.readAllDevices();

        // then
    }

    @Test
    public void testOpenDevice() {
        // given

        // when
        this.sut.openDevice(deviceId ,20);

        // then
    }

    @Test
    public void testLockDevice() {
        // given
        //Device device = new Device(id, deviceId, number,  publishTime, lockStatus, drawerStatus, wifiSignal, isTemperature1, isTemperature2, setTemperature1, setTemperature2, location, address);

        // when
        //this.sut.lockDevice(device);

        // then
    }
}
