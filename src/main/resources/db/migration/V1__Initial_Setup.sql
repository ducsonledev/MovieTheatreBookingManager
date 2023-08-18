CREATE TABLE MOVIE(
    movieId BIGSERIAL PRIMARY KEY,
    movieName TEXT NOT NULL,
    movieTags TEXT NOT NULL,
    moviePosterUrl TEXT NOT NULL
)