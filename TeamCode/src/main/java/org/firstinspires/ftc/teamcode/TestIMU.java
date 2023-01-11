package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (group = "test")
public class TestIMU extends LinearOpMode {
    @Override
    public void runOpMode() {

        Robot robot = new Robot(hardwareMap, telemetry);

        waitForStart();
        robot.turnPID(90);
        //sleep(3000);
        //robot.turnTo(-90, 0.5);


//            while (opModeIsActive()) {
//              Orientation orientation = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.YXZ, AngleUnit.DEGREES);
//              telemetry.addData("first angle", orientation.firstAngle);
//              telemetry.addData("second angle", orientation.secondAngle);
//              telemetry.addData("third angle", orientation.thirdAngle);
//              telemetry.update();
//            }
        }

    }

