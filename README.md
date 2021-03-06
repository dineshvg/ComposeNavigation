# ComposeNavigation
Implementation of aa app that displays the bonprix assortment

The assortment entries are fetched via an API Rest Call
 - The API Endpoint = https://codechallenge.mobilelab.io/v1/bonprix/navigation 
- API-Key  = N8Nx0OwOvo1iuN2ZkFHZlyVKBVgoIcy4tUHMppO5 as x-api-key request header field.

Touching a node navigates to the childern level and the node and the other nodes are shown in the list.
The end-node is a web-view that shows the data from the URL.

- Code done completely using Jetpack compose ( no fragments or XML used)
- Rest API called using Restrofit
- Dependency injection was done using Koin
- Image loading using Coil
- Navigation using Compose navigation
- The **MidCategoryUtiliyScreen** uses a string list of the selected category names and opens the inner category-list based on that. Since Jetpack compose does not allow any parcelable objects, a workaround using string splitting was used.
- Kotlin tests are written for the viewmodel, usecases and repositories.

|Home|MidCategoryUtiliyScreen|
|---|---|
|![Screen](screen1.png)|![Screen](screen2.png)|

|EndScreen|Webview|
|---|---|
|![Screen](endscreen.png)|![Screen](webview.png)|
