package frc.robot.subsystems.drivetrain;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.filter.SlewRateLimiter; 
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax frontLeft = new CANSparkMax(Constants.FRONT_LEFT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless); 
  private CANSparkMax frontRight = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax middleLeft = new CANSparkMax(Constants.MIDDLE_LEFT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless); 
  private CANSparkMax middleRight = new CANSparkMax(Constants.MIDDLE_RIGHT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless); 
  private CANSparkMax backLeft = new CANSparkMax(Constants.BACK_LEFT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless); 
  private CANSparkMax backRight = new CANSparkMax(Constants.BACK_RIGHT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless); 

  private MotorControllerGroup left = new MotorControllerGroup(frontLeft, middleLeft, backLeft); 
  private MotorControllerGroup right = new MotorControllerGroup(frontRight, middleRight, backRight); 


  private DifferentialDrive drive = new DifferentialDrive(left, right); 

  private final SlewRateLimiter throttleFilter = new SlewRateLimiter(Constants.kThrottleFilter);
  private final SlewRateLimiter turnFilter = new SlewRateLimiter(Constants.kTurnFilter);

  private final XboxController controller; 

  public Drivetrain(XboxController controller) {
    this.controller = controller; 

    frontLeft.setIdleMode(IdleMode.kBrake);
    frontRight.setIdleMode(IdleMode.kBrake);
    middleLeft.setIdleMode(IdleMode.kBrake); 
    middleRight.setIdleMode(IdleMode.kBrake);
    backLeft.setIdleMode(IdleMode.kBrake);
    backRight.setIdleMode(IdleMode.kBrake);

    left.setInverted(false); 
    right.setInverted(true);
  }

  // @Override
  public void robotInit() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void drive(double throttle, double turn) {
    differentialDrive.arcadeDrive(throttleFilter.calculate(throttle), turnFilter.calculate(turn * Constants.turnRate));
  }

  public void driveFromController() {
    drive(controller.getLeftY(), controller.getRightX()); 
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  // @Override
  public void teleopPeriodic() {
    
  }
}
