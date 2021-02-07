# Android list app

This is my Android application which can load information from RESTful API and show it in a RecycleView, based on MVVM architecture.
It has two different fragment: an OverviewFragment and a DetailFragment, both having ViewModel.

I'm using [Retrofit](https://github.com/square/retrofit) for the API connection and for the images, I'm using [Glide](https://github.com/bumptech/glide).

## How it's working?

When you open the app, it will show you a circular progress indication while it's fetching data from the chosen [Printful Catalog API](https://www.printful.com/docs/catalog).
Once it's done, the application will try to load images linked to the products. If failed, Glide will use 'broken image' placeholder.

You will need internet connection in order to be connected to the API. If you're not online, an icon will show you that there is no connection.

## Screenshots
<p align="center">
<img src=screenshots/Screenshot_20210207-155341.jpg width=30% height=30%>
<img src=screenshots/Screenshot_20210207-155359.jpg width=30% height=30%>
</p>
<p align="center">
<img src=screenshots/Screenshot_20210207-163024.jpg width=30% height= 30%>
</p>
