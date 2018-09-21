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

**Running the webservice:**

You need to run a back-end side using NodeJs:
`npm install` and then `npm start` (The files included in project)

**To-Solve & TO-DO:**

- (Tests) UI/Unit tests 
- (Code) (Critical) Network failure at first time will make the app cannot load data in the coming launch
- (Code) (Major) In `DeliveriesListViewModel`, redundant `if...else` case
- (Code) (Minor) When using `Moshi`, `@Json` should be used instead of `@SerializedName`
- (Code) Glide v4.x, have circle transforming function. So may be no need to have custom `CircleImageView`
- (Code) Dependency injection libraries can be used instead of using mocked "Inject"
- (UX) Pull to refresh 
- (UX) Indicator when network error
