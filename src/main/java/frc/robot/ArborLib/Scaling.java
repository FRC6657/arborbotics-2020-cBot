package frc.robot.ArborLib;

public class Scaling {

    public static int scaleInt(int input, int minO, int maxO, int minN, int maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public static double scaleDouble(double input, double minO, double maxO, double minN, double maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public static float scaleFloat(float input, float minO, float maxO, float minN, float maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public static long scaleLong(long input, long minO, long maxO, long minN, long maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}

}