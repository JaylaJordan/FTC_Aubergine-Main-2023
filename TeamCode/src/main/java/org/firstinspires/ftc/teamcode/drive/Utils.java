package org.firstinspires.ftc.teamcode.drive;

public class Utils {
    public static double unsignedMin(double a, double b) {
        return Math.min(a, b) * Math.signum(Math.min(a, b));
    }
}

