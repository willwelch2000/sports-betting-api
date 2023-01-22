# Sports Betting Web Scraper
## Sports Betting App overall
This application is one part of a larger project, an app that
1. Uses Selenium to scrape the web for predictions and betting odds for athletic events.
2. Interfaces with a MySQL database to store and access this data. 
3. Perform analysis on the data to attempt to find successful sports-betting strategies.

## Purpose of this part of the project
This is the api portion of the project. It acts as an http interface to a local MySQL database. 

## Technologies used
* Maven
* Spring boot
* MySQL connector

## Http requests supported
* GET: returns list of all games in databse
* GET(/{gameId}): returns individual game by id
* GET(/result): returns list of all games with a known result
* GET(/pastNoResult): returns list of all games without a known result that occured before the current day
* GET(/byLeague/{league}): returns list of all games in a given league
* POST: posts an individual game
    * game should be in request body
* PUT: updates an individual game
    * game should be in request body with id