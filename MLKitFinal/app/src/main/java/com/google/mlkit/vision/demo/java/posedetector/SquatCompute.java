package com.google.mlkit.vision.demo.java.posedetector;

import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseLandmark;

import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.atan2;

public class SquatCompute {
    //initialize PoseLandmarks
    PoseLandmark leftHip;
    PoseLandmark rightHip;
    PoseLandmark leftKnee;
    PoseLandmark rightKnee;
    PoseLandmark leftFootIndex;
    PoseLandmark rightFootIndex;

    //initialize the left leg angle and right leg angle
    double leftAngle, rightAngle;

    public SquatCompute(Pose pose)
    {
        //Initializes PoseLandmarks
        leftHip        = pose.getPoseLandmark(PoseLandmark.LEFT_HIP);
        rightHip       = pose.getPoseLandmark(PoseLandmark.RIGHT_HIP);
        leftKnee       = pose.getPoseLandmark(PoseLandmark.LEFT_KNEE);
        rightKnee      = pose.getPoseLandmark(PoseLandmark.RIGHT_KNEE);
        leftFootIndex  = pose.getPoseLandmark(PoseLandmark.LEFT_FOOT_INDEX);
        rightFootIndex = pose.getPoseLandmark(PoseLandmark.RIGHT_FOOT_INDEX);
    }

    static double getAngle(PoseLandmark firstPoint, PoseLandmark midPoint, PoseLandmark lastPoint) {
        // Computes the angle between two vectors, one connects firstPoint and midPoint and the other connects
        // midPoint and lastPoint
        double A, B, C;
        double Fx, Fy, Mx, My, Lx, Ly;
        Fx = firstPoint.getPosition().x;
        Fy = firstPoint.getPosition().y;
        Mx = midPoint.getPosition().x;
        My = midPoint.getPosition().y;
        Lx = lastPoint.getPosition().x;
        Ly = lastPoint.getPosition().y;

        A = Math.sqrt(Math.pow(Lx-Fx,2) + Math.pow(Ly-Fy, 2));
        B = Math.sqrt(Math.pow(Lx-Mx,2) + Math.pow(Ly-My, 2));
        C = Math.sqrt(Math.pow(Mx-Fx,2) + Math.pow(My-Fy, 2));

        double angle  = Math.toDegrees(acos((B*B+C*C-A*A)/(2*B*C))); // Trigonometry result

        angle = abs(angle); // Angle should never be negative

        if (angle > 180) {
            angle = (360.0 - angle); // Always get the acute representation of the angle
        }
        return angle;
    }


    public boolean isSquat()
    {
        leftAngle  = getAngle(leftFootIndex, leftKnee, leftHip);
        rightAngle = getAngle(rightFootIndex, rightKnee, rightHip);
        //took the angle from either leg
        //this is the core function that determines if it Squat or not

        if(leftAngle < 100 || rightAngle < 100) //currently when either angle is less than 100, it is squat
            //You can change this angle into any desired angle between 0 and 180.
        {
            return true;
        }
        return false;
    }
}
