package frc.robot;

public class utilities {

    public utilities(){
        //empty super
    }

    public Integer ratioScaling(Integer oMin, Integer oMax, Integer oValue, Integer sMin, Integer sMax){
        Integer outPut;
        outPut = sMin + (oValue - oMin) * (sMax - sMin) / (oMax - oMin);
        return outPut;
    }

    public double ratioScaling(double oMin, double oMax, double oValue, double sMin, double sMax){
        double outPut;
        outPut = sMin + (oValue - oMin) * (sMax - sMin) / (oMax - oMin);
        return outPut;
    }

    public Double ratioScaling(Double oMin, Double oMax, Double oValue, Double sMin, Double sMax){
        Double outPut;
        outPut = sMin + (oValue - oMin) * (sMax - sMin) / (oMax - oMin);
        return outPut;
    }

    public float ratioScaling(float oMin, float oMax, float oValue, float sMin, float sMax){
        float outPut;
        outPut = sMin + (oValue - oMin) * (sMax - sMin) / (oMax - oMin);
        return outPut;
    }

    public Float ratioScaling(Float oMin, Float oMax, Float oValue, Float sMin, Float sMax){
        Float outPut;
        outPut = sMin + (oValue - oMin) * (sMax - sMin) / (oMax - oMin);
        return outPut;
    }

}