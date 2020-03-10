/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.custom_classes;

/**
 * Taken From ArborLib
 */
public class Scalar {

    /**
     * @param input value to be scaled
     * @param minO  minumum value that the input will be
     * @param maxO  maximum value that the input will be
     * @param minN  desired new minimum value the input will be
     * @param maxN  desired new maximum value the input will be
     * @return scaled input
     * 
     * @author Andrew Card
     */
    public static int scaleInt(int input, int minO, int maxO, int minN, int maxN) {
        return ((input - minO) / (maxO - minO)) * (maxN - minN) + minN;
    }

    /**
     * @param input value to be scaled
     * @param minO  minumum value that the input will be
     * @param maxO  maximum value that the input will be
     * @param minN  desired new minimum value the input will be
     * @param maxN  desired new maximum value the input will be
     * @return scaled input
     * 
     * @author Andrew Card
     */
    public static double scaleDouble(double input, double minO, double maxO, double minN, double maxN) {
        return ((input - minO) / (maxO - minO)) * (maxN - minN) + minN;
    }

    /**
     * @param input value to be scaled
     * @param minO  minumum value that the input will be
     * @param maxO  maximum value that the input will be
     * @param minN  desired new minimum value the input will be
     * @param maxN  desired new maximum value the input will be
     * @return scaled input
     * 
     * @author Andrew Card
     */
    public static float scaleFloat(float input, float minO, float maxO, float minN, float maxN) {
        return ((input - minO) / (maxO - minO)) * (maxN - minN) + minN;
    }

    /**
     * @param input value to be scaled
     * @param minO  minumum value that the input will be
     * @param maxO  maximum value that the input will be
     * @param minN  desired new minimum value the input will be
     * @param maxN  desired new maximum value the input will be
     * @return scaled input
     * 
     * @author Andrew Card
     */
    public static long scaleLong(long input, long minO, long maxO, long minN, long maxN) {
        return ((input - minO) / (maxO - minO)) * (maxN - minN) + minN;
    }

}
