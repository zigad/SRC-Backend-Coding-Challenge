package si.deisinger;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class BasicTest {

    @Test
    public void testGetMovies() {
        given()
                .when().get("/movies")
                .then()
                .statusCode(200)
                .body(is("[{\"imdbID\":123456,\"title\":\"The Matrix\",\"description\":\"A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.\",\"year\":1999,\"pictures\":\"https://example.com/matrix.jpg,https://example.com/matrix2.jpg,https://example.com/matrix3.jpg,https://example.com/matrix4.jpg\",\"actors\":[\"Jennifer Lawrence\"]},{\"imdbID\":789012,\"title\":\"Inception\",\"description\":\"A thief who enters the dreams of others to steal their secrets gets a final mission that could change everything.\",\"year\":2010,\"pictures\":\"https://example.com/inception.jpg\",\"actors\":[\"Scarlett Johansson\",\"Leonardo DiCaprio\"]},{\"imdbID\":345678,\"title\":\"Pulp Fiction\",\"description\":\"Various interrelated stories about crime, love, and redemption in the underworld of Los Angeles.\",\"year\":1994,\"pictures\":\"https://example.com/pulpfiction.jpg\",\"actors\":[\"Denzel Washington\"]},{\"imdbID\":901234,\"title\":\"The Shawshank Redemption\",\"description\":\"Two imprisoned men bond over several years, finding solace and eventual redemption through acts of common decency.\",\"year\":1994,\"pictures\":\"https://example.com/shawshankredemption.jpg\",\"actors\":[\"Tom Hanks\"]},{\"imdbID\":567890,\"title\":\"The Lord of the Rings: The Fellowship of the Ring\",\"description\":\"A young hobbit, Frodo, who has found the One Ring, begins his journey to Mount Doom to destroy it.\",\"year\":2001,\"pictures\":\"https://example.com/lotrfellowship.jpg\",\"actors\":[\"Meryl Streep\"]},{\"imdbID\":234567,\"title\":\"Forrest Gump\",\"description\":\"Forrest Gump, while not intelligent, has accidentally been present at many historic moments, but his true love, Jenny, eludes him.\",\"year\":1994,\"pictures\":\"https://example.com/forrestgump.jpg\",\"actors\":[\"Tom Hanks\"]},{\"imdbID\":890123,\"title\":\"The Dark Knight\",\"description\":\"Batman sets out to dismantle the remaining criminal organizations that plague Gotham City.\",\"year\":2008,\"pictures\":\"https://example.com/thedarkknight.jpg\",\"actors\":[]},{\"imdbID\":456789,\"title\":\"Interstellar\",\"description\":\"A team of explorers travels through a wormhole in space to ensure humanitys survival.\",\"year\":2014,\"pictures\":\"https://example.com/interstellar.jpg\",\"actors\":[]},{\"imdbID\":678901,\"title\":\"The Godfather\",\"description\":\"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.\",\"year\":1972,\"pictures\":\"https://example.com/thegodfather.jpg\",\"actors\":[\"Brad Pitt\",\"Angelina Jolie\"]},{\"imdbID\":345612,\"title\":\"Gladiator\",\"description\":\"A former Roman General seeks revenge against the corrupt emperor who murdered his family and sent him into slavery.\",\"year\":2000,\"pictures\":\"https://example.com/gladiator.jpg\",\"actors\":[\"Johnny Depp\"]}]"));
    }

    @Test
    public void testGetMovieById() {
        given()
                .when().get("/movies/123456")
                .then()
                .statusCode(200)
                .body(is("{\"imdbID\":123456,\"title\":\"The Matrix\",\"description\":\"A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.\",\"year\":1999,\"pictures\":\"https://example.com/matrix.jpg,https://example.com/matrix2.jpg,https://example.com/matrix3.jpg,https://example.com/matrix4.jpg\",\"actors\":[\"Jennifer Lawrence\"]}"));
    }

    @Test
    public void testGetMissingMovieById() {
        given()
                .when().get("/movies/9999")
                .then()
                .statusCode(204);
    }

    @Test
    public void testGetActors() {
        given()
                .when().get("/actors")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"firstName\":\"Tom\",\"lastName\":\"Hanks\",\"birthday\":\"1956-07-09\",\"movies\":[\"The Shawshank Redemption\",\"Forrest Gump\"],\"fullName\":\"Tom Hanks\"},{\"id\":2,\"firstName\":\"Scarlett\",\"lastName\":\"Johansson\",\"birthday\":\"1984-11-22\",\"movies\":[\"Inception\"],\"fullName\":\"Scarlett Johansson\"},{\"id\":3,\"firstName\":\"Leonardo\",\"lastName\":\"DiCaprio\",\"birthday\":\"1974-11-11\",\"movies\":[\"Inception\"],\"fullName\":\"Leonardo DiCaprio\"},{\"id\":4,\"firstName\":\"Brad\",\"lastName\":\"Pitt\",\"birthday\":\"1963-12-18\",\"movies\":[\"The Godfather\"],\"fullName\":\"Brad Pitt\"},{\"id\":5,\"firstName\":\"Angelina\",\"lastName\":\"Jolie\",\"birthday\":\"1975-06-04\",\"movies\":[\"The Godfather\"],\"fullName\":\"Angelina Jolie\"},{\"id\":6,\"firstName\":\"Johnny\",\"lastName\":\"Depp\",\"birthday\":\"1963-06-09\",\"movies\":[\"Gladiator\"],\"fullName\":\"Johnny Depp\"},{\"id\":7,\"firstName\":\"Meryl\",\"lastName\":\"Streep\",\"birthday\":\"1949-06-22\",\"movies\":[\"The Lord of the Rings: The Fellowship of the Ring\"],\"fullName\":\"Meryl Streep\"},{\"id\":8,\"firstName\":\"Denzel\",\"lastName\":\"Washington\",\"birthday\":\"1954-12-28\",\"movies\":[\"Pulp Fiction\"],\"fullName\":\"Denzel Washington\"},{\"id\":9,\"firstName\":\"Jennifer\",\"lastName\":\"Lawrence\",\"birthday\":\"1990-08-15\",\"movies\":[\"The Matrix\"],\"fullName\":\"Jennifer Lawrence\"},{\"id\":10,\"firstName\":\"Robert\",\"lastName\":\"Downey Jr.\",\"birthday\":\"1965-04-04\",\"movies\":[],\"fullName\":\"Robert Downey Jr.\"}]"));
    }

    @Test
    public void testGetActorsById() {
        given()
                .when().get("/actors/6")
                .then()
                .statusCode(200)
                .body(is("{\"id\":6,\"firstName\":\"Johnny\",\"lastName\":\"Depp\",\"birthday\":\"1963-06-09\",\"movies\":[\"Gladiator\"],\"fullName\":\"Johnny Depp\"}"));
    }

    @Test
    public void testGetMissingActorsById() {
        given()
                .when().get("/actors/9999")
                .then()
                .statusCode(204);
    }

}