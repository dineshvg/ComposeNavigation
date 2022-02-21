# ComposeNavigation
Implementation of aa app that displays the bonprix assortment

The assortment entries are fetched via an API Rest Call
 - The API Endpoint = https://codechallenge.mobilelab.io/v1/bonprix/navigation 
- API-Key  = N8Nx0OwOvo1iuN2ZkFHZlyVKBVgoIcy4tUHMppO5 as x-api-key request header field.

Touching a node navigates to the childern level and the node and the other nodes are shown in the list.
The end-node is a web-view that shows the data from the URL.

- Code done completely using Jetpack compose ( no fragments or XML used)
- Rest API called using Restrofit
- Navigation using Compose navigation

