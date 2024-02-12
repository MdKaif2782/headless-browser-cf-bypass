package ai.kf.HSC;

import static ai.kf.HSC.HscResult.*;

public class RkblResult {
    public static void main(String[] args) {
        int start = (137710);
        int end = (137710+500);
        //make the roll string 6 digit by adding 0 in front
        for (int i = start; i <= end; i++) {
            String roll = String.format("%06d", i);
            String res = getResultWithRollReg(roll, "1810946451");
            if (res.contains("RESULT NOT FOUND!")) {
                System.out.println("No result found for " + roll);
            } else {
                System.out.println("Result found for " + String.format("%06d", (start)));
                System.out.println("Saving result for " + String.format("%06d", (start)));
                saveHtmlToFile(res, "result_" + String.format("%06d", (start)) + ".html");
                System.out.println("Opening result for " + String.format("%06d", (start)));
                openHtmlFile("result_" + String.format("%06d", (start)) + ".html");
            }
        }
    }
}
