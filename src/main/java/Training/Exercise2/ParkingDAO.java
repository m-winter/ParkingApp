package Training.Exercise2;

import java.util.List;
import java.util.Optional;

public interface ParkingDAO {

    void crateParking();
    void deleteParking();

    void createEmptySpot(final ParkingSpot parkingSpot);//insertobject
    void deleteSpot(int id);

    void changeSpotStatus(int id, boolean isTrue);


    void changeSpotType(int id, boolean isTrue);

    Optional<ParkingSpot> findById(int id);

    List<ParkingSpot> findAll();

}
