# History Of Development

1.  I downloaded and installed `android-studio-2024.2.1.12-windows.exe`.

2.  Loading Android Studio, I navigated to New Project and Empty Activity. I gave the Empty Activity the name "Step Counter", the package name `com.tslever.stepcounter`, the save location `C:\Users\Tom\AndroidStudioProjects\StepCounter`, the minimum SDK API 24 '("Nougat"; Android 7.0)', and the build configuration language "Kotlin DSL (build.gradle.kts) [Recommended]".

3.  I borrowed Kamryn Kokas's Google Pixel 5 running Android 14 and a USB-A to USB-C cable specifically designed to share data.

4.  I navigated to Settings, About phone, and Build number. I pressed Build number 7 times to enable developer mode.

5.  I connected the Google Pixel 5 to my Windows laptop with Android Studio open. Android Studio began mirroring with the Google Pixel 5. I could control the Google Pixel 5 from either device. I may have enabled mirroring upon connecting previously.

6.  I began debugging the Empty Activity, which yielded the following errors.

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