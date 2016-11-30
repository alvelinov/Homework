package bg.elsys.ip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/Books")
@Api(value = "Api for querying books")
public class BookResource {

	@GET
	@ApiOperation(value = "get all books")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getBooks(@QueryParam("with-name") String withName) {

		BookService bookService = BookService.getInstance();
		PagedResponse booksInPages = bookService.getBooksInPagesFiltered(withName);
		
		return booksInPages;
	}
	
	@Path("/names")
	@GET
	@ApiOperation("get all distinct book names")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllDistinctBookNames(){
		return BookService.getInstance().getAllDistinctBookNames();
	}

	@POST
	@ApiOperation(value = "create new book", response = Book.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBook(Book book) {
		BookService.getInstance().addBook(book);

		return Response.ok(book).status(Status.CREATED).build();
	}
}
