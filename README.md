# TimesApp
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a0b69cd973d24889a4194b0a47837692)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mohammedgmgn/TimesApp&amp;utm_campaign=Badge_Grade)


<p align="center">
<img src="last.gif" width="350" height="650"/>
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
