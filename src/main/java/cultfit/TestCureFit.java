package cultfit;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;

public class TestCureFit {

    public static void main(String[] args) {
        FitnessCentre centre = new FitnessCentre();
        String msg = centre.bookClass(FitnessProgramType.CARDIO, 1);
        System.out.println("------------\n" + msg);

        msg = centre.bookClass(FitnessProgramType.CARDIO, 1);
        System.out.println("------------\n" + msg);
        msg = centre.bookClass(FitnessProgramType.CARDIO, 2);
        System.out.println("------------\n" + msg);
        msg = centre.bookClass(FitnessProgramType.CARDIO, 3);
        System.out.println("------------\n" + msg);

        msg = centre.cancelClass(FitnessProgramType.CARDIO, 1);
        System.out.println("------------\n" + msg);

        msg = centre.bookClass(FitnessProgramType.CARDIO, 3);
        System.out.println("------------\n" + msg);
    }
}
