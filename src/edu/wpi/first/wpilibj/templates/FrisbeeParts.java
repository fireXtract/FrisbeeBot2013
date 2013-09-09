/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Teacher
 */
public class FrisbeeParts extends SimpleRobot {

    private final static int RFDriveP = 3;
    private final static int RBDriveP = 2;
    private final static int LFDriveP = 1;
    private final static int LBDriveP = 4;
    private final static int BShootP = 6;
    private final static int FShootP = 5;
    private final static int DropperP = 7;
    public Talon ShootFront,
            ShootBack,
            Dropper, LFDrive, LBDrive, RFDrive, RBDrive;
    public RobotDrive drive;
    public Solenoid lU, lD, cU1, cD1;
    public Compressor airComp;
    public Joystick joy1;
    public Joystick joy2;
    public DriverStationLCD textOutput;
    private static FrisbeeParts partInst;

    public FrisbeeParts() {

        drive = new RobotDrive(LFDriveP, LBDriveP, RFDriveP, RBDriveP);
        ShootFront = new Talon(FShootP);


        ShootBack = new Talon(BShootP);
        Dropper = new Talon(DropperP);

        textOutput = DriverStationLCD.getInstance();

        airComp = new Compressor(1, 1);
        lD = new Solenoid(3);
        lU = new Solenoid(4);
        cU1 = new Solenoid(1);
        cD1 = new Solenoid(2);

        joy1 = new Joystick(1);
        joy2 = new Joystick(2);
    }
//    public static FrisbeeParts getInstance() {
//        if (partInst == null) //if partInst doesnt exist make it!!
//        {
//            partInst = new FrisbeeParts();
//        }
//        return partInst;
//    }
}
