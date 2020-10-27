package cultfit;

import java.util.ArrayList;
import java.util.List;

public class FitnessCentre {
    private List<User> users;
    private List<FitnessProgram> programs;
    private BookingService bookingService;

    public FitnessCentre() {
        addUsers();
        addFitnessPrograms();
    }

    private void addUsers() {
        users = new ArrayList<User>();
        String[] usernames = {"John", "Sid", "Anshul"};
        for (int i = 1; i <= 3; i++) {
            users.add(new User(i, usernames[i - 1]));
        }
        System.out.println("Users added");
    }

    private void addFitnessPrograms() {
        programs = new ArrayList<>();
        bookingService = new BookingService();

        FitnessProgramType[] types = {FitnessProgramType.BOXING, FitnessProgramType.CARDIO, FitnessProgramType.SNC};

        for (int i = 1; i <= 3; i++) {
            programs.add(FitnessProgram.addProgram(i, types[i - 1]));
            bookingService.addProgram();
        }
        System.out.println("Programs added");
    }

    public String bookClass(FitnessProgramType programType, int userId) {
        Error err = isValidRequest(programType, userId);

        if (err.isError()) {
            return err.getMsg();
        }

        // check for program size
        // check if the
        FitnessProgram program = null;
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getType() == programType) {
                program = programs.get(i);
            }
        }

        err = BookingService.book(program, userId);
        if (err.isError()) {
            return err.getMsg();
        }

        return err.getMsg();
    }

    public String cancelClass(FitnessProgramType programType, int userId) {
        Error err = isValidRequest(programType, userId);

        if (err.isError()) {
            return err.getMsg();
        }
        FitnessProgram program = null;
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getType() == programType) {
                program = programs.get(i);
            }
        }

        err = BookingService.cancel(program, userId);
        if (err.isError()) {
            return err.getMsg();
        }
        return "Successfully cancelled " + programType + " class for user id=" + userId;
    }

    // check for valid user and fitness program
    private Error isValidRequest(FitnessProgramType programType, int userId) {
        return new Error("", false);
    }
}
