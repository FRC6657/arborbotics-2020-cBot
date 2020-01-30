package frc.robot.ArborLib;

public class Scaling {

    public int scaleInt(int input, int minO, int maxO, int minN, int maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public double scaleDouble(double input, double minO, double maxO, double minN, double maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public float scaleFloat(float input, float minO, float maxO, float minN, float maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public long scaleLong(long input, long minO, long maxO, long minN, long maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}

}