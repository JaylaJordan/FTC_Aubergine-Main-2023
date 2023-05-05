package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.drive.RobotEncoded;

@Disabled
@Autonomous(group = "test")
public class Trajectory_Camera_Blue extends LinearOpMode {
    @Override
    public void runOpMode() {

        RobotEncoded robotencoded = new RobotEncoded(hardwareMap, telemetry);

        waitForStart();

        robotencoded.closeClaw();
        robotencoded.forward(2,1100);
        sleep(100);
        robotencoded.strafeLeft(21,1000);
        sleep(100);
        robotencoded.forward(21,1100);
        sleep(100);
        robotencoded.strafeRight(12,1000);
        sleep(100);
        robotencoded.setSlidePosition(1500,Constants.MJ);
        sleep(100);
        robotencoded.forward(8,1100);
        sleep(800);
        robotencoded.openClaw();
        sleep(800);
        robotencoded.backward(8,1100);
        sleep(100);
        robotencoded.strafeLeft(12,1000);
        sleep(100);
        robotencoded.forward(21.5,1000);
        sleep(100);
        robotencoded.turnRight(19,900);
        sleep(100);
        robotencoded.openClaw();
        sleep(100);
        robotencoded.setSlidePosition(1500,5.5);
        sleep(100);
        robotencoded.forward(45,1100);
        sleep(300);
        robotencoded.closeClaw();
        sleep(500);
        robotencoded.setSlidePosition(1500,Constants.MJ);
        sleep(100);
        robotencoded.backward(38,1100);
        sleep(100);
        robotencoded.turnRight(19,900);
        sleep(100);
        robotencoded.forward(4.5,1100);
        sleep(800);
        robotencoded.openClaw();
        sleep(800);
        robotencoded.backward(6,1100);
        sleep(100);
        robotencoded.strafeRight(12,1100);
        sleep(100);
        robotencoded.forward(18,1400);

//        robotencoded.setSlidePosition(1400,7.5);
//        sleep(100);
//        robotencoded.strafeRight(12,1400);
//        sleep(100);
//        robotencoded.forward(17,1100);
    }
}