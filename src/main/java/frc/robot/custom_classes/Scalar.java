/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.custom_classes;

/**
 * Add your docs here.
 */
public class Scalar {

    //From ArborLib
    public static int scaleInt(int input, int minO, int maxO, int minN, int maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public static double scaleDouble(double input, double minO, double maxO, double minN, double maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public static float scaleFloat(float input, float minO, float maxO, float minN, float maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}
    public static long scaleLong(long input, long minO, long maxO, long minN, long maxN){return ((input - minO)/(maxO - minO)) * (maxN - minN) + minN;}

}
