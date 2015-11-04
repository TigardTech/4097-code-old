/*
 * an official 4097 train wreck
 *
 * created 10/15/15 by Justin Lemke
 */

/*
 * basicDrive - derives from test.java
 *
 * attain fine control over left and right treads using respective thumbstick's analog inputs
 * go forward, go back, basically.
 */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class basicDrive extends OpMode {

    DcMotor motorL; //front-left drive motor
    DcMotor motorR; //front-right drive motor
    double powerL; // motor power for motorL
    double powerR; // motor power for motorR
    short mode = 0; // this is our mode
    // 0 is fine, 1 is coarse, 2 is analog on the thumbsticks

    /*
    constructor
     */
    public basicDrive() {

    }

    public void init() { //init code for the robot controller
        motorL = hardwareMap.dcMotor.get("motorL"); //map left motor
        motorR = hardwareMap.dcMotor.get("motorR"); //ditto right
        powerL = 0; // force motor power to 0
        powerR = 0; // ditto
        // gamepad1.setJoystickDeadzone(0);
        // above lies the joystick deadzone setup code.
        // it's great, they did the work for me.
    }

    public void loop() {
        // setup for 3-mode system
        if(gamepad1.start){
            if(mode == 0){
                mode = 1;
            }
            else if(mode == 1){
                mode = 2;
            }
            else{
                mode = 0;
            }
        }

        /*
         * button-based control mapping
         * right motor controlled via buttons
         * left controlled via d-pad
         * RIGHT
         * A -- inc. power
         * B -- dec. power
         * X -- full stop
         * LEFT
         * down -- inc
         * right -- dec
         * left -- stop
         *
         * fun stuff, amirite?
         */

        if(mode == 0) { // fine mode
            telemetry.addData("mode", "set to FINE");
            if (gamepad1.a) {
                powerR += 0.1;
            }
            if (gamepad1.b) {
                powerR -= 0.1;
            }
            if (gamepad1.x) {
                powerR = 0;
            }
            if (gamepad1.dpad_down) {
                powerL += 0.1;
            }
            if (gamepad1.dpad_right) {
                powerL -= 0.1;
            }
            if (gamepad1.dpad_left) {
                powerL = 0;
            }
        }

        if(mode == 1) { // coarse mode
            telemetry.addData("mode", "set to COARSE");
            if (gamepad1.a) {
                powerR = 1;
            }
            if (gamepad1.b) {
                powerR = -1;
            }
            if (gamepad1.x) {
                powerR = 0;
            }
            if (gamepad1.dpad_down) {
                powerL = 1;
            }
            if (gamepad1.dpad_right) {
                powerL -= -1;
            }
            if (gamepad1.dpad_left) {
                powerL = 0;
            }
        }

		/*  
		 *  stick is measured from -1 to +1 on whichever axis is being manipulated.
		 *  in our case, we're measuring either stick's y axis, they're referred to as
		 *  "gamepad1.left_stick_y" and "gamepad1.right_stick_y" in the code below.
		 *  +1 is the top of an axis (as far up as you can push it on the Y) and -1 is
		 *  the bottom. for the x axis, the rightmost you can push it is +1, and left is
		 *  -1. more on this -1 to +1 system can be found in various FTC docs available to
		 *  you.
		 */
        if(mode == 2) { // analog mode -- this is where things stop working.
            telemetry.addData("mode", "set to ANALOG");
                // the above basically checks if the stick's moved from the middle
                powerL = gamepad1.left_stick_y; // real complex. set the stick's position to the power level
                powerR = gamepad1.right_stick_y;
        }

        if (powerR >= -1 && powerR <= 1) { // power check, set power for right
            motorR.setPower(powerR); // -1 to 1
        }
        if (powerL >= -1 && powerL <=1) { //ditto, left.
            motorL.setPower(powerL); // -1 to 1
        }

        telemetry.addData("left", powerL);
        telemetry.addData("right", powerR);
    }

}