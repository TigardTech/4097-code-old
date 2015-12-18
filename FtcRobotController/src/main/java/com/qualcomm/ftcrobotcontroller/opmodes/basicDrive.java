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

//import com.qualcomm.ftccommon.DbgLog;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class basicDrive extends OpMode {

    DcMotor motorL; //front-left drive motor
    DcMotor motorR; //front-right drive motor
    DcMotor motor1; // arm winch
    DcMotor motor2; // other motor on the arm mech
    //Servo arm; // front-facing arm servo.
    double powerL; // motor power for motorL
    double powerR; // motor power for motorR
    double servopos = 0;
    double righttrigger = 0;
    double lefttrigger = 0;
    double motor1pwr = 0;
    double motor2pwr = 0;

    /*
    constructor
     */
    public basicDrive() {

    }

    public void init() { //init code for the robot controller
        motorL = hardwareMap.dcMotor.get("motorL"); //map left motor
        motorR = hardwareMap.dcMotor.get("motorR"); //ditto right
        motor1 = hardwareMap.dcMotor.get("motor1"); //map winch motor
        motor2 = hardwareMap.dcMotor.get("motor2"); // map another thing
        powerL = 0; // force motor power to 0
        powerR = 0; // ditto
        motor2pwr = 0;
        motor1pwr = 0;
        // gamepad1.setJoystickDeadzone(0);
        // above lies the joystick deadzone setup code.
        // it's great, they did the work for me.
    }

    public void loop() {
		/*
		 *  stick is measured from -1 to +1 on whichever axis is being manipulated.
		 *  in our case, we're measuring either stick's y axis, they're referred to as
		 *  "gamepad1.left_stick_y" and "gamepad1.right_stick_y" in the code below.
		 *  +1 is the top of an axis (as far up as you can push it on the Y) and -1 is
		 *  the bottom. for the x axis, the rightmost you can push it is +1, and left is
		 *  -1. more on this -1 to +1 system can be found in various FTC docs available to
		 *  you.
		 */

        //front motors
        powerL = gamepad1.left_stick_y; // real complex. set the stick's position to the power level
        powerR = gamepad1.right_stick_y;
        motor1pwr = gamepad2.left_stick_y; // real complex. set the stick's position to the power level
        motor2pwr = gamepad2.right_stick_y;


        if (powerR >= -1 && powerR <= 1) { // power check, set power for right
            motorR.setPower(powerR); // -1 to 1
        }
        if (powerL >= -1 && powerL <=1) { //ditto, left.
            motorL.setPower(powerL); // -1 to 1
        }
        if (motor1pwr >= -1 && motor1pwr <= 1) { // power check, set power for right
            motor1.setPower(motor1pwr); // -1 to 1
        }
        if (motor2pwr >= -1 && motor2pwr <= 1) {
            motor2.setPower(motor2pwr); // spininign
        }

        // servo controls
        // triggers

        /*
        if(gamepad1.left_trigger > 0.1 ) { // check if the trigger is active
            lefttrigger = gamepad1.left_trigger / 2; //divide trigger's value by 2
            servopos = lefttrigger + 0.5; // the servo position is 0.5 + the value of the trigger
            //DbgLog.msg("left trigger " + servopos);
        }
        else if(gamepad1.right_trigger > 0.1) { //if the left trigger isn't active, check if the right is
            righttrigger = gamepad1.right_trigger / 2; //divide by 2
            servopos = 0.5 - righttrigger; // servopos = 0.5 - trigger value
            //DbgLog.msg("right trigger " + servopos);
            //DbgLog.msg("rt value " + gamepad1.right_trigger);
        }
        else { //if nothing's being pressed, idle in the center
            servopos = 0.5; //center at 0.5
            //DbgLog.msg("idle " + servopos);
        }
        if(servopos >= 0 && servopos <= 1){ //safety check, ensure we DO NOT break the boundary of our servo by limiting it to between 0 and 1
            arm.setPosition(servopos); // actually set our robot's position
        }
        */

        //winch controls

        //output telemetry data
        telemetry.addData("left", powerL);
        telemetry.addData("right", powerR);
        telemetry.addData("one", motor1pwr);
        telemetry.addData("two", motor2pwr);
        //telemetry.addData("servo pos", arm.getPosition());
    }

}