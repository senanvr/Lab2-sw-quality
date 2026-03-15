public class Criterion {
    private String name;
    private double weight;
    private String evaluationDirection;
    private double minVal;
    private double maxVal;
    private String measuredUnit;
    private double measuredValue;


    public Criterion(String name,double weight,String evaluationDirection,double minVal,double maxVal,String measuredUnit){
        this.name = name;
        this.weight= weight;
        this.evaluationDirection= evaluationDirection;
        this.minVal =minVal;
        this.maxVal = maxVal;
        this.measuredUnit= measuredUnit;

    }
    public String getName(){
        return name;
    }
    public double getWeight(){
        return weight;
    }

    public String getEvaluationDirection(){
        return evaluationDirection;
    }
    public double getMinVal(){
        return minVal;
    }

    public double getMaxVal() {
        return maxVal;
    }

    public String getMeasuredUnit() {
        return measuredUnit;
    }

    public double getMeasuredValue() {
        return measuredValue;
    }
    public void setMeasuredValue(double measuredValue){
        this.measuredValue= measuredValue;
    }



    public double calculateScore(){
        double score;


        if(evaluationDirection.equals("higher")){
            score = 1+ (measuredValue-minVal)/ (maxVal-minVal) *4;
        }
        else{
            score = 5-(measuredValue-minVal)/ (maxVal-minVal) *4;
        }


        if(score<1)
            score =1;
        if(score>5)
            score =5;


        score =Math.round(score*2)/2.0;


        return score;
    }


    @Override

    public String toString() {

        String directionText = evaluationDirection.equalsIgnoreCase("higher") ? "Higher is better" : "Lower is better";

        return name + ": " + measuredValue + " " + measuredUnit + " -> Score: " + calculateScore() + " (" + directionText + ")";
    }
}
