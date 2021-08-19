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
###### 1.1	Setup and Requirement
###### 1.2	Setup the environment
### Part 2. Google ML Kit
###### 2.1 Pose Detection
### Part 3. Files and their Functions
###### 3.1 Squat Compute
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

<a href="http://www.youtube.com/watch?feature=player_embedded&v=YOUTUBE_VIDEO_ID_HERE
" target="_blank"><img src="http://img.youtube.com/vi/YOUTUBE_VIDEO_ID_HERE/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="240" height="180" border="10" /></a>

## Part 4. Integrating ML Kit with template
We have to integrate our ML Kit with template to make our App commercially usable.

Steps involved are:<br>
###### 1. Include ML Kit Pose Detection 
###### 2. Modify activity_exercise_detail.xml 
###### 3. Modify ActivityExerciseDetail.java when the user clicks "Skip" or the timer count is over 

1.  From ML Kit, we had to remove java files that are Activities. Activity is the component that shows the screen by connecting xml files to the screen. Then, the skeleton that draws lines on the recognized person was removed, as we do not need that. Also, we made the camera to only show the camera input from the front camera, since users would need to see the screen while exercising
<p align="center">
    <img src="https://github.com/AIBrainAISchool/AI-Body-Trainer-android/blob/main/PoseEstimateFolderAdded.png">
    </p>

2. In activity_exercise_detail.xml , we had to include the preview and overlay, which render the camera input to the screen and will replace the image that shows during the exercise.

```
    <!-- Line number, description
     1. Declaring the id for the overlay
     2, 3. Set the width and height same as the screen
     4, 5, 6, 7. Overlap on the preview
     8. Initialize it as gone, meaning that it does not occupy space on the screen and is not visible-->

<com.templatevilla.fitness.PoseEstimate.GraphicOverlay
    android:id="@+id/graphic_overlay"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_constraintLeft_toLeftOf="@id/preview_view"
    app:layout_constraintRight_toRightOf="@id/preview_view"
    app:layout_constraintTop_toTopOf="@id/preview_view"
    app:layout_constraintBottom_toBottomOf="@id/preview_view"
    android:visibility="gone"/>

<!--1. Declaring te id for the camera preview
    2, 3. Set the width and height same as the screen
    4, 5. Fill the screen
    6. Initialize it as gone. -->

<com.templatevilla.fitness.PoseEstimate.CameraSourcePreview
    android:id="@+id/preview_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintBottom_toBottomOf="parent"
    android:visibility="gone"
    />
...
...

<!--1. Set font for the counter
    2. Set text size
    3. Set text color
    4. Initialize the text as 0
    5, 6. Set the size of the counter
    7. Constrain its position to be left of btn_done widget
    8. Constrain its position to be vertically centered-->

<TextView
    android:fontFamily="@font/rubik_regular"
    android:textSize = "55sp"
    android:textColor="@color/black"
    android:id = "@+id/repsCounter"
    android:text = "0"
    android:layout_width="80sp"
    android:layout_height="80sp"
    android:layout_toLeftOf="@+id/btn_done"
    android:layout_centerVertical="true"
     />
```    

3. From ActivityExerciseDetail.java , I have made the following changes:

