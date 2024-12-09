# History Of Development

1.  I downloaded and installed `android-studio-2024.2.1.12-windows.exe`.

2.  Loading Android Studio, I navigated to New Project and Empty Activity. I gave the Empty Activity the name "Step Counter", the package name `com.tslever.stepcounter`, the save location `C:\Users\Tom\AndroidStudioProjects\StepCounter`, the minimum SDK API 24 '("Nougat"; Android 7.0)', and the build configuration language "Kotlin DSL (build.gradle.kts) [Recommended]".

3.  I borrowed Kamryn Kokas's Google Pixel 5 running Android 14 and a USB-A to USB-C cable specifically designed to share data.

4.  I navigated to Settings, About phone, and Build number. I pressed Build number 7 times to enable developer mode.

5.  I connected the Google Pixel 5 to my Windows laptop with Android Studio open. Android Studio began mirroring with the Google Pixel 5. I could control the Google Pixel 5 from either device. I may have enabled mirroring upon connecting previously.

6.  I began debugging the Empty Activity, which yielded the following errors.

    ```
    2 issues were found when checking AAR metadata:

    1.  Dependency 'androidx.core:core:1.15.0' requires libraries and applications that
        depend on it to compile against version 35 or later of the
        Android APIs.

        :app is currently compiled against android-34.

        Recommended action: Update this project to use a newer compileSdk
        of at least 35, for example 35.

        Note that updating a library or application's compileSdk (which
        allows newer APIs to be used) can be done separately from updating
        targetSdk (which opts the app in to new runtime behavior) and
        minSdk (which determines which devices the app can be installed
        on).

    2.  Dependency 'androidx.core:core-ktx:1.15.0' requires libraries and applications that
        depend on it to compile against version 35 or later of the
        Android APIs.

        :app is currently compiled against android-34.

        Recommended action: Update this project to use a newer compileSdk
        of at least 35, for example 35.

        Note that updating a library or application's compileSdk (which
        allows newer APIs to be used) can be done separately from updating
        targetSdk (which opts the app in to new runtime behavior) and
        minSdk (which determines which devices the app can be installed
        on).
    Update minCompileSdk in modules with dependencies that require a higher minCompileSdk.
    ```

7.  I navigated to File, Project Structure..., Modules, and Compile Sdk Version. I changed the Compile Sdk Version to 35.

8.  I began debugging the Empty Activity again, which loaded an app on the Google Pixel 5 with the words, "Hello Android!".

9.  In `C:\Users\Tom\AndroidStudioProjects\StepCounter`, I ran the following commands.

    ```
    git init
    git add .
    git commit -m "Debug app that displays text \"Hello Android\""
    git branch -M main
    git remote add origin git@github.com:tslever/Step_Counter.git
    ssh-keygen -t ed25519 -C "thomas.lever.business@gmail.com"
    eval ssh-agent -s
    ssh-add ~/.ssh/Tom_Levers_Arden_GitHub_Key
    ```

10. After adding the contents of `Tom_Levers_Arden_GitHub_Key.pub` to GitHub, I ran `git push -u origin main`.

11. In Android Studio, I right clicked on `app/res` and created a new Android Resource Directory named layout with resource type layout.

12. I right clicked directory layout and created a new resource file named `activity_main` with root element `LinearLayout`.

13. I replaced the contents of `activity_main.xml` with the following.

    ```
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <TextView
            android:id="@+id/stepCountTextView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Steps: 0"
            android:textSize="24sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

    </androidx.constraintlayout.widget.ConstraintLayout>
    ```

14. I noticed the following error.

    ```
    Class referenced in the layout file, androidx. constraintlayout. widget. ConstraintLayout, was not found in the project or the libraries More... (Ctrl+F1) 
    Inspection info: If a class is referenced in the manifest or in a layout file, it must also exist in the project (or in one of the libraries included by the project. This check helps uncover typos in registration names, or attempts to rename or move classes without updating the XML references properly.  Issue id: MissingClass  More info: https:// developer. android. com/ guide/ topics/ manifest/ manifest-intro. html  Vendor: Android Open Source Project Contact: https:// groups. google. com/ g/ lint-dev Feedback: https:// issuetracker. google. com/ issues/ new?component=192708 
    Cannot resolve class androidx. constraintlayout. widget. ConstraintLayout 
    Inspection info: This inspection highlights unresolvable XML tag references in Android resource files
    ```

15. I clicked on the button `Add dependency on androidx.constraintlayout:constraintlayout`.