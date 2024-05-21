## Watchlist Application
3 major ways you want to add new records
1. One way is to add a movie you really want to watch
2.  To add a new director you discovered and want to explore his work
3. third way is you want to add a movie-director pair.

## Requirements of the application:
Make an MVC architecture, with Movie and Director as your only model classes,
which will have some fields as their properties, constructors and getters-setters.
Then make a controller, service and repository class with appropriate annotations.
Since you want to keep it simple, you don’t need to use any database. (Hint: Think HashMap(s))

## Functionalities to Implement:
1. Add a movie: POST /movies/add-movie
2. Add a director: POST /movies/add-director 
3. Pair an existing movie and director: PUT /movies/add-movie-director-pair 
4. Get Movie by movie name: GET /movies/get-movie-by-name/{name} 
5. Get Director by director name: GET /movies/get-director-by-name/{name} 
6. Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director} 
7. Get List of all movies added: GET /movies/get-all-movies 
8. Delete a director and its movies from the records: DELETE /movies/delete-director-by-name 
9. Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors