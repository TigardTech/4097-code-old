/*
 * an official 4097 train wreck
 *
 * created 10/15/15 by Justin Lemke
 */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class test extends OpMode {

    DcMotor myMotor; //declares we have motor, name it testMotor
    double power; //declares we have a double -- we use this for power (wow)
    short mode = 0; // this is our mode
    // 0 is fine, 1 is coarse

    /*
    constructor
     */
    public test() {

    }

    public void init() { //init code for the robot controller
        myMotor = hardwareMap.dcMotor.get("testMotor");
        power = 0;
    }

    public void loop() {
        if(gamepad1.start){
            if(mode == 1){
                mode = 0;
            }
            else{
                mode = 1;
            }
        }

        if(mode == 0) { // fine mode
            telemetry.addData("mode", "set to FINE");
            if (gamepad1.a) {
                power += 0.1;
            }
            if (gamepad1.b) {
                power -= 0.1;
            }
            if (gamepad1.x) {
                power = 0;
            }
        }

        if(mode == 1) { // coarse mode
            telemetry.addData("mode", "set to COARSE");
            if(gamepad1.a){
                power = 1;
            }
            if(gamepad1.b){
                power = -1;
            }
            if(gamepad1.x){
                power = 0;
            }
        }

        if (power >= -1 && power <= 1) {
            myMotor.setPower(power); // -1 to 1
        }

        telemetry.addData("powervalue", power);
    }

}