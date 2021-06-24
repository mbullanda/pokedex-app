# pokedex-app
Pokedex is app to manage pokemons. It's rest api, where you can:
-add pokemon,
-get all pokemons, pokemons by types or names,
-get pokemons with pagination (in params: page and size),
-update pokemons,
-delete pokemon.

App is using h2 database:
-path: /h2-console
-url: jdbc:h2:mem:testdb
-login: sa
-password: password

App has two users:
-user (password: password),
-admin (password: password).

To show simple authentication:
-only admin has the permit to create new pokemon (http method: POST). 
-user is able to use other http methods.
