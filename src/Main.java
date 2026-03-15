import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


        HashMap<String, ArrayList<SWSystem>> allSystems = SWSystemData.getAllSystems();
        ArrayList<SWSystem> webSystems = allSystems.get("Web");


        SWSystem shopSphere = webSystems.get(0);


        for (QualityDimension d : shopSphere.getDimensions()) {

            for (Criterion c : d.getCriteria()) {

                if (c.getName().equals("Functional Completeness Ratio"))
                    c.setMeasuredValue(94);

                if (c.getName().equals("Functional Correctness Ratio"))
                    c.setMeasuredValue(91);

                if (c.getName().equals("Availability Ratio"))
                    c.setMeasuredValue(99.2);

                if (c.getName().equals("Defect Density"))
                    c.setMeasuredValue(2.1);

                if (c.getName().equals("Response Time"))
                    c.setMeasuredValue(220);

                if (c.getName().equals("CPU Utilisation Ratio"))
                    c.setMeasuredValue(38);

                if (c.getName().equals("Test Coverage Ratio"))
                    c.setMeasuredValue(72);

                if (c.getName().equals("Cyclomatic Complexity (avg)"))
                    c.setMeasuredValue(8.5);
            }
        }


        shopSphere.printReport();
    }
}