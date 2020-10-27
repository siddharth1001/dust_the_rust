package cultfit;

public abstract class FitnessProgram {
    private int id;
    private FitnessProgramType type;
    private int size;

    public int getId() {
        return id;
    }

    public FitnessProgramType getType() {
        return type;
    }

    public FitnessProgram(int id, FitnessProgramType type) {
        this.id = id;
        this.type = type;
        this.size = Constants.CLASS_SIZE;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static FitnessProgram addProgram(int id, FitnessProgramType fitnessProgramType) {
        switch (fitnessProgramType) {
            case CARDIO:
                return new Cardio(id, fitnessProgramType);
            case SNC:
                return new Snc(id, fitnessProgramType);
            default:
                return new Boxing(id, fitnessProgramType);
        }
    }

    public abstract String description();
}

class Boxing extends FitnessProgram {

    public Boxing(int id, FitnessProgramType type) {
        super(id, type);
    }


    public String description() {
        return "Boxing is a popular sport";
    }
}


class Cardio extends FitnessProgram {

    public Cardio(int id, FitnessProgramType type) {
        super(id, type);
    }


    public String description() {
        return "Cardio is for endurance.";
    }
}

class Snc extends FitnessProgram {

    public Snc(int id, FitnessProgramType type) {
        super(id, type);
    }


    public String description() {
        return "SNC is for Strength and Endurance.";
    }
}