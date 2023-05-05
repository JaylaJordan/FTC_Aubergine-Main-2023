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
public class Blue_RED extends LinearOpMode
{
    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;

    static final double FEET_PER_METER = 3.28084;

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
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

        /* Update the telemetry */
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
            waitForStart();

            robotencoded.closeClaw();
            robotencoded.forward(2,1100);
            sleep(100);
            robotencoded.strafeRight(21,1000);
            sleep(100);
            robotencoded.forward(22,1100);
            sleep(100);
            robotencoded.strafeLeft(12.5,1000);
            sleep(100);
            robotencoded.setSlidePosition(1500,Constants.MJ);
            sleep(100);
            robotencoded.forward(6,1100);
            sleep(800);
            robotencoded.openClaw();
            sleep(800);
            robotencoded.backward(8,1100);
            sleep(100);
            robotencoded.strafeRight(12,1000);
            sleep(100);
            robotencoded.forward(26,1000);
            sleep(100);
            robotencoded.turnLeft(19,900);
            sleep(100);
            robotencoded.openClaw();
            sleep(100);
            robotencoded.setSlidePosition(1500,5.5);
            sleep(100);
            robotencoded.forward(45.5,1100);
            sleep(300);
            robotencoded.closeClaw();
            sleep(500);
            robotencoded.setSlidePosition(1500,Constants.MJ);
            sleep(100);
            robotencoded.backward(38,1100);
            sleep(100);
            robotencoded.turnLeft(19,900);
            sleep(100);
            robotencoded.forward(5,1100);
            sleep(800);
            robotencoded.openClaw();
            sleep(800);
            robotencoded.backward(6,1100);
            sleep(100);
            robotencoded.strafeRight(36,1100);
            sleep(100);
            robotencoded.setSlidePosition(1400,Constants.GJ);

        }
        else if(tagOfInterest.id == Middle) {
            waitForStart();
            robotencoded.closeClaw();
            robotencoded.forward(2,1100);
            sleep(100);
            robotencoded.strafeRight(21,1000);
            sleep(100);
            robotencoded.forward(22,1100);
            sleep(100);
            robotencoded.strafeLeft(12.5,1000);
            sleep(100);
            robotencoded.setSlidePosition(1500,Constants.MJ);
            sleep(100);
            robotencoded.forward(6,1100);
            sleep(600);
            robotencoded.openClaw();
            sleep(600);
            robotencoded.backward(8,1100);
            sleep(100);
            robotencoded.strafeRight(12,1000);
            sleep(100);
            robotencoded.forward(26,1000);
            sleep(100);
            robotencoded.turnLeft(19,900);
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
            robotencoded.turnLeft(19,900);
            sleep(100);
            robotencoded.forward(5,1100);
            sleep(600);
            robotencoded.openClaw();
            sleep(600);
            robotencoded.backward(6,1100);
            sleep(100);
            robotencoded.strafeRight(12,1100);
            sleep(100);
            robotencoded.setSlidePosition(1400,Constants.GJ);


        }
        else if(tagOfInterest.id == Right) {
            waitForStart();

            robotencoded.closeClaw();
            robotencoded.forward(2,1100);
            sleep(100);
            robotencoded.strafeRight(21,1000);
            sleep(100);
            robotencoded.forward(22,1100);
            sleep(100);
            robotencoded.strafeLeft(12.5,1000);
            sleep(100);
            robotencoded.setSlidePosition(1500,Constants.MJ);
            sleep(100);
            robotencoded.forward(6,1100);
            sleep(600);
            robotencoded.openClaw();
            sleep(600);
            robotencoded.backward(8,1100);
            sleep(100);
            robotencoded.strafeRight(12,1000);
            sleep(100);
            robotencoded.forward(26,1000);
            sleep(100);
            robotencoded.turnLeft(19,900);
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
            robotencoded.turnLeft(19,900);
            sleep(100);
            robotencoded.forward(5,1100);
            sleep(600);
            robotencoded.openClaw();
            sleep(600);
            robotencoded.backward(6,1100);
            sleep(100);
            robotencoded.strafeLeft(14,1100);
            sleep(100);
            robotencoded.setSlidePosition(1400,Constants.GJ);
        }

        /* You wouldn't have this in your autonomous, this is just to prevent the sample from ending */
        while (opModeIsActive()) {sleep(20);}
    }

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

//
//
//                if (opModeIsActive()) {
//                    telemetry.addData("front right", robotencoded.frontRight.getPower());
//                    telemetry.addData("front left", robotencoded.frontLeft.getPower());
//                    telemetry.addData("back right", robotencoded.backRight.getPower());
//                    telemetry.addData("back left", robotencoded.backLeft.getPower());
//                    telemetry.update();
//                }
//            }
//        }
//    }
}