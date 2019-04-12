# Custom Profiles Demo App for Android
This is a demo app showing how to add a profile photo to your app's users and display it in a chat window.

## Before you start

Navigate to this project and follow the instructions to get a local server running before you try to run this app.

* [Server for Running Custom Profiles Demo](https://github.com/mitterio/server-custom-profile-demo)

## How to setup?

Get a copy of this project by doing a git clone:

```
git clone https://github.com/mitterio/android-custom-profile-demo.git
```

After that, open your project using Android Studio and make following changes:

* **Add your application ID**. Open `App.kt` and replace the existing application ID with your own application ID.
* **Add a channel ID**. Open `MainActivity.kt` and replace the existing channel ID with the channel ID that you received after running the local server (as mentioned in the previous section).

## How to run?

Run this project using Android Studio on **2** or more devices/emulators and choose a user to login from the first screen that pops up.

Click the face icon beside the send button on the device/emulator running the app as the user **Amy** to add profile photo for Amy.

Restart the apps on both devices/emulators and send messages from one user to another to see the custom profiles in action.

## More details

This project is a part of the Custom Profiles recipe on Mitter.io's website. Visit the following link to learn more about this implementation:

* Recipe - [link here]
