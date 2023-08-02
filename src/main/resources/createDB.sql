INSERT INTO public.movie (imdbid, title, description, year, pictures)
VALUES
    (123456, 'The Matrix', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 1999, 'https://example.com/matrix.jpg,https://example.com/matrix2.jpg,https://example.com/matrix3.jpg,https://example.com/matrix4.jpg'),
    (789012, 'Inception', 'A thief who enters the dreams of others to steal their secrets gets a final mission that could change everything.', 2010, 'https://example.com/inception.jpg'),
    (345678, 'Pulp Fiction', 'Various interrelated stories about crime, love, and redemption in the underworld of Los Angeles.', 1994, 'https://example.com/pulpfiction.jpg'),
    (901234, 'The Shawshank Redemption', 'Two imprisoned men bond over several years, finding solace and eventual redemption through acts of common decency.', 1994, 'https://example.com/shawshankredemption.jpg'),
    (567890, 'The Lord of the Rings: The Fellowship of the Ring', 'A young hobbit, Frodo, who has found the One Ring, begins his journey to Mount Doom to destroy it.', 2001, 'https://example.com/lotrfellowship.jpg'),
    (234567, 'Forrest Gump', 'Forrest Gump, while not intelligent, has accidentally been present at many historic moments, but his true love, Jenny, eludes him.', 1994, 'https://example.com/forrestgump.jpg'),
    (890123, 'The Dark Knight', 'Batman sets out to dismantle the remaining criminal organizations that plague Gotham City.', 2008, 'https://example.com/thedarkknight.jpg'),
    (456789, 'Interstellar', 'A team of explorers travels through a wormhole in space to ensure humanitys survival.', 2014, 'https://example.com/interstellar.jpg'),
    (678901, 'The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 1972, 'https://example.com/thegodfather.jpg'),
    (345612, 'Gladiator', 'A former Roman General seeks revenge against the corrupt emperor who murdered his family and sent him into slavery.', 2000, 'https://example.com/gladiator.jpg');

INSERT INTO public.actor (id, firstName, lastName, birthday)
VALUES
    (1, 'Tom', 'Hanks', '1956-07-09'),
    (2,'Scarlett', 'Johansson', '1984-11-22'),
    (3,'Leonardo', 'DiCaprio', '1974-11-11'),
    (4,'Brad', 'Pitt', '1963-12-18'),
    (5,'Angelina', 'Jolie', '1975-06-04'),
    (6,'Johnny', 'Depp', '1963-06-09'),
    (7,'Meryl', 'Streep', '1949-06-22'),
    (8,'Denzel', 'Washington', '1954-12-28'),
    (9,'Jennifer', 'Lawrence', '1990-08-15'),
    (10,'Robert', 'Downey Jr.', '1965-04-04');

INSERT INTO public.movie_actor (actor_id, movie_id)
VALUES
    (1, 901234),  -- Tom Hanks in "The Shawshank Redemption"
    (1, 234567),  -- Tom Hanks in "Forrest Gump"
    (2, 789012),  -- Scarlett Johansson in "Inception"
    (3, 789012),  -- Leonardo DiCaprio in "Inception"
    (4, 678901),  -- Brad Pitt in "The Godfather"
    (5, 678901),  -- Angelina Jolie in "The Godfather"
    (6, 345612),  -- Johnny Depp in "Gladiator"
    (7, 567890),  -- Meryl Streep in "The Lord of the Rings"
    (8, 345678), -- Denzel Washington in "Pulp Fiction"
    (9, 123456);  -- Jennifer Lawrence in "The Matrix"