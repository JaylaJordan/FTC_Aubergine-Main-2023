package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.teamcode.TestTeleop.GJ;
import static org.firstinspires.ftc.teamcode.TestTeleop.LJ;
import static org.firstinspires.ftc.teamcode.TestTeleop.MJ;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BlueZoneRedTerminal", group = "complex auto")
public class BlueZoneRedTerminal extends LinearOpMode {
    @Override
    public void runOpMode() {
    //    Robot robot = new Robot(hardwareMap);

        RobotEncoded robotencoded = new RobotEncoded(hardwareMap);

        waitForStart();
    //    if (isStopRequested()) return;

        robotencoded.closeClaw();

        robotencoded.forward(24,800);

        robotencoded.strafeRight(12,800);

        robotencoded.forward(4,800);

        robotencoded.setSlidePosition(900,MJ);

        robotencoded.forward(2.5,800);
        sleep(4000); // wait until the arm stops shaking midair

        robotencoded.openClaw();
        sleep(1000);

        robotencoded.backward(5,800);

        robotencoded.setSlidePosition(900,GJ);

        robotencoded.strafeLeft(16,800);

        /*
        robotencoded.forward(12,800);

        robotencoded.turnLeft(20,800);

        robotencoded.forward(9,800);

        robotencoded.backward(8, 800);

        robotencoded.turnRight(20,800);

        robotencoded.forward(12,800);

        robotencoded.turnLeft(20,800);

        robotencoded.forward(12,800);
*/

        if (opModeIsActive()) {
            telemetry.addData("front right", robotencoded.frontRight.getPower());
            telemetry.addData("front left", robotencoded.frontLeft.getPower());
            telemetry.addData("back right", robotencoded.backRight.getPower());
            telemetry.addData("back left", robotencoded.backLeft.getPower());
            telemetry.update();
        }
    }
}
