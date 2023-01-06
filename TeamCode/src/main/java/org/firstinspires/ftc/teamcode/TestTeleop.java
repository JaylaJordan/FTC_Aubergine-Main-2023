package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.RobotEncoded.TICKS_PER_INCH_LS;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp (name="main")
public class TestTeleop extends OpMode {


    static double GJ = 0; //ground junction
    static double LJ = 14.5; //low junction
    static double MJ = 24.5; //medium junction
    static double HJ = 34.5; //high junction
    double lsHeight = 0;

    double slowVal = 0.4;
    double defaultVal = 0.9;

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

        claw = hardwareMap.get(Servo.class, "claw");
        claw.scaleRange(0, 1);
    }

    @Override
    public void loop() {   // runs on multiple times
        double x = -gamepad1.left_stick_x; // stores data in gp
        double y = gamepad1.left_stick_y;
        double r = -gamepad1.right_stick_x;

        if (gamepad1.right_bumper) {
            frontLeft.setPower((y + x + r) * slowVal);
            frontRight.setPower((y - x - r) * slowVal);
            backLeft.setPower((y - x + r) * slowVal);
            backRight.setPower((y + x - r) * slowVal);
        } else {
            frontLeft.setPower((y + x + r) * defaultVal);
            frontRight.setPower((y - x - r) * defaultVal);
            backLeft.setPower((y - x + r) * defaultVal);
            backRight.setPower((y + x - r) * defaultVal);
        }


        //claw servo
        if (gamepad2.right_bumper) { // open claw
            claw.setPosition(0.9);
        }
        else if (gamepad2.left_bumper) { // close claw
             claw.setPosition(0.2);
        }


        // linear slide motion
        if (gamepad2.a) {
            lsHeight = GJ;
        }
        else if (gamepad2.b) {
            lsHeight = LJ;
        }
        else if (gamepad2.x) {
            lsHeight = MJ;
        }
        else if (gamepad2.y) {
            lsHeight = HJ;
        }

        if (linearSlide.getCurrentPosition() != (int) (lsHeight * TICKS_PER_INCH_LS)) {
            linearSlide.setTargetPosition((int)(lsHeight * TICKS_PER_INCH_LS));
            linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            linearSlide.setVelocity(1500);
        } else linearSlide.setVelocity(0);

        telemetry.addData("y:", y);
        telemetry.addData("x: ", x);
        telemetry.addData("r", r);
        telemetry.addData("linear slide velocity", linearSlide.getVelocity());
        telemetry.addData("claw position", claw.getPosition());
        telemetry.addData("cur pos", linearSlide.getCurrentPosition());
        telemetry.addData("target pos", lsHeight * TICKS_PER_INCH_LS);
        telemetry.update();
//    }
    }
}