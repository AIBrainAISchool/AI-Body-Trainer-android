/*
 * Copyright 2020 Google LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.mlkit.vision.demo.java.posedetector;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.widget.TextView;

import androidx.annotation.Nullable;
import com.google.mlkit.vision.demo.GraphicOverlay;
import com.google.mlkit.vision.demo.GraphicOverlay.Graphic;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseLandmark;

import java.util.List;
import java.util.Locale;
import com.google.mlkit.vision.demo.R;
/** Draw the detected pose in preview. */
public class PoseGraphic extends Graphic {

  private static final float DOT_RADIUS = 8.0f;


  private final Pose pose;
  private final boolean showInFrameLikelihood;
  private final Paint whitePaint;


  private Context context;

  private TextView counter;
  private TextView FrameNumber;
  private PoseDetectorProcessor PP;



  PoseGraphic(GraphicOverlay overlay, Pose pose, boolean showInFrameLikelihood, Context context, PoseDetectorProcessor PP) {
    super(overlay);
    this.PP = PP;
    this.context =context;
    this.pose = pose;
    this.showInFrameLikelihood = showInFrameLikelihood;

    counter = (TextView) ((Activity) context).findViewById(R.id.counter);
    FrameNumber = (TextView) ((Activity) context).findViewById(R.id.frameNumber);




    whitePaint = new Paint();
    whitePaint.setColor(Color.WHITE);


  }


