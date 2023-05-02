package org.firstinspires.ftc.teamcode.drive.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.teamcode.drive.Constants;

@TeleOp (name="terst")
public class TestLinearSlides extends OpMode {

    double lsHeight = 0;

    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    DcMotorEx linearSlide;

    Servo claw;

    @Override
    public void init() {   // only ran once

        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        linearSlide = hardwareMap.get(DcMotorEx.class, "linearSlide");

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        linearSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        claw = hardwareMap.get(Servo.class, "claw");
        claw.scaleRange(0, 1);
    }

    @Override
    public void loop() {   // runs on multiple times

        linearSlide.setTargetPosition(1000);
        linearSlide.setVelocity(800);
        linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        double x = -gamepad1.left_stick_x; // stores data in gp
        double y = gamepad1.left_stick_y;
        double r = -gamepad1.right_stick_x;

        if (gamepad1.right_bumper) {
            frontLeft.setPower((y + x + r) * Constants.slowVal);
            frontRight.setPower((y - x - r) * Constants.slowVal);
            backLeft.setPower((y - x + r) * Constants.slowVal);
            backRight.setPower((y + x - r) * Constants.slowVal);
        } else {
            frontLeft.setPower((y + x + r) * Constants.defaultVal);
            frontRight.setPower((y - x - r) * Constants.defaultVal);
            backLeft.setPower((y - x + r) * Constants.defaultVal);
            backRight.setPower((y + x - r) * Constants.defaultVal);
        }

        //claw servo
        if (gamepad2.right_bumper) { // open claw
            claw.setPosition(Constants.openVal);
        }
        else if (gamepad2.left_bumper) { // close claw
            claw.setPosition(Constants.closeVal);
        }

        // linear slide motion
        if (gamepad2.a) {
            linearSlide.setTargetPosition(Constants.ticksGJ);
        }
        else if (gamepad2.b) {
            linearSlide.setTargetPosition(Constants.ticksLJ);
        }
        else if (gamepad2.x) {
            linearSlide.setTargetPosition(Constants.ticksMJ);
        }
        else if (gamepad2.y) {
            linearSlide.setTargetPosition(Constants.ticksHJ);
        }
        if (gamepad2.right_stick_y > 0.1 && lsHeight >= 0) {
            lsHeight = linearSlide.getCurrentPosition() / Constants.TICKS_PER_INCH_LS;
            lsHeight -= 0.9;

        } else if (gamepad2.right_stick_y < -0.1) {
            lsHeight = linearSlide.getCurrentPosition() / Constants.TICKS_PER_INCH_LS;
            lsHeight += 0.9;
        }

        int rawDifference = linearSlide.getCurrentPosition() - linearSlide.getTargetPosition();

//        if (Math.abs(rawDifference) >= 10) {
//            linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            linearSlide.setVelocity(800);
//        }
//        else linearSlide.setVelocity(0);

        telemetry.addData("linear slide velocity", linearSlide.getVelocity());
        telemetry.addData("target pos", linearSlide.getTargetPosition());
        telemetry.addData("cur pos", linearSlide.getCurrentPosition());
        telemetry.update();
    }
}