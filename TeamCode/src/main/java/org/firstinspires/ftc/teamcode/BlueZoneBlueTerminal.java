package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.teamcode.TestTeleop.GJ;
import static org.firstinspires.ftc.teamcode.TestTeleop.MJ;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BlueZone BlueTerminal", group = "complex auto")
public class BlueZoneBlueTerminal extends LinearOpMode {
    @Override
    public void runOpMode() {
//        Robot robot = new Robot(hardwareMap);

        RobotEncoded robotencoded = new RobotEncoded(hardwareMap);

        waitForStart();

        robotencoded.closeClaw();

        robotencoded.forward(24,800);

        robotencoded.strafeLeft(12,800);

        robotencoded.forward(3,800);

        robotencoded.setSlidePosition(0.5,MJ);

        robotencoded.forward(3, 800);

        robotencoded.openClaw();
        sleep(1000);

        robotencoded.backward(5,800);

        robotencoded.setSlidePosition(0.5, GJ);

        robotencoded.strafeRight(16,800);

        if (opModeIsActive()) {
            telemetry.addData("front right", robotencoded.frontRight.getPower());
            telemetry.addData("front left", robotencoded.frontLeft.getPower());
            telemetry.addData("back right", robotencoded.backRight.getPower());
            telemetry.addData("back left", robotencoded.backLeft.getPower());
            telemetry.update();
        }

    }
}