  @Override
  public void draw(Canvas canvas) {
    List<PoseLandmark> landmarks = pose.getAllPoseLandmarks(); //get all PoseLandmarks from pose processor
    if (landmarks.isEmpty()) { //if there is no landmark
      return; //return null
    } else {
      // Draw all the points

      for (PoseLandmark landmark : landmarks) {
        //drawPoint(canvas, landmark.getPosition(), whitePaint);
        if (showInFrameLikelihood) {
          canvas.drawText(
                  String.format(Locale.US, "%.2f", landmark.getInFrameLikelihood()),
                  translateX(landmark.getPosition().x),
                  translateY(landmark.getPosition().y),
                  whitePaint);


          return;
        }
      }
    }


       PoseLandmark leftShoulder = pose.getPoseLandmark(PoseLandmark.LEFT_SHOULDER);
       PoseLandmark rightShoulder = pose.getPoseLandmark(PoseLandmark.RIGHT_SHOULDER);
       PoseLandmark leftElbow = pose.getPoseLandmark(PoseLandmark.LEFT_ELBOW);
       PoseLandmark rightElbow = pose.getPoseLandmark(PoseLandmark.RIGHT_ELBOW);
       PoseLandmark leftWrist = pose.getPoseLandmark(PoseLandmark.LEFT_WRIST);
       PoseLandmark rightWrist = pose.getPoseLandmark(PoseLandmark.RIGHT_WRIST);
       PoseLandmark leftHip = pose.getPoseLandmark(PoseLandmark.LEFT_HIP);
       PoseLandmark rightHip = pose.getPoseLandmark(PoseLandmark.RIGHT_HIP);
       PoseLandmark leftKnee = pose.getPoseLandmark(PoseLandmark.LEFT_KNEE);
       PoseLandmark rightKnee = pose.getPoseLandmark(PoseLandmark.RIGHT_KNEE);

       PoseLandmark leftAnkle = pose.getPoseLandmark(PoseLandmark.LEFT_ANKLE);
       PoseLandmark rightAnkle = pose.getPoseLandmark(PoseLandmark.RIGHT_ANKLE);
         /*

       PoseLandmark leftPinky = pose.getPoseLandmark(PoseLandmark.LEFT_PINKY);
       PoseLandmark rightPinky = pose.getPoseLandmark(PoseLandmark.RIGHT_PINKY);
       PoseLandmark leftIndex = pose.getPoseLandmark(PoseLandmark.LEFT_INDEX);
       PoseLandmark rightIndex = pose.getPoseLandmark(PoseLandmark.RIGHT_INDEX);
       PoseLandmark leftThumb = pose.getPoseLandmark(PoseLandmark.LEFT_THUMB);
       PoseLandmark rightThumb = pose.getPoseLandmark(PoseLandmark.RIGHT_THUMB);


      PoseLandmark leftHeel = pose.getPoseLandmark(PoseLandmark.LEFT_HEEL);
      PoseLandmark rightHeel = pose.getPoseLandmark(PoseLandmark.RIGHT_HEEL);

        */
      PoseLandmark leftFootIndex = pose.getPoseLandmark(PoseLandmark.LEFT_FOOT_INDEX);
      PoseLandmark rightFootIndex = pose.getPoseLandmark(PoseLandmark.RIGHT_FOOT_INDEX);


      drawLine(canvas, leftShoulder.getPosition(), rightShoulder.getPosition(), whitePaint);
      drawLine(canvas, leftHip.getPosition(), rightHip.getPosition(), whitePaint);
      // Left body
      drawLine(canvas, leftShoulder.getPosition(), leftElbow.getPosition(), whitePaint);
      drawLine(canvas, leftElbow.getPosition(), leftWrist.getPosition(), whitePaint);
      drawLine(canvas, leftShoulder.getPosition(), leftHip.getPosition(), whitePaint);
      drawLine(canvas, leftHip.getPosition(), leftKnee.getPosition(), whitePaint);


      drawLine(canvas, leftKnee.getPosition(), leftAnkle.getPosition(), whitePaint);
        /*
      drawLine(canvas, leftWrist.getPosition(), leftThumb.getPosition(), leftPaint);
      drawLine(canvas, leftWrist.getPosition(), leftPinky.getPosition(), leftPaint);
      drawLine(canvas, leftWrist.getPosition(), leftIndex.getPosition(), leftPaint);


      drawLine(canvas, leftAnkle.getPosition(), leftHeel.getPosition(), whitePaint);
      drawLine(canvas, leftHeel.getPosition(), leftFootIndex.getPosition(), whitePaint);

        */

      // Right body
      drawLine(canvas, rightShoulder.getPosition(), rightElbow.getPosition(), whitePaint);
      drawLine(canvas, rightElbow.getPosition(), rightWrist.getPosition(), whitePaint);
      drawLine(canvas, rightShoulder.getPosition(), rightHip.getPosition(), whitePaint);
      drawLine(canvas, rightHip.getPosition(), rightKnee.getPosition(), whitePaint);


      drawLine(canvas, rightKnee.getPosition(), rightAnkle.getPosition(), whitePaint);

      /*
      drawLine(canvas, rightWrist.getPosition(), rightThumb.getPosition(), rightPaint);
      drawLine(canvas, rightWrist.getPosition(), rightPinky.getPosition(), rightPaint);
      drawLine(canvas, rightWrist.getPosition(), rightIndex.getPosition(), rightPaint);



      drawLine(canvas, rightAnkle.getPosition(), rightHeel.getPosition(), whitePaint);
      drawLine(canvas, rightHeel.getPosition(), rightFootIndex.getPosition(), whitePaint);

        */


      updateCounter(pose);
  }



  public void updateCounter(Pose pose)
  {
    //use SquatCompute module to determine if the pose is squat
    if (new SquatCompute(pose).isSquat()) {

      PP.SquatFrameCount++; //if it is squat, add 1 to SquatFrameCount


      FrameNumber.setText(Integer.toString(PP.SquatFrameCount)); //and show it on TextView


    } else {
      //if it says it's not squat,

      if (PP.SquatFrameCount > 0)  //if the SquatFrameCount is non-zero,

      {
        PP.count += 1; //add 1 to Squat count

        PP.SquatFrameCount = 0; //reset the SquatFrameCount to 0
        counter.setText(Integer.toString(PP.count)); //show count on TextView
        FrameNumber.setText(Integer.toString(PP.SquatFrameCount)); //show SquatFrameCount on TextView
      }
    }

  }

  void drawPoint(Canvas canvas, @Nullable PointF point, Paint paint) {
    if (point == null) {
      return;
    }
    canvas.drawCircle(translateX(point.x), translateY(point.y), DOT_RADIUS, paint);
  }

  //Draw lines for the pose
  void drawLine(Canvas canvas, @Nullable PointF start, @Nullable PointF end, Paint paint) {
    if (start == null || end == null) {
      return;
    }
    canvas.drawLine(
        translateX(start.x), translateY(start.y), translateX(end.x), translateY(end.y), paint);
  }
}