```
...
public class ActivityExerciseDetail extends AppCompatActivity {
    ...
    TextView repsCounter;// Define reps counter           
    String requiredReps; // Define required reps
    ...
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        ...
        repsCounter = findViewById(R.id.repsCounter); // findViewById the reps counter
        repsCounter.addTextChangedListener(watcher);  // addTextChangedListener to proceed to next exercise, 
                                                      // if reps count is equal to requiredReps
        
        // check if all permissions are granted by the user. If so, createCameraSource else ask for permissions
        if (allPermissionsGranted()) {
            createCameraSource();
        } else {
            getRuntimePermissions();
        }
       
    }
    
    private void init(){
        ...
        preview = findViewById(R.id.preview_view); // initialize preview
        graphicOverlay = findViewById(R.id.graphic_overlay); // and graphicOverlay
    }
    ...
    public void setProgressTimer(final int time) {
        ...
        progress_timer = new CountDownTimer(time * 1000, 1000) {
        ...
        @Override
        public void onFinish() {
            ...
            // When count down is over, proceed to the next exercise and create new cameraSource
            if (allPermissionsGranted()) {
                createCameraSource();
            } else {
                getRuntimePermissions();
            }
        }
    }.start();
    
    
    public void setNextData(boolean ab) {
        try {
            repsCounter.setText("0");
            if (allPermissionsGranted()) {
                createCameraSource();
            } else {
                getRuntimePermissions();
            }
            ...
              
        }
        ...
    }
    ...
    
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(repsCounter.getText().toString().equals(requiredReps))
            {
                setNextData(false);
            }
        }
    };
    
    ...
    public void hideReadyView() {
        ...
        preview.setVisibility(View.VISIBLE); // when starting the exercise, make preview visible
        graphicOverlay.setVisibility(View.VISIBLE); // when starting the exercise, make graphicOverlay visible
    }
    ...
    public String regexGetReps(String instruction)
    {
        Pattern intsOnly = Pattern.compile("\\d+");
        Matcher makeMatch = intsOnly.matcher(instruction);
        makeMatch.find();
        String reps = makeMatch.group();
        return reps;
    }
    
    @SuppressLint("SetTextI18n")
    public void setExerciseData(int pos){
        try {
            ...
            if (s.equals(getResources().getString(R.string.easy))) {
                tv_type.setText("" + exerciseList.get(pos).easy);
                requiredReps = regexGetReps(exerciseList.get(pos).easy); // initialize requiredReps by taking the internally 
                                                                         // saved string values and processing them with regex
                                                                         // regex : special package to deal with string values
                
            } else if (s.equals(getResources().getString(R.string.medium))) {
                tv_type.setText("" + exerciseList.get(pos).medium);
                requiredReps = regexGetReps(exerciseList.get(pos).medium); // same as above

            } else if (s.equals(getResources().getString(R.string.difficult))) {
                tv_type.setText("" + exerciseList.get(pos).difficulty);
                requiredReps = regexGetReps(exerciseList.get(pos).difficulty); // same as above
            }
            ...
        }
    }
    
    ...
    // Define required widgets & variables
    private static final int PERMISSION_REQUESTS = 1;
    private CameraSource cameraSource = null;
    private CameraSourcePreview preview;
    private GraphicOverlay graphicOverlay;
    private static final String TAG = "ActivityExerciseDetail"
    
    // createCameraSource : create CameraSource and prepare pose detector 
    private void createCameraSource() {
        // If there's no existing cameraSource, create one.
        if (cameraSource == null) {
            cameraSource = new CameraSource(this, graphicOverlay);
        }

        try {
            PoseDetectorOptionsBase poseDetectorOptions =
                    PreferenceUtils.getPoseDetectorOptionsForLivePreview(this);
            boolean shouldShowInFrameLikelihood =
                    PreferenceUtils.shouldShowPoseDetectionInFrameLikelihoodLivePreview(this);
            Log.i(TAG, "Using Pose Detector with options " + poseDetectorOptions);

            cameraSource.setMachineLearningFrameProcessor(new PoseDetectorProcessor(this, poseDetectorOptions, exerciseList.get(pos).name, shouldShowInFrameLikelihood));

            } catch (Exception e) {
            Log.e(TAG, "Can not create image processor: " + e);
            Toast.makeText(
                    getApplicationContext(),
                    "Can not create image processor: " + e.getMessage(),
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

   
    // startCameraSource : start outputting the camera source to the preview widget
    private void startCameraSource() {
        try {
            if (preview == null) {
                Log.d(TAG, "resume: Preview is null");
            }
            if (graphicOverlay == null) {
                Log.d(TAG, "resume: graphOverlay is null");
            }
            preview.start(cameraSource, graphicOverlay);
        } catch (IOException e) {
            Log.e(TAG, "Unable to start camera source.", e);
            cameraSource.release();
            cameraSource = null;
        }

    }
    
    // Permission related functions from here..
    private String[] getRequiredPermissions() {
        try {
            PackageInfo info =
                    this.getPackageManager()
                            .getPackageInfo(this.getPackageName(), PackageManager.GET_PERMISSIONS);
            String[] ps = info.requestedPermissions;
            if (ps != null && ps.length > 0) {
                return ps;
            } else {
                return new String[0];
            }
        } catch (Exception e) {
            return new String[0];
        }
    }

    private boolean allPermissionsGranted() {
        for (String permission : getRequiredPermissions()) {
            if (!isPermissionGranted(this, permission)) {
                return false;
            }
        }
        return true;
    }

    private void getRuntimePermissions() {
        List<String> allNeededPermissions = new ArrayList<>();
        for (String permission : getRequiredPermissions()) {
            if (!isPermissionGranted(this, permission)) {
                allNeededPermissions.add(permission);
            }
        }

        if (!allNeededPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(
                    this, allNeededPermissions.toArray(new String[0]), PERMISSION_REQUESTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        Log.i(TAG, "Permission granted!");
        if (allPermissionsGranted()) {
            createCameraSource();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private static boolean isPermissionGranted(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission granted: " + permission);
            return true;
        }
        Log.i(TAG, "Permission NOT granted: " + permission);
        return false;
    }        
}
```

## You can download the Final apk and install it in your android phones:(link)
                 
