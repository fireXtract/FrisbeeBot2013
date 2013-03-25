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

    private final static int LFDriveP = 1;
    private final static int LBDriveP = 2;
    private final static int RFDriveP = 3;
    private final static int RBDriveP = 4;
    private final static int FShootP = 6;
    private final static int BShootP = 5;
    private final static int DropperP = 7;
    
    public Jaguar LFDrive;
    public Jaguar LBDrive;
    public Jaguar RFDrive;
    public Jaguar RBDrive;
    public Jaguar Shoot1;
    public Jaguar Shoot2;
    public Jaguar Dropper;
    
//    public Relay Spike;
    public Solenoid sU, sD;
    public Compressor airComp;
        
    public Joystick joy1;
    public Joystick joy2;
    
    public boolean IOComp;
    
    public DriverStationLCD textOutput;
    
    private static FrisbeeParts partInst;

    public FrisbeeParts() {
        LFDrive = new Jaguar(LFDriveP);
        LBDrive = new Jaguar(LBDriveP);
        RFDrive = new Jaguar(RFDriveP);
        RBDrive = new Jaguar(RBDriveP);
        Shoot1 = new Jaguar(FShootP);
        Shoot2 = new Jaguar(BShootP);
        Dropper = new Jaguar(DropperP);
        
        IOComp = false;
        
        textOutput = DriverStationLCD.getInstance();
        
        airComp = new Compressor(1, 1);
//        Spike = new Relay(1, Relay.Direction.kBoth);
        sU = new Solenoid(1);
        sD = new Solenoid(2);
        
        joy1 = new Joystick(1);
        joy2 = new Joystick(2);
    }
    
//    public void runHopper(){
//        textOutput.println(DriverStationLCD.Line.kUser1, 1, "Speed 1 "+ joy1.getAxis(Joystick.AxisType.kY));
//        textOutput.println(DriverStationLCD.Line.kUser2, 1, "Speed 2 "+ joy2.getAxis(Joystick.AxisType.kY));
////        textOutput.println(DriverStationLCD.Line.kUser3, 1, "Gyro "+ gyro.getAngle());
//        textOutput.updateLCD();
//    }
//    
    public static FrisbeeParts getInstance() {
        if (partInst == null) //if partInst doesnt exist make it!!
        {
            partInst = new FrisbeeParts();
        }
        return partInst;
    }
}
