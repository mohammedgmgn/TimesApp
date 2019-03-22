# TimesApp
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a0b69cd973d24889a4194b0a47837692)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mohammedgmgn/TimesApp&amp;utm_campaign=Badge_Grade)


<p align="center">
<img src="last.gif" width="280" height="580"/>
</p>



## How I approached modularising the app ?

<p align="center">
<img src="Clean.png" width="500" height="200"/>
</p>




Separating core logic can help to create a clear separation of concerns that makes our code easier to understand so ,

i modularised the app to three types of layers

- ##  Data layer 

    This typically contain a repository for accessing data remotely or via disk.

- ## Presentation layer 

    Will include normal Activities and Fragments, which will only handle rendering views and will follow MVVM pattern

- ## Domain layer 

    Will include all business logic and interact between Data and Presentation layer by means of interface and interactors. The objective is to make the domain layer independent of anything, so the business logic can be tested without any dependency to external components


## Technical Notes:
1. Cacheing .
7. Follow most of `Google Design Guidelines`.
1- ViewModels and LiveData 


### Used libraries: ###
- [RxJava2](https://github.com/ReactiveX/RxJava)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [Retrofit2](https://github.com/square/retrofit)
- [Android architecture components](https://developer.android.com/topic/libraries/architecture/index.html)
- [Picasso](https://github.com/square/picasso)
- [OkHttp](https://github.com/square/okhttp)
- [butterknife](http://jakewharton.github.io/butterknife/)

### License: ###
~~~~
Copyright 2019 Mohammed Mahmoud 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
~~~~



