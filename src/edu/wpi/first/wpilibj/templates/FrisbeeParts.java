/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Teacher
 */
public class FrisbeeParts {

    private final static int LFDriveP = 1;
    private final static int LBDriveP = 2;
    private final static int RFDriveP = 3;
    private final static int RBDriveP = 4;
    private final static int FShootP = 6;
    private final static int BShootP = 5;
    private final static int DropperP = 7;
    public Talon LFDrive;
    public Talon LBDrive;
    public Talon RFDrive;
    public Talon RBDrive;
    public Talon ShootFront;
    public Talon ShootBack;
    public Talon Dropper;
    public Solenoid lU, lD, cU1, cU2, cD1, cD2;
    public Compressor airComp;
    public Joystick joy1;
    public Joystick joy2;
    public DriverStationLCD textOutput;
    private static FrisbeeParts partInst;

    public FrisbeeParts() {
        LFDrive = new Talon(LFDriveP);
        LBDrive = new Talon(LBDriveP);
        RFDrive = new Talon(RFDriveP);
        RBDrive = new Talon(RBDriveP);


        ShootFront = new Talon(FShootP);
        ShootBack = new Talon(BShootP);
        Dropper = new Talon(DropperP);


        textOutput = DriverStationLCD.getInstance();

        airComp = new Compressor(1, 1);
        lD = new Solenoid(1);
        lU = new Solenoid(2);
        cU1 = new Solenoid(3);
        cU2 = new Solenoid(5); //front climb
        cD1 = new Solenoid(4);
        cD2 = new Solenoid(6); //front climb

        joy1 = new Joystick(1);
        joy2 = new Joystick(2);
    }

    public static FrisbeeParts getInstance() {
        if (partInst == null) //if partInst doesnt exist make it!!
        {
            partInst = new FrisbeeParts();
        }
        return partInst;
    }
}
