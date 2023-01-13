package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "red zone blue terminal", group = "complex auto")
public class RedZoneBlueTerminal extends LinearOpMode {
    @Override
    public void runOpMode() {
        //Robot robot = new Robot(hardwareMap);
        RobotEncoded robotencoded = new RobotEncoded(hardwareMap);

        waitForStart();
        //if (isStopRequested()) return;
        // turning distanceInches value: 20
        //to the right too much
        //right
        //since this is a blue terminal starting pos. will be at the left edge

        robotencoded.closeClaw();

        robotencoded.forward(2,800);

        robotencoded.strafeRight(5,800);

        robotencoded.forward(22,800);

        robotencoded.strafeLeft(19,800);

        robotencoded.forward(3,800);

        robotencoded.setSlidePosition(800,Constants.MJ);

        robotencoded.forward(3,800);
        robotencoded.closeClaw();
        sleep(1500); // wait until the arm stops shaking midair

        robotencoded.stopBot();
        robotencoded.openClaw();
        sleep(1000);

        robotencoded.backward(5,800);

        robotencoded.setSlidePosition(800,Constants.GJ);

        robotencoded.strafeRight(16,800);

        robotencoded.forward(24,800);

        robotencoded.turnRight(22,800); //turn 90 degrees

        robotencoded.forward(22,800);

        robotencoded.setSlidePosition(800,11.5);
        sleep(1000);

        robotencoded.closeClaw();
        sleep(1000);

        robotencoded.backward(6,800);

        robotencoded.turnRight(22,800);

        robotencoded.forward(2,800);

        robotencoded.setSlidePosition(800,Constants.LJ);
        robotencoded.closeClaw();
        sleep(1000);

        robotencoded.openClaw();
        robotencoded.stopBot();
        sleep(1000);

        robotencoded.backward(12,800);

        robotencoded.turnLeft(20,800);

        robotencoded.forward(8,800);

        robotencoded.setSlidePosition(800,10.5);
        robotencoded.closeClaw();
        sleep(1000);

        robotencoded.openClaw();
        sleep(1000);

        robotencoded.backward(12,800);

        robotencoded.turnLeft(22,800);

        robotencoded.forward(3,800);

        robotencoded.setSlidePosition(800,Constants.LJ);
        sleep(1000);

        robotencoded.openClaw();
        sleep(1000);


        if (opModeIsActive()) {
            telemetry.addData("front right", robotencoded.frontRight.getPower());
            telemetry.addData("front left", robotencoded.frontLeft.getPower());
            telemetry.addData("back right", robotencoded.backRight.getPower());
            telemetry.addData("back left", robotencoded.backLeft.getPower());
            telemetry.addData("linear slide position", robotencoded.linearSlide.getCurrentPosition());
            telemetry.update();
        }
    }
}

