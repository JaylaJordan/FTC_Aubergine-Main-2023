package org.firstinspires.ftc.teamcode.drive;

public class Constants {
    /* motor encoder configuration */
    public static final double TICKS_PER_MOTOR_ROTATION = 537.7;
    public static final double GEAR_REDUCTION = 1;
    public static final double WHEEL_DIAMETER_INCHES = 3.77953;
    public static final double TICKS_PER_INCH = (TICKS_PER_MOTOR_ROTATION * GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);

    public static final double LS_DIAMETER_INCHES = 1.404;
    public static final double TICKS_PER_INCH_LS = (TICKS_PER_MOTOR_ROTATION * GEAR_REDUCTION) / (LS_DIAMETER_INCHES * Math.PI);

    public static final double MAX_TICKS_LS = 30;
    public static final double MIN_TICKS_LS = 10;


    /* junction height */
    static final double GJ = 0; //ground junction
    static final double LJ = 14.5; //low junction
    static final double MJ = 24.5; //medium junction
    static final double HJ = 34; //high junction

    public static final int ticksGJ = 0;
    public static final int ticksLJ = 1680;
    public static final int ticksMJ = 2893;
    public static final int ticksHJ = 4020;

    /*teleOP config */
    public static final double slowVal = 0.4;
    public static final double defaultVal = 0.9;

    //in range from 0 to 1
    public static final double closeVal = 0.1;
    public static final double openVal = 0.75;

    /* camera config */

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    public static final double fx = 578.272;
    public static final double fy = 578.272;
    public static final double cx = 402.145;
    public static final double cy = 221.506;

    public static final double tagsize = 0.166; // UNITS ARE METERS

    public static final int Left = 2; //Tag IDs of sleeve
    public static final int Middle = 4;
    public static final int Right = 6;

    //roadrunner measurements:
    // TRACK WIDTH: 13 IN
}
