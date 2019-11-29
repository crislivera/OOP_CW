import java.util.Date;

public class Schedule {

    private Date pickUpDate;
    private Date dropOffDate;
    private Vehicle vehicle;

    public Schedule(Date pickUpDate, Date dropOffDate, Vehicle vehicle) {
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.vehicle = vehicle;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }
    public int getNumOfDays(){
        int numOfDays = 0;
        return numOfDays;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                ", vehicle=" + vehicle +
                '}';
    }
}
