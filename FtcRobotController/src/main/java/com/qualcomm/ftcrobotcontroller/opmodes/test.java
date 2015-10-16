/*
 * an official 4097 train wreck
 *
 * created 10/15/15 by Justin Lemke
 */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class test extends OpMode {

    DcMotor testMotor;
    double power;
    /*
    constructor
     */
    public test() {

    }

    public void init() {
        testMotor = hardwareMap.dcMotor.get("testMotor");
        power=0;
    }

    public void loop() {
        telemetry.addData("Text", "If you're reading this, it's too late.");
        if(gamepad1.a) {
            power += 0.1;
        }
        if(gamepad1.b) {
            power -= 0.1;
        }
        if(power > -1 && power < 1) {
            testMotor.setPower(power);
        }
        telemetry.addData("powervalue", power);
    }
}
