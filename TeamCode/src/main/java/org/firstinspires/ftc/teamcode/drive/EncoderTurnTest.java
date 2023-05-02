package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.drive.RobotEncoded;


@Autonomous(group = "test")
public class EncoderTurnTest extends LinearOpMode {
    @Override
    public void runOpMode() {

        RobotEncoded robotencoded = new RobotEncoded(hardwareMap, telemetry);

        waitForStart();

        robotencoded.forward(20,1500);
        robotencoded.turnLeft(20,1200);
    }
}