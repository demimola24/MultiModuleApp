# MultiModuleApp

Application Modularizing useful in cases where our applications grows, or we may want to take advantage of new distribution features (Instant apps, app bundles) from Google, 
or even just create a clear separation of concerns to make our project easier to work.

This is a sample application showing a simple multi module application.

App Features:
- DFM for Weather via city (Lagos)
- DFM for Weather via coordinate (Lagos)

Two dynamic feature modules (DFM) which depend on the app module. Each DFM contains at one activity, code and resources related to only the feature mentioned above.
Just as well the app module depends on a core module which contains shared code and resources as well as third party libraries.

<img src="https://github.com/demimola24/MultiModuleApp/blob/master/app_graph.png" width="300" height="530">


Dependency Injection Gragh (using Dagger 2)

<img src="https://github.com/demimola24/MultiModuleApp/blob/master/dependency_graph.png" width="300" height="530">


App Screenshot (Designed Inspired by Google Search)

<img src="https://github.com/demimola24/MultiModuleApp/blob/master/screen_one.png" width="300" height="530">

<img src="https://github.com/demimola24/MultiModuleApp/blob/master/screen_two.png" width="300" height="530">

<img src="https://github.com/demimola24/MultiModuleApp/blob/master/screen_three.png" width="300" height="530">

