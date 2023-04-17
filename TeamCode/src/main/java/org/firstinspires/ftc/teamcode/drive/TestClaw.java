package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.Constants;

@TeleOp (name="test claw")
public class TestClaw extends OpMode {

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
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        claw = hardwareMap.get(Servo.class, "claw");
        claw.scaleRange(0, 1);
    }

    @Override
    public void loop() {   // runs on multiple times
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

        claw.setPosition(gamepad2.left_stick_y);
/*
        //claw servo
        if (gamepad2.right_bumper) {
            claw.setPosition(0.1);
        }
        else if (gamepad2.left_bumper) {
            claw.setPosition(0.2);
        }

        // linear slide motion
        if (gamepad2.a) {
            claw.setPosition(0.3);
        }
        else if (gamepad2.b) {
            claw.setPosition(0.4);
        }
        else if (gamepad2.x) {
            claw.setPosition(0.5);
        }
        else if (gamepad2.y) {
            claw.setPosition(0.6);
        }*/



        telemetry.addData("claw pos",claw.getPosition());
        telemetry.update();
    }
}