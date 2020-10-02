## Android Navigation Components

Navigation components is simply a collection of libraries, plugin and tooling for making Android Navigation easier. Asides making Android Navigation easier, it also helps in handling backstacks, automating fragment transactions, handling transition animations and simplifying deep linking.

There are three major parts to the Navigation Components which includes the;
- Navigation Graph
- NavHostFragment
- NavController

### Navigation Graph

The navigation graph is a resource file containing all of your app's **destinations** and **actions**(in a simpler term it represents your app's navigation paths).

### NavHostFragment

This handles swapping of fragment destinations needed in an app.

### NavController

Every NavHost possess its own corresponding NavController(an object which helps in navigating to destinations within a NavHost in apps) that can be used in your Kotlin or Java code.

## How to Implement Navigation Component In Your Projects
- To use the Navigation component, it requires the Android 3.3 or higher and is dependent on Java 8 language features. Note: You will need to include Navigation support in your project by adding dependencies to your app's `build.gradle` file, [Click here to learn more](https://developer.android.com/topic/libraries/architecture/adding-components#navigation).

- Add a navigation graph in your project. To do this;
 1. In the Project window, right click on the `res` directory
 2. Then click New > Android Resource File.
 3. Type a name in the File name field e.g `nav_graph`.
 4. From the resource type drop-down list, click on Navigation then click OK to proceed.

- After which it opens in the navigation editor to edit the navigation graph visually or edit the XML directly.

- Add a NavHostFragment via the Layer Editor
 1. In the [Layout Editor](https://developer.android.com/studio/write/layout-editor) double click on your activity's layout XML file in your list of project files.  
 2. Search for `NavHostFragment`.
 3. Drag the NavHostFragment view onto your activity.
 4. In the navigation graph dialog that appears, choose the corresponding navigation graph to associate with this NavHostFragment, and then click OK.

- Add a new destination using the Navigation Editor
 1. Click the New Destination icon in the Navigation editor and select Create new destination.
 2. In the New Android Component dialog that appears, create your fragment. [Click here to learn more about fragments](https://developer.android.com/guide/components/fragments).

- Choose a start destination;
 1. Click on the destination to highlight it in the design tab.

2. Then click the Assign start destination button to continue.

- Connect destinations
 1. Hover over the right side of the destination that you want users to navigate from in the design tab.
 2. Click and drag your cursor over the destination you want users to navigate to and then release.
 3. Click on the arrow to highlight the action. 
 4. Then click the text tab to toggle to the XML view.

- Navigate to a destination using the NavController. [Learn more here](https://developer.android.com/guide/navigation/navigation-navigate).
