package cultfit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class Booking {
    int id;
    FitnessProgramType fitnessProgramType;
    BookingStatus Status;
    int ProgramId;
    int userId;

    public Booking(FitnessProgramType fitnessProgramType, BookingStatus status, int programId, int userId) {
        this.id = new Random().nextInt(1000);
        this.fitnessProgramType = fitnessProgramType;
        Status = status;
        ProgramId = programId;
        this.userId = userId;
        this.datetime = LocalDateTime.now();
    }

    public Booking(FitnessProgramType fitnessProgramType, int programId, int userId) {
        this.id = new Random().nextInt(1000);
        this.fitnessProgramType = fitnessProgramType;
        Status = BookingStatus.COMPLETED;
        ProgramId = programId;
        this.userId = userId;
        this.datetime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FitnessProgramType getFitnessProgramType() {
        return fitnessProgramType;
    }

    public void setFitnessProgramType(FitnessProgramType fitnessProgramType) {
        this.fitnessProgramType = fitnessProgramType;
    }

    public BookingStatus getStatus() {
        return Status;
    }

    public void setStatus(BookingStatus status) {
        Status = status;
    }

    public int getProgramId() {
        return ProgramId;
    }

    public void setProgramId(int programId) {
        ProgramId = programId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    LocalDateTime datetime;
}
