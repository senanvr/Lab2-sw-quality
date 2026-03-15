import java.util.ArrayList;

public class SWSystem {

    private String systemName;
    private String systemCategory;
    private String version;
    private ArrayList<QualityDimension>dimensions;

    public SWSystem(String systemName,String systemCategory,String version){
        this.systemName= systemName;
        this.systemCategory = systemCategory;
        this.version= version;
        this.dimensions = new ArrayList<>();
    }
    public void addDimension( QualityDimension d){
        dimensions.add(d);

    }

    public ArrayList<QualityDimension> getDimensions(){
        return dimensions;
    }


    public double calculateOverallScore(){
        double totalScore =0;
        double totalWeight =0;

        for(QualityDimension d : dimensions){
            totalScore += d.calculateDimensionScore() * d.getWeightValue();
            totalWeight += d.getWeightValue();

        }


        if(totalWeight == 0) {
            return 0;
        }
        return totalScore/ totalWeight;
    }

    public QualityDimension findWeakestDimension(){
        if(dimensions.isEmpty()) return null;

        QualityDimension weakest = dimensions.get(0);

        for(QualityDimension d : dimensions){
            if(d.calculateDimensionScore()< weakest.calculateDimensionScore()){
                weakest =d;
            }
        }

        return weakest;

    }



    public void printReport() {
        System.out.println("========================================");
        System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
        System.out.println("System: " + systemName + " v" + version + " (" + systemCategory + ")");
        System.out.println("========================================");

        for (QualityDimension d : dimensions) {
            System.out.println("--- " + d.getDescriptiveName() + " [" + d.getIsoCode() + "] (Weight: " + (int)d.getWeightValue() + ") ---");
            for (Criterion c : d.getCriteria()) {
                System.out.println(c);
            }
            System.out.printf(">> Dimension Score: %.1f/5 [%s]\n\n", d.calculateDimensionScore(), d.getQualityLabel());
        }

        double overall = calculateOverallScore();
        String overallLabel = (overall >= 4.5) ? "Excellent Quality" : (overall >= 3.5) ? "Good Quality" : (overall >= 2.5) ? "Needs Improvement" : "Poor Quality";

        System.out.println("========================================");
        System.out.printf("OVERALL QUALITY SCORE: %.1f/5 [%s]\n", overall, overallLabel);
        System.out.println("========================================");

        QualityDimension weakest = findWeakestDimension();
        if (weakest != null) {
            double gap = 5.0 - weakest.calculateDimensionScore();
            System.out.println("GAP ANALYSIS (ISO/IEC 25010)");
            System.out.println("========================================");
            System.out.println("Weakest Characteristic : " + weakest.getDescriptiveName() + " [" + weakest.getIsoCode() + "]");
            System.out.printf("Score: %.1f/5 | Gap: %.1f\n", weakest.calculateDimensionScore(), gap);
            System.out.println("Level: " + weakest.getQualityLabel());
            System.out.println(">> This characteristic requires the most improvement.");
            System.out.println("========================================");
        }
    }
}