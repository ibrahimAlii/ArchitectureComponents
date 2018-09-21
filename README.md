# ListProduct

**Using MVVM Pattern**

This app built with the new archeticture-components from google.

#Retrofit
#Room
#Navigation
#Data-binding
#KTX
#Work-Manager
#Life-Cycle-Extensions
#Glide
#RecycleView
#Google-Maps

#To-Solve

- (Tests) No UI/Unit tests included
- (Code) (Critical) Network failure at first time will make the app cannot load data in the coming launch
- (Code) (Major) In `DeliveriesListViewModel`, redundant `if...else` case
- (Code) (Minor) When using `Moshi`, `@Json` should be used instead of `@SerializedName`
