package com.example.meepmeeptesting;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

    public class MeepMeepTesting {
        public void main(String[] args) {
            MeepMeep meepMeep = new MeepMeep(800);

            RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    .setConstraints(40, 40, 5.200001174797067, 4.037147621792714, 12.95)
                    .followTrajectorySequence(drive ->
                            drive.trajectorySequenceBuilder(new Pose2d(0, 0, 0))
                                    .forward(30)
                                    .turn(Math.toRadians(90))
                                    .forward(30)
                                    .turn(Math.toRadians(90))
                                    .forward(30)
                                    .turn(Math.toRadians(90))
                                    .forward(30)
                                    .turn(Math.toRadians(90))
                                    .build()
                    );

            meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                    .setDarkMode(true)
                    .setBackgroundAlpha(0.95f)
                    .addEntity(myBot)
                    .start();
        }
    }
}