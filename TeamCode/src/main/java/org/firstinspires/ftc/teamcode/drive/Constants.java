package org.firstinspires.ftc.teamcode.drive;

public class Constants {
    /* motor encoder configuration */
    static final double TICKS_PER_MOTOR_ROTATION = 537.7;
    static final double GEAR_REDUCTION = 1;
    static final double WHEEL_DIAMETER_INCHES = 3.77953;
    static final double TICKS_PER_INCH = (TICKS_PER_MOTOR_ROTATION * GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);

    static final double LS_DIAMETER_INCHES = 1.404;
    static final double TICKS_PER_INCH_LS = (TICKS_PER_MOTOR_ROTATION * GEAR_REDUCTION) / (LS_DIAMETER_INCHES * Math.PI);

    static final double MAX_TICKS_LS = 30;
    static final double MIN_TICKS_LS = 10;


    /* junction height */
    static final double GJ = 0; //ground junction
    static final double LJ = 14.5; //low junction
    static final double MJ = 24.5; //medium junction
    static final double HJ = 34; //high junction

    static final int ticksGJ = 0;
    static final int ticksLJ = 1680;
    static final int ticksMJ = 2893;
    static final int ticksHJ = 4020;

    /*teleOP config */
    static final double slowVal = 0.4;
    static final double defaultVal = 0.9;

    //in range from 0 to 1
    static final double closeVal = 0.9;
    static final double openVal = 0.1;

    /* camera config */

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    static final double fx = 578.272;
    static final double fy = 578.272;
    static final double cx = 402.145;
    static final double cy = 221.506;

    static final double tagsize = 0.166; // UNITS ARE METERS

    static final int Left = 2; //Tag IDs of sleeve
    static final int Middle = 4;
    static final int Right = 6;

    //roadrunner measurements:
    // TRACK WIDTH: 13 IN
}
