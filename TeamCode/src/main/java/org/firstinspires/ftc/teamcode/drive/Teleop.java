package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.Constants;


@TeleOp (name="main")
public class Teleop extends OpMode {

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

        //claw servo
        if (gamepad2.right_bumper) { // open claw
            claw.setPosition(Constants.openVal);
        }
        else if (gamepad2.left_bumper) { // close claw
             claw.setPosition(Constants.closeVal);
        }

        // linear slide motion
        if (gamepad2.a) {
            lsHeight = Constants.GJ;
        }
        else if (gamepad2.b) {
            lsHeight = Constants.LJ;
        }
        else if (gamepad2.x) {
            lsHeight = Constants.MJ;
        }
        else if (gamepad2.y) {
            lsHeight = Constants.HJ;
        }

        //manual control
        if (gamepad2.right_stick_y > 0.1 && lsHeight >= 0) {
            lsHeight = linearSlide.getCurrentPosition() / Constants.TICKS_PER_INCH_LS;
            lsHeight -= 0.9;
        } else if (gamepad2.right_stick_y < -0.1) {
            lsHeight = linearSlide.getCurrentPosition() / Constants.TICKS_PER_INCH_LS;
            lsHeight += 0.9;
        }

        //move linear slide
        double rawDifference = linearSlide.getCurrentPosition() - lsHeight * Constants.TICKS_PER_INCH_LS;
        double difference = Math.abs(rawDifference);

        if (difference >= 30) {
            linearSlide.setTargetPosition((int)(lsHeight * Constants.TICKS_PER_INCH_LS));
            linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            linearSlide.setPower(0.6);
        }
        else linearSlide.setPower(0);

        telemetry.addData("difference", difference);
        telemetry.addData("raw difference", rawDifference);
        telemetry.addData("linear slide velocity", linearSlide.getVelocity());
        telemetry.addData("target pos", linearSlide.getTargetPosition());
        telemetry.addData("cur pos", linearSlide.getCurrentPosition());
        telemetry.update();
    }
}