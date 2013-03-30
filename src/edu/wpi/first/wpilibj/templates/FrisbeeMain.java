/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
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
    public FrisbeeMain() {
        FrisbeeParts.getInstance().airComp.start();
    }

    protected void disabled() {
        getWatchdog().setEnabled(false);
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        while (isAutonomous() && isEnabled()) {
            FrisbeeParts s = FrisbeeParts.getInstance();
            s.cU1.set(true);
            s.cD1.set(false);
            Timer.delay(12.7);
            s.ShootFront.set(1);
            s.ShootBack.set(.8);
            s.lD.set(true);
            s.lU.set(false);
            Timer.delay(2);
            s.lD.set(false);
            s.lU.set(true);
            Timer.delay(.15);
            s.lD.set(true);
            s.lU.set(false);
            Timer.delay(.15);
            s.lU.set(false);
            s.lD.set(false);
            s.ShootFront.set(0);
            s.ShootBack.set(0);
            Timer.delay(0);
        }
    }

    public void DriveMec(FrisbeeParts q) {
        q.drive.tankDrive(q.joy1, q.joy2);
    }

    public void runShooter1(FrisbeeParts q) {
        q.ShootFront.set(q.joy1.getRawButton(1) ? 1 : 0);
    }

    public void runShooter2(FrisbeeParts q) {
        q.ShootBack.set(q.joy1.getRawButton(1) ? 1 : 0);
    }

    public void runDropper(FrisbeeParts q) {
        q.Dropper.set(q.joy1.getRawButton(2) ? 0.5 : 0);
    }

    public void runLauncher(FrisbeeParts q) {
        if (q.joy1.getRawButton(3)) {
            q.lU.set(true);
            q.lD.set(false);
        } else {
            q.lU.set(false);
            q.lD.set(true);
        }
    }

    public void climbMechU(FrisbeeParts q) {
        if (q.joy1.getRawButton(4)) {
            q.cD1.set(false);
            q.cU1.set(true);
        }
    }

    public void climbMechD(FrisbeeParts q) {
        if (q.joy1.getRawButton(5)) {
            q.cU1.set(false);
            q.cD1.set(true);
        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        System.out.println("Affirmative, Dave. I read you.");
        while (isOperatorControl() && isEnabled()) {
            FrisbeeParts setOfParts = FrisbeeParts.getInstance();

            DriveMec(setOfParts);

            runDropper(setOfParts);

            runShooter1(setOfParts);
            runShooter2(setOfParts);

            runLauncher(setOfParts);

            climbMechU(setOfParts);
            climbMechD(setOfParts);

            Timer.delay(0.05);
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    }
}