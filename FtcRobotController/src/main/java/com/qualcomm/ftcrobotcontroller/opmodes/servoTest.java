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
 * NOTE:
 * fixed for our normal config on 12-5-15
 */
public class servoTest extends OpMode {

    float servo_pos;
    Servo arm; //flippy doo test thing

    public servoTest() {
    }

    public void init() {
        arm = hardwareMap.servo.get("arm");
    } // map servo

    public void loop() {
        if(gamepad1.dpad_left) {
            arm.setPosition(0);
        }
        if(gamepad1.dpad_up) {
            arm.setPosition(0.5);
        }
        if(gamepad1.dpad_right) {
            arm.setPosition(1);
        }
        if(gamepad1.right_trigger <= 1) {
            arm.setPosition(gamepad1.right_trigger);
        }
        telemetry.addData("servo pos", arm.getPosition());
    }
}