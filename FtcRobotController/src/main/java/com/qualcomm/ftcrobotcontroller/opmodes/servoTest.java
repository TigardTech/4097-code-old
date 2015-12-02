package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * an official 4097 train wreck
 * Created by Justin Lemke
 */

/**
 * servoTest:
 * make the servo spin-doo the way I want it to.
 */
public class servoTest extends OpMode {

    float servo_pos;
    Servo test; //flippy doo test thing

    public servoTest() {
    }

    public void init() {
        test = hardwareMap.servo.get("test");
    }

    public void loop() {
        if(gamepad1.dpad_left) {
            test.setPosition(0);
        }
        if(gamepad1.dpad_up) {
            test.setPosition(0.5);
        }
        if(gamepad1.dpad_right) {
            test.setPosition(1);
        }
        telemetry.addData("servo pos", test.getPosition());
    }
}