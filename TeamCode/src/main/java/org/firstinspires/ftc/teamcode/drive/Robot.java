package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

public class Robot {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    BNO055IMU imu;
    Telemetry telemetry;

////    public Orientation startingAngle = new Orientation();
//    public double currAngle = 0.0;
//
//    public Orientation lastAngles;
//
//    private double TURN_P = 1.0/360; // tune this
//
//
//    // constructor
//    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
//        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
//        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
//        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
//        backRight = hardwareMap.get(DcMotor.class, "backRight");
//
//        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
//        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        imu = hardwareMap.get(BNO055IMU.class, "imu");
//
//        this.telemetry = telemetry;
//
//        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
//        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
//        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
//        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
//        parameters.loggingEnabled = true;
//        parameters.loggingTag = "IMU";
//        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
//        imu.initialize(parameters);
//
//    }
//
//    public void resetAngle() {
//        lastAngles = imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES);
//        currAngle = 0;
//    }
//
//    public double getAngle() {
//
//        Orientation orientation = imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES);
//
//        double deltaAngle = orientation.firstAngle - lastAngles.firstAngle;
//        telemetry.addData("raw",orientation.firstAngle);
//        telemetry.addData("z", orientation.firstAngle);
//        telemetry.addData("x", orientation.secondAngle);
//        telemetry.addData("y", orientation.thirdAngle);
//
//        currAngle += deltaAngle;
////        currAngle = orientation.firstAngle - startingAngle.firstAngle;
//       lastAngles = orientation;
//        return currAngle;
//    }
//
//
//    public void turnPID(double degrees) {
//        resetAngle();
//
//        double error = degrees;
//
//        while (Math.abs(error) > 3) {
//            telemetry.addData("angle", this.getAngle());
//            telemetry.addData("error", error);
//
//            double motorPower = error * TURN_P * Math.signum(error);
//            telemetry.addData("power", motorPower);
//
//            turnR(motorPower);
////            error = (degrees - getAngle() > 180) ? -360-degrees+getAngle()  : degrees - getAngle();
////                    Math.atan2(Math.sin(getAngle()), Math.cos(getAngle()));
//            double angle = getAngle();
//            error = Utils.unsignedMin(Utils.unsignedMin(degrees - angle, degrees - (angle + 360)), degrees - (angle - 360));
//
//            telemetry.update();
//        }
//
//        stopBot();
//    }
//
//    public double normalizeAngle(double angle) {
//        if (angle > 180) {
//            angle -= 360;
//        } else if (angle <= -180) {
//            angle += 360;
//        }
//
//        return angle;
//    }
//

    public void stopBot() {
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }

    public void forward(double Power){
        frontRight.setPower(-Power);
        frontLeft.setPower(-Power);
        backRight.setPower(-Power);
        backLeft.setPower(-Power);
    }

    public void backward(double Power) {
        frontRight.setPower(Power);
        frontLeft.setPower(Power);
        backRight.setPower(Power);
        backLeft.setPower(Power);
    }

    //strafing to the left
    public void strafeR(double Power) {
        frontRight.setPower(Power);
        frontLeft.setPower(-Power);
        backRight.setPower(-Power);
        backLeft.setPower(Power);
    }

    // strafing to the right
    public void strafeL(double Power) {
        frontRight.setPower(-Power);
        frontLeft.setPower(Power);
        backRight.setPower(Power);
        backLeft.setPower(-Power);
    }

    //turning left
    public void turnR(double Power) {
        frontRight.setPower(Power);
        frontLeft.setPower(-Power);
        backRight.setPower(Power);
        backLeft.setPower(-Power);
    }

    //turning right
    public void turnL(double Power) {
        frontRight.setPower(-Power);
        frontLeft.setPower(Power);
        backRight.setPower(-Power);
        backLeft.setPower(Power);
    }

    //no carousel

    public void forwardRight(double Power) {
        frontRight.setPower(0);
        frontLeft.setPower(Power);
        backRight.setPower(Power);
        backLeft.setPower(0);
    }

    public void forwardLeft(double Power) {
        frontRight.setPower(Power);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(Power);
    }

    public void backwardRight(double Power) {
        frontRight.setPower(-Power);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(-Power);
    }

    public void backwardLeft(double Power) {
        frontRight.setPower(0);
        frontLeft.setPower(-Power);
        backRight.setPower(-Power);
        backLeft.setPower(0);
    }
}
