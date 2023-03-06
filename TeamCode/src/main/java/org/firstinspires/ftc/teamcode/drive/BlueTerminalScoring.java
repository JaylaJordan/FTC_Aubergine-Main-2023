package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.OpenCV.AprilTagDetectionPipeline;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;

@Autonomous
public class BlueTerminalScoring extends LinearOpMode
{
    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;

    static final double FEET_PER_METER = 3.28084;

    double fx = 578.272;
    double fy = 578.272;
    double cx = 402.145;
    double cy = 221.506;

    // UNITS ARE METERS
    double tagsize = 0.166;

    //Tag IDs of sleeve
    int Left = 2;
    int Middle = 4;
    int Right = 6;

    AprilTagDetection tagOfInterest = null;

    @Override
    public void runOpMode() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);
        camera.setPipeline(aprilTagDetectionPipeline);

        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(800, 448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        telemetry.setMsTransmissionInterval(50);

        while (!isStarted() && !isStopRequested()) {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if (currentDetections.size() != 0) {
                boolean tagFound = false;

                for (AprilTagDetection tag : currentDetections) {
                    if (tag.id == Left || tag.id == Middle || tag.id == Right) {
                        tagOfInterest = tag;
                        tagFound = true;
                        break;
                    }
                }

                if (tagFound) {
                    telemetry.addLine("Tag of interest is in sight!\n\nLocation data:");
                    tagToTelemetry(tagOfInterest);
                } else {
                    telemetry.addLine("Don't see tag of interest :(");

                    if (tagOfInterest == null) {
                        telemetry.addLine("(The tag has never been seen)");
                    } else {
                        telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                        tagToTelemetry(tagOfInterest);
                    }
                }

            } else {
                telemetry.addLine("Don't see tag of interest :(");

                if (tagOfInterest == null) {
                    telemetry.addLine("(The tag has never been seen)");
                } else {
                    telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                    tagToTelemetry(tagOfInterest);
                }

            }

            telemetry.update();
            sleep(20);
        }

        if (tagOfInterest != null) {
            telemetry.addLine("Tag snapshot:\n");
            tagToTelemetry(tagOfInterest);
            telemetry.update();
        } else {
            telemetry.addLine("No tag snapshot available, it was never sighted during the init loop :(");
            telemetry.update();
        }
        RobotEncoded robotencoded = new RobotEncoded(hardwareMap, telemetry);

        if (tagOfInterest == null || tagOfInterest.id == Left) {
            robotencoded.closeClaw();

            robotencoded.forward(1,900);

            robotencoded.strafeRight(3,900);

            robotencoded.forward(25,1200);

            robotencoded.strafeLeft(14.5,900);

            robotencoded.forward(4,900);

            robotencoded.setSlidePosition(900, Constants.MJ);

            robotencoded.forward(2,900);
            sleep(2000); // wait until the arm stops shaking midair

            robotencoded.stopBot();
            robotencoded.openClaw();
            sleep(1000);

            robotencoded.backward(5,900);

            robotencoded.closeClaw();

            robotencoded.setSlidePosition(900,Constants.LJ);

            robotencoded.strafeLeft(14,900);

            robotencoded.setSlidePosition(900,Constants.GJ);

        }
        else if(tagOfInterest.id == Middle) {
            robotencoded.closeClaw();

            robotencoded.forward(1,900);

            robotencoded.strafeRight(4,900);

            robotencoded.forward(25,1200);

            robotencoded.strafeLeft(14.5,900);

            robotencoded.forward(4,900);

            robotencoded.setSlidePosition(900,Constants.MJ);

            robotencoded.forward(2,900);
            robotencoded.closeClaw();
            sleep(2000); // wait until the arm stops shaking midair

            robotencoded.stopBot();
            robotencoded.openClaw();
            sleep(1000);

            robotencoded.backward(5,900);

            robotencoded.closeClaw();

            robotencoded.setSlidePosition(900,Constants.LJ);

            robotencoded.strafeRight(12,900);

            robotencoded.setSlidePosition(900,Constants.GJ);

        }
        else if(tagOfInterest.id == Right) {
            robotencoded.closeClaw();

            robotencoded.forward(1,900);

            robotencoded.strafeRight(4,900);

            robotencoded.forward(25,1150);

            robotencoded.strafeLeft(14.5,900);

            robotencoded.forward(3,900);

            robotencoded.setSlidePosition(900,Constants.MJ);

            robotencoded.forward(2,900);
            robotencoded.closeClaw();
            sleep(2000); // wait until the arm stops shaking midair

            robotencoded.stopBot();
            robotencoded.openClaw();
            sleep(1000);

            robotencoded.backward(4,900);

            robotencoded.closeClaw();

            robotencoded.setSlidePosition(900,Constants.LJ);

            robotencoded.strafeRight(42,900);

            robotencoded.setSlidePosition(900,Constants.GJ);

        }
        while (opModeIsActive()) {sleep(20);}
    }
     //robotencoded.forward(28,850);
//
////        robot.turnPID(90);
//        robotencoded.turnRight(22,800); //turn 90 degrees
//
//        robotencoded.forward(18,850);
//
//        robotencoded.setSlidePosition(850,6);
//        sleep(1000);
//
//        robotencoded.forward(3,800);
//        robotencoded.openClaw();
//        sleep(1000);
//        robotencoded.closeClaw();
//        sleep(1000);
//
//        robotencoded.setSlidePosition(1000, Constants.LJ);
//
//        robotencoded.backward(12,850);
//
////        robot.turnPID(90);
//        robotencoded.turnRight(22,800);
//
//        robotencoded.forward(3,850);
//
//        robotencoded.openClaw();
//        robotencoded.stopBot();
//        sleep(1000);

    void tagToTelemetry(AprilTagDetection detection)
    {
        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
        telemetry.addLine(String.format("Translation X: %.2f feet", detection.pose.x*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Y: %.2f feet", detection.pose.y*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Z: %.2f feet", detection.pose.z*FEET_PER_METER));
        telemetry.addLine(String.format("Rotation Yaw: %.2f degrees", Math.toDegrees(detection.pose.yaw)));
        telemetry.addLine(String.format("Rotation Pitch: %.2f degrees", Math.toDegrees(detection.pose.pitch)));
        telemetry.addLine(String.format("Rotation Roll: %.2f degrees", Math.toDegrees(detection.pose.roll)));
    }
}