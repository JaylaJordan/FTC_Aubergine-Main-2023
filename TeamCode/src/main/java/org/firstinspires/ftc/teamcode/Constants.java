package org.firstinspires.ftc.teamcode;

public class Constants {
    static final double TICKS_PER_MOTOR_ROTATION = 537.7;
    static final double GEAR_REDUCTION = 1;
    static final double WHEEL_DIAMETER_INCHES = 3.77953;
    static final double TICKS_PER_INCH = (TICKS_PER_MOTOR_ROTATION * GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);

    static final double LS_DIAMETER_INCHES = 1.404;
    static final double TICKS_PER_INCH_LS = (TICKS_PER_MOTOR_ROTATION * GEAR_REDUCTION) / (LS_DIAMETER_INCHES * Math.PI);

    static final double MAX_TICKS_LS = 30;
    static final double MIN_TICKS_LS = 10;

    static final double GJ = 0; //ground junction
    static final double LJ = 14.5; //low junction
    static final double MJ = 24.5; //medium junction
    static final double HJ = 34.5; //high junction

    static final double slowVal = 0.4;
    static final double defaultVal = 0.9;
}
