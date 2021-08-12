package Training.Exercise2;

public class ParkingSpot {
    public int id;
    public boolean isFree;
    public boolean isNormal;

    public ParkingSpot(boolean isFree, boolean isNormal) {
        this.isFree = isFree;
        this.isNormal = isNormal;
    }

    public ParkingSpot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", puste=" + isFree +
                ", zwykle=" + isNormal +
                '}';
    }
}
