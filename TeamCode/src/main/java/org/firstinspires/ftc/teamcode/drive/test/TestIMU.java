package org.firstinspires.ftc.teamcode.drive.test;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.drive.RobotEncoded;

@Autonomous (group = "test")
public class TestIMU extends LinearOpMode {
    @Override
    public void runOpMode() {

        RobotEncoded robotencoded = new RobotEncoded(hardwareMap, telemetry);

        waitForStart();
//        robotencoded.turnPID(90);
        BNO055IMU imu = hardwareMap.get(BNO055IMU.class, "imu");

        while (opModeIsActive()) {
              Orientation orientation = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.YXZ, AngleUnit.DEGREES);
              telemetry.addData("first angle", orientation.firstAngle);
              telemetry.addData("second angle", orientation.secondAngle);
              telemetry.addData("third angle", orientation.thirdAngle);telemetry.update();
            }

    }

}