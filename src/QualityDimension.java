import java.util.ArrayList;

public class QualityDimension {

    private String descriptiveName;
    private String isoCode;
    private double weightValue;
    private ArrayList<Criterion> criteria;

    public QualityDimension( String descriptiveName,String isoCode,double weightValue){
        this.descriptiveName = descriptiveName;
        this.isoCode =isoCode;
        this.weightValue= weightValue;
        this.criteria = new ArrayList<>();
    }


    public void addCriterion(Criterion c){
       criteria.add(c);

    }

    public double getWeightValue(){
        return weightValue;
    }

    public String getDescriptiveName(){
        return descriptiveName;
    }

    public String getIsoCode(){
        return isoCode;
    }

    public ArrayList<Criterion> getCriteria(){
        return criteria;
    }


    public double calculateDimensionScore(){
        double totalScore =0;
        double totalWeight =0;

        for(Criterion c: criteria){
            totalScore += c.calculateScore() * c.getWeight();
            totalWeight +=c.getWeight();

        }

        if(totalWeight == 0){
            return 0;
        }


        return totalScore / totalWeight;

    }
    public String getQualityLabel(){

        double score = calculateDimensionScore();

        if(score >= 4.5) return "Excellent Quality";
        if(score >= 3.5) return "Good Quality";
        if(score >= 2.5) return "Needs Improvement";

        return "Poor Quality";

    }


}


