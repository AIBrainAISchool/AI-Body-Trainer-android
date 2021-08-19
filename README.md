# AI Body Trainer
Take a few minutes a day to lose weight and keep fit effectively with our workout at home. No equipment needed, just use your bodyweight to workout at home.<br>
Start to improve fitness and health with this fitness exercises and get in shape, defined figure you’ve always wanted with this exercise routine, designed to improve fitness.

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/app.png" width="900">
    </p>

## Prototype Video
<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/aibodytrainer.gif" width="300" height="600">
    </p>
  
## Overview
In this project we will produce a squat counter using ML kit pose detection. This project is divided into three main parts:
### Part 1. Model Overview
>##### 1.1	Setup and Requirement
>##### 1.2	Setup the environment
### Part 2. Google ML Kit
>##### 2.1 Pose Detection
### Part 3. Files and their Functions
>##### 3.1 Squat Compute
### Part 4. Integrating ML Kit with template<br>

## 1.1 Setup and Requirements
Let’s dive into the world of Apps. 
### What is Android Studio?

Android Studio is the official integrated development environment (IDE) for Google's Android operating system, built on JetBrains IntelliJ IDEA software and designed specifically for Android development.It is available for download on Windows, macOS and Linux based operating systems.

Android Studio provides the fastest tools for building apps on every type of Android device. 
We need to setup android studio to build and run our project.

Here is the Youtube link to download android studio for Windows(64 bit) step by step process:<br>
https://www.youtube.com/watch?v=0zx_eFyHRU0

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/AndroidStudio.png" width="450" height="350">
    </p>

#### *NOTE: This project will only work with android studio 4.1 version or above.*


## 1.2 Setup the environment
Now let us set up the environment for our project. 

Here is the github link to the project

link(www.google.com)

Download and unzip it in a location.

#### Open android studio. Go to File>Open>*open the folder where you unzip the file*
<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/openfile.png" width="480" height="500">
    </p>
  
Wait for the configuration to come up. It may take some minutes. 

Its time to create a android emulator. Now you have been thinking what is an emulator. Let me help you with it.

### What is an Emulator?

The Android Emulator simulates Android devices on your computer so that you can test your application on a variety of devices and Android API levels without needing to have each 
physical device.

#### Go to Tools>AVD manager>Create Virtual Device
<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/emulatorss.png" width="1200" height="500">
    </p>
    
    
After the successfull creation of emulator, **Go to the Run>Run 'app'** in the top pane or press **Shift+F10**.<br>
The project will build and install in the emulator chosen in the top pane.

The Output will look like this-
<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/MLkitoutput.png" width="800" height="600">
    </p>
    
Quite Interesting? Isn't it.

## Part 2. Google ML Kit
ML Kit brings Google’s machine learning expertise to mobile developers in a powerful and easy-to-use package. Make your iOS and Android apps more engaging, personalized, and helpful with solutions that are optimized to run on device.

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/mlkit.png" width="480">
    </p>

## 2.1 Pose Detection
Pose Estimation refers to computer vision technique that detect human body keypoints in images and videos. While Image Classification's output was a predicted label and its confidence rate, the Pose Estimation model’s output is the predicted location of the body keypoints within the screen. Take a look at some of the models in action below the video.

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/pose_face_hands.gif" width="480">
    <br>
    <sup>https://github.com/CMU-Perceptual-Computing-Lab/openpose</sup>
</p>

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/pose_estimation.gif" width="480">
    <br>
    <sup>https://www.tensorflow.org/lite/models/pose_estimation/overview</sup>
</p>

The ML Kit Pose Detection API is a lightweight versatile solution for app developers to detect the pose of a subject's body in real time from a continuous video or static image. A pose describes the body's position at one moment in time with a set of skeletal landmark points. The landmarks correspond to different body parts such as the shoulders and hips. The relative positions of landmarks can be used to distinguish one pose from another.

![alt text](https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/landmarks-fixed.png "Ml kit")

•	Cross-platform support Enjoy the same experience on both Android and iOS.<br>
•	Full body tracking The model returns 33 key skeletal landmark points, including the positions of the hands and feet.<br>
•	InFrameLikelihood score For each landmark, a measure that indicates the probability that the landmark is within the image frame. The score has a range of 0.0 to 1.0, where 1.0 indicates high confidence.<br>
•	Two optimized SDKs The base SDK runs in real time on modern phones like the Pixel 4 and iPhone X. It returns results at the rate of ~30 and ~45 fps respectively. However, the precision of the landmark coordinates may vary. The accurate SDK returns results at a slower framerate, but produces more accurate coordinate values.<br>
•	Z Coordinate for depth analysis This value can help determine whether parts of the users body are in front or behind the users' hips.

## Part 3. Files and their Functions
There are lot of files in the project. You may be wondering what are these files are doing. Let’s see that in this section.<br> 	
Here is the link to the ML KIT by Google:<br>
https://github.com/googlesamples/mlkit/tree/master/android/vision-quickstart<br>
After configuring this according to our requirement the final ML Kit file will look like this:

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/finalmlkit.png">
    </p>

#### *Note: Refer Part 1 for the updated zip file.*

This is the Flowdiagram of the files we should know about-
<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/files.png">
    </p>

### 3.1. Squat Compute
Google ML Kit recognizes the pose landmarks and pinpoints them, so we have in our hands x and y coordinates for each landmark. But how do we use them to recognize squat? 

Let's simplify this problem more. We can make the user to do the exercise at a certain angle to the camera; for instance, face directly towards the camera. Then, we can presume that x coordinates would hardly change, whereas y coordinates would change by significant amount. We can set an appropriate threshold, so when the changes in y coordinates are larger than the threshold, we can say it's a proper squat. But is it the best method for us to determine if it was a proper squat or not just by y coordinates? In fact, since the heights of people vary a lot and the threshold should vary depending on the resolution of the camera, using just y coordinates is not ideal. 

Then what can be done? There is one quantity that does not change depending on the resolution and the heights of people: the angle. If we make the user to do squats from side view, then we can measure the angle of the leg using trigonometry. 

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/squatanalysis.png" width="480" height="400">
    </p>
    
The angle can be computed using the cosine rule:

When A is the length of the line that connects hip and foot, B is the length of the line that connects hip and knee, C is the length of the line that connects knee and foot, the angle Q in the legs is

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/formula.png">
    </p>
    
For each A, B, C, we can compute them using Pythagoras theorem. For instance, if we say the x, y coordinate of knee is (x2,y2) and hip (x3,y3), then the distance between them is

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/lengthB.png">
    </p>
    
When Q has been calculated, we want Angle Q to be displayed as a positive value that is less than 180 (assuming you can't bend your knee the other way). So in case Q is negative or greater than 180 degrees, we need take the absolute value and/or subtract it from 360 degrees.

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/squatacute.png">
    </p>

#### Here is the reference video-

<p align="center">
<a href="https://www.youtube.com/watch?v=kD9_2DYQQUk" target="_blank"><img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/youtubetem.png" 
alt="Reference Video" width="800" height="500" border="10" /></a>
</p>

## Part 4. Integrating ML Kit with template

We have to integrate our ML Kit with template to make our App commercially usable.

Steps involved are:<br>
>##### 1. Include ML Kit Pose Detection 
>##### 2. Modify activity_exercise_detail.xml 
>##### 3. Modify ActivityExerciseDetail.java when the user clicks "Skip" or the timer count is over 

1.  From ML Kit, we had to remove java files that are Activities. Activity is the component that shows the screen by connecting xml files to the screen. Then, the skeleton that draws lines on the recognized person was removed, as we do not need that. Also, we made the camera to only show the camera input from the front camera, since users would need to see the screen while exercising.

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/PoseEstimateFolderAdded.png">
    </p>

2. In activity_exercise_detail.xml , we had to include the preview and overlay, which render the camera input to the screen and will replace the image that shows during the exercise.

(Here is the github link to the file).

3. From ActivityExerciseDetail.java , I have made the following changes:

(Here is the github link to the file).

## You can download the Final apk and install it in your android phones:(link)
                 
