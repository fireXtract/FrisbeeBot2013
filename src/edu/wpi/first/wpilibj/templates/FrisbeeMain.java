/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class FrisbeeMain extends SimpleRobot {
//    public Compressor airCompressor = null; 

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void robotInit() {
        FrisbeeParts.getInstance();
    }

    protected void disabled() {
        stop();
        getWatchdog().setEnabled(false);
    }

    public void stop() {
        FrisbeeParts setOfParts = FrisbeeParts.getInstance();
//        setOfParts.airComp.stop();
    }

    public void autonomous() {
    }

    public void runRFDrive(FrisbeeParts q) {
        q.RFDrive.set(q.joy1.getAxis(Joystick.AxisType.kY) * -1);
    }

    public void runRBDrive(FrisbeeParts q) {
        q.RBDrive.set(q.joy1.getAxis(Joystick.AxisType.kY) * -1);
    }

    public void runLFDrive(FrisbeeParts q) {
        q.LFDrive.set(q.joy2.getAxis(Joystick.AxisType.kY) * -1);
    }

    public void runLBDrive(FrisbeeParts q) {
        q.LBDrive.set(q.joy2.getAxis(Joystick.AxisType.kY) * -1);
    }

    public void runShooter1(FrisbeeParts q) {
        q.Shoot1.set(q.joy1.getRawButton(1) ? -1 : 0);
    }

    public void runShooter2(FrisbeeParts q) {
        q.Shoot2.set(q.joy1.getRawButton(1) ? -0.8 : 0);
    }

    public void runDropper(FrisbeeParts q) {
        q.Dropper.set(q.joy1.getRawButton(3) ? 0.5 : 0);
    }

    public void runLauncher(FrisbeeParts q) {
        q.sU.set(false);
        q.sD.set(false);
        if (q.joy1.getRawButton(4)) {
            System.out.println("WORKSOFARb3");
            q.sU.set(true);
            Timer.delay(0.2);
            q.sU.set(false);
            q.sD.set(true);
            Timer.delay(0.1);
            q.sD.set(false);
        }
    }

    public boolean checkStartComp(FrisbeeParts q) {
        if (q.IOComp = true) {  //Check your pressure here.  If it is too low, return true, else return false.  True will eventually turn on the comp and false will turn it off.
            q.airComp.start();
            return true;
        } else {
            q.airComp.stop();
            return false;
        }
    }

    public void OtoggleComp(FrisbeeParts q) {
        if (q.joy1.getRawButton(10) == true) {
            q.IOComp = false;
            System.out.println(q.IOComp);

        }
    }

    public void ItoggleComp(FrisbeeParts q) {
        if (q.joy1.getRawButton(11) == true) {
            q.IOComp = true;
            System.out.println(q.IOComp);
        }
    }
    
    public void UserMessages(FrisbeeParts q) {
        q.textOutput.println(DriverStationLCD.Line.kUser1, 1, "Compressor: " + q.IOComp);
        q.textOutput.println(DriverStationLCD.Line.kUser2, 2, "Solenoid Up: " + q.sU);
        q.textOutput.println(DriverStationLCD.Line.kUser3, 3, "Solenoid Dn: " + q.sD);
        q.textOutput.updateLCD();
    }


    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {

            FrisbeeParts setOfParts = FrisbeeParts.getInstance();

            /*
             * This is how you declare a compressor.  It is not part of the
             * FrisbeeParts option.
             * You need to specify the correct pressureSwitchChannel and
             * compressorRelayChannel.  I am not sure what these are.
             */
//            System.out.println("WORKSOFARb4");
//            if (checkStartComp()) {
//                startComp(setOfParts);
//            } else {
//                stopComp(setOfParts);
//            }

//            System.out.println("WORKSOFARb5");
//            setOfParts.runHopper();
            runLFDrive(setOfParts);
            runLBDrive(setOfParts);
            runRFDrive(setOfParts);
            runRBDrive(setOfParts);
            runDropper(setOfParts);
            runShooter1(setOfParts);
            runShooter2(setOfParts);
//            System.out.println("WORKSOFARb6");
            runLauncher(setOfParts);
//            System.out.println("WORKSOFARb7");
//            runGyro(setOfParts);
            ItoggleComp(setOfParts);
            OtoggleComp(setOfParts);
            checkStartComp(setOfParts);
            UserMessages(setOfParts);

            Timer.delay(0.05);
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    }
}
