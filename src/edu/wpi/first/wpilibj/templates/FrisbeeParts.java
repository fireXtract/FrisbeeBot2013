/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Teacher
 */
public class FrisbeeParts {

    private final static int LDriveP = 2;
    private final static int RDriveP = 1;
    private final static int FShootP = 6;
    private final static int BShootP = 5;
    private final static int DropperP = 7;
    public Jaguar LDrive;
    public Jaguar RDrive;
    public Jaguar Shoot1;
    public Jaguar Shoot2;
    public Jaguar Dropper;
//    public Relay Spike;
//    public Solenoid s1, s2;
//    public DriverStationLCD textOut;
    public Joystick joy1;
    public Joystick joy2;
    private static FrisbeeParts partInst;

    public FrisbeeParts() {
        LDrive = new Jaguar(LDriveP);
        RDrive = new Jaguar(RDriveP);
        Shoot1 = new Jaguar(FShootP);
        Shoot2 = new Jaguar(BShootP);
        Dropper = new Jaguar(DropperP);
//        Spike = new Relay(1, 1);
//        s1 = new Solenoid(3, 3);
//        s2 = new Solenoid(3, 4);
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
