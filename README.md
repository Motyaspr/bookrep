# Test Assignment Backend

Create a backend for a bookstore.

To store the code, use the repository on GitHub.

Create a server on Spring Boot.

Make a CRUD for a bookstore with 5 endpoints:
* GET /books - Get array of all books
* GET /books/:id - Get one book by ID
* POST /books - Create new book
* PUT /books/:id - Update book by ID
* DELETE /books/:id - Delete book by ID

The backend data exchange format is JSON.

Book data is stored in a list of hashmaps.

Book fields:
- uuid
- name
- isbn
- author
- releaseDate

Advanced
* Add pagination (pagination) - getting a portion of books (for example, 10 books per page) through the query parameter take and skip. For example /books?take=10&skip=20 to get ten books starting from 21.
* Add sorting when receiving books. In the GET request for /books, add the query parameter sort to be able to sort by all books. Example GET /books?sort=name:asc,author:desc

More advanced
* Divide the code into logical classes - controller, service, repository.
* Use a MySQL database instead of a hashmap list. Create a store database with a books table.