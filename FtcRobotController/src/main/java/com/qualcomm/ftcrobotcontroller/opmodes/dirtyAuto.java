package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * dirty autonomous
 *
 * go forward 5 sec, spin 25.
 */
public class dirtyAuto extends OpMode {

    DcMotor motorL;
    DcMotor motorR;
    double powerL;
    double powerR;
    Servo arm;
    public dirtyAuto() {
    }

    public void init() {
        motorL = hardwareMap.dcMotor.get("motorL"); //map motors
        motorR = hardwareMap.dcMotor.get("motorR");
        arm = hardwareMap.servo.get("arm");
    }

    public void loop() {
        telemetry.addData("THIS MACHINE KILLS FASCISTS", "dirtyauto 0.1");

        if(this.time <= 5){
            motorL.setPower(-1);
            motorR.setPower(-1);
            arm.setPosition(0.5);
        }

        if(this.time > 5){
            motorR.setPower(1);
            arm.setPosition(0.5);
        }
    }
}