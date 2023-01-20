package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "red zone blue terminal", group = "complex auto")
public class RedZoneBlueTerminal extends LinearOpMode {
    @Override
    public void runOpMode() {
        //Robot robot = new Robot(hardwareMap, telemetry);
        RobotEncoded robotencoded = new RobotEncoded(hardwareMap);

        waitForStart();
        //if (isStopRequested()) return;
        // turning distanceInches value: 22
       //right
        //since this is a blue terminal starting pos. will be at the left edge

        robotencoded.closeClaw();

        robotencoded.forward(2,850);

        robotencoded.strafeRight(5,700);

        robotencoded.forward(23,850);

        robotencoded.strafeLeft(18,700);

        robotencoded.forward(3,850);

        robotencoded.setSlidePosition(850,Constants.MJ);

        robotencoded.forward(2,850);
        robotencoded.closeClaw();
        sleep(1000); // wait until the arm stops shaking midair

        robotencoded.stopBot();
        robotencoded.openClaw();
        sleep(1000);

        robotencoded.backward(5,850);

        robotencoded.setSlidePosition(850,Constants.GJ);

        robotencoded.strafeRight(16,700);

        robotencoded.forward(25,850);

//        robot.turnPID(90);
        robotencoded.turnRight(23,800); //turn 90 degrees

        robotencoded.forward(18,850);

        robotencoded.setSlidePosition(850,6);
        sleep(1000);

        robotencoded.forward(2,800);
        robotencoded.openClaw();
        sleep(1000);
        robotencoded.closeClaw();
        sleep(1000);

        robotencoded.backward(12,850);

//        robot.turnPID(90);
        robotencoded.turnRight(23,800);

        robotencoded.forward(2,850);

        robotencoded.setSlidePosition(850,Constants.LJ);
        robotencoded.closeClaw();
        sleep(1000);

        robotencoded.openClaw();
        robotencoded.stopBot();
        sleep(1000);

        robotencoded.backward(12,850);

        robotencoded.turnLeft(20,850);

        robotencoded.forward(8,850);

        robotencoded.setSlidePosition(850,8.5);
        robotencoded.closeClaw();
        sleep(1000);

        robotencoded.openClaw();
        sleep(1000);

        robotencoded.backward(12,850);

        robotencoded.turnLeft(22,850);

        robotencoded.forward(3,850);

        robotencoded.setSlidePosition(850,Constants.LJ);
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

