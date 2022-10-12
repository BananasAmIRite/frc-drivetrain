package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax frontLeft = new CANSparkMax(Constants.FRONT_LEFT_MOTOR, MotorType.kBrushless); 
  private CANSparkMax frontLeft = new CANSparkMax(Constants.FRONT_LEFT_MOTOR, MotorType.kBrushless);
  private CANSparkMax frontRight = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
  private CANSparkMax middleLeft = new CANSparkMax(Constants.MIDDLE_LEFT_MOTOR, MotorType.kBrushless); 
  private CANSparkMax middleRight = new CANSparkMax(Constants.MIDDLE_RIGHT_MOTOR, MotorType.kBrushless); 
  private CANSparkMax backLeft = new CANSparkMax(Constants.BACK_LEFT_MOTOR, MotorType.kBrushless); 
  private CANSparkMax backRight = new CANSparkMax(Constants.BACK_RIGHT_MOTOR, MotorType.kBrushless); 

  private MotorControllerGroup left = new MotorControllerGroup(frontLeft, middleLeft, backLeft); 
  private MotorControllerGroup right = new MotorControllerGroup(frontRight, middleRight, backRight); 


  private DifferentialDrive drive = new DifferentialDrive(left, right); 

  public Drivetrain() {

    left.setInverted(false); 
    right.setInverted(true); 

    frontLeft.setIdleMode(IdleMode.kBrake);
    frontRight.setIdleMode(IdleMode.kBrake);
    middleLeft.setIdleMode(IdleMode.kBrake); 
    middleRight.setIdleMode(IdleMode.kBrake);
    backLeft.setIdleMode(IdleMode.kBrake);
    backRight.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void robotInit() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  @Override
  public void teleopPeriodic() {

  }
}
