/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class FrisbeeMain extends FrisbeeParts {

    boolean fireMode = true;

    public FrisbeeMain() {
        airComp.start();
    }

    public void stop() {
        airComp.stop();
    }

    protected void disabled() {
        getWatchdog().setEnabled(false);
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        int count = 0;

        while (isAutonomous() && isEnabled()) {
            System.out.println("Lalala " + count);

            if (count <= 160) {
                cU1.set(true);
                cD1.set(false);
                cD1.set(true);
            }
            //Timer.delay(8);

            if (count > 160 && count <= 200) {
                System.out.println("AUTOFIX");
                ShootFront.set(1);
                ShootBack.set(.8);
                lD.set(true);
                lU.set(false);
            }
            //Timer.delay(2);
            if (count > 200 && count <= 203) {
                System.out.println("AUTOFIxX");
                lD.set(false);
                lU.set(true);
            }
            //Timer.delay(.15);
            if (count > 203 && count <= 206) {
                System.out.println("AUTOFIxxX");
                lD.set(true);
                lU.set(false);
            }
            //Timer.delay(.15);
            if (count > 206) { //&& count <= 212) {
//                Dropper.set(.5);
                lU.set(false);
                lD.set(false);
                ShootFront.set(0);
                ShootBack.set(0);

                //Timer.delay(4);
            }

            count++;
            Timer.delay(0.05);
        }
    }

    public void driveMec(FrisbeeParts q) {
//        q.drive.tankDrive(q.joy1.getAxis(Joystick.AxisType.kY), q.joy2.getAxis(Joystick.AxisType.kY));

        if (q.joy1.getRawButton(8)) {
            fireMode = true;
        } else if (q.joy1.getRawButton(9)) {
            fireMode = false;
        }
        if (fireMode == true) {
            q.drive.mecanumDrive_Cartesian((q.joy1.getY() * -1), q.joy1.getX(), q.joy2.getY(), 0); // Mechanam wheel rollers should form an x when looking directaly down from the top
        }

//        \\\1     2///
//        
//        
//        
//        ///3     4\\\
    }

    public void runShooter1(FrisbeeParts q) {
        q.ShootFront.set(q.joy1.getRawButton(1) ? q.joy1.getZ() : 0);
    }

    public void runShooter2(FrisbeeParts q) {
        q.ShootBack.set(q.joy1.getRawButton(1) ? q.joy1.getZ() : 0);
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


            driveMec(this);

            runDropper(this);

            runShooter1(this);
            runShooter2(this);

            runLauncher(this);

            climbMechU(this);
            climbMechD(this);

            Timer.delay(0.05);
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    }
}