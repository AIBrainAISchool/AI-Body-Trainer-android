# AI Body Trainer
Take a few minutes a day to lose weight and keep fit effectively with our workout at home. No equipment needed, just use your bodyweight to workout at home.<br>
Start to improve fitness and health with this fitness exercises and get in shape, defined figure you’ve always wanted with this exercise routine, designed to improve fitness.

<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/app.png" width="900">
    </p>

## App Video
Video
  
## Overview
In this project we will produce a squat counter using ML kit pose detection. This project is divided into three main parts:
### Part 1. Model Overview
####  1.1	Setup and Requirement
####  1.2	Setup the environment
### Part 2. Google ML Kit
####  2.1 Pose Detection
### Part 3. Files and their Functions
####  incomplete

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
    
After the successful creation launch it. It will look similar to this according to the emulator configuration you have choosen:
<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/emulator.png" width="350" height="600">
    </p>


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

•	Cross-platform support Enjoy the same experience on both Android and iOS.

•	Full body tracking The model returns 33 key skeletal landmark points, including the positions of the hands and feet.

•	InFrameLikelihood score For each landmark, a measure that indicates the probability that the landmark is within the image frame. The score has a range of 0.0 to 1.0, where 1.0 indicates high confidence.

•	Two optimized SDKs The base SDK runs in real time on modern phones like the Pixel 4 and iPhone X. It returns results at the rate of ~30 and ~45 fps respectively. However, the precision of the landmark coordinates may vary. The accurate SDK returns results at a slower framerate, but produces more accurate coordinate values.

•	Z Coordinate for depth analysis This value can help determine whether parts of the users body are in front or behind the users' hips.


