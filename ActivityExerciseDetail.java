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