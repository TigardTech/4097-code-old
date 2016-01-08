package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.ftccommon.DbgLog;

/**
 * dirty autonomous
 *
 * go forward 5 sec, spin 25.
 */
public class dirtyAuto extends OpMode {

    DcMotor motorL;
    DcMotor motorR;

    Servo arm;
    public dirtyAuto() {
    }

    public void init() {
        motorL = hardwareMap.dcMotor.get("motorL"); //map motors
        motorR = hardwareMap.dcMotor.get("motorR");
        DbgLog.msg("init phase");
    }

    public void loop() {
        telemetry.addData("DEBRIS DUNKER", "dirtyauto 0.2");
        telemetry.addData("current time", this.time);
        if(this.time <= 8){
            DbgLog.msg("entered phase one");
            motorL.setPower(1);
            motorR.setPower(1);
            //arm.setPosition(0.5);
            telemetry.addData("PHASE", "ONE, REVERSE");
        }

        if(this.time > 8){
            DbgLog.msg("entered phase two");
            motorR.setPower(0);
            motorL.setPower(0);
            //arm.setPosition(0.5);
            telemetry.addData("PHASE", "TWO, LOCK STOP");
        }
    }
}