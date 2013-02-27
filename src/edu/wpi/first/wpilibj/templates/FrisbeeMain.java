/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Compressor;
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
        //NOTHING
    }

    public void autonomous() {
        
    }
    
    public void runRDrive(FrisbeeParts q) {
        q.RDrive.set(q.joy1.getAxis(Joystick.AxisType.kY));
    }
    
    public void runLDrive(FrisbeeParts q) {
        q.LDrive.set(q.joy1.getAxis(Joystick.AxisType.kY));
    }
    
    public void runShooter1(FrisbeeParts q) {
        q.Shoot1.set(q.joy1.getRawButton(1) ? 0.6 : 0);
    }
    public void runShooter2(FrisbeeParts q) {
        q.Shoot2.set(q.joy1.getRawButton(1) ? 0.4 : 0);
    }
    
    public void runDropper(FrisbeeParts q) {
        q.Dropper.set(q.joy1.getRawButton(3) ? 0.5 : 0);
    }
    
//    public void runLauncher(FrisbeeParts q) {
//        q.s1.set(q.joy1.getRawButton(4));
//                
//    }
//    
//    public void offlauncher(FrisbeeParts q) {
//        q.s2.set(q.joy1.getRawButton(5));
//    }

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
//            if (airCompressor == null) {
//                airCompressor = new Compressor(3, 1);
//                airCompressor.start();
//            }
            
//            setOfParts.Comp.start();
            setOfParts.runHopper();
            runLDrive(setOfParts);
            runRDrive(setOfParts);
            runDropper(setOfParts);
            runShooter1(setOfParts);
            runShooter2(setOfParts);
//            runLauncher(setOfParts);
//            runGyro(setOfParts);
            
            Timer.delay(0.05);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
