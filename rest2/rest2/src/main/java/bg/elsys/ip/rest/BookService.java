package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
	private static BookService instance;

	public static BookService getInstance() {
		if (instance == null) {
			instance = new BookService();
		}
		return instance;
	}

	private List<Book> bookList = new ArrayList<>();

	public BookService() {
		for(int i = 0; i< 100; i++){
			bookList.add(new Book(i, "The hitchhiker's guide to the Galaxy " + i, "Douglas Adams", "sci-fi", 856));
			bookList.add(new Book(100 + i, "The Lord of the Rings" + i, "J.R.R. Tolkien", "fantasy", 1598));
		}
	}

	public List<Book> getBooks() {
		return Collections.unmodifiableList(bookList);
	}

	public void addBook(Book user) {
		bookList.add(user);
	}

	public PagedResponse getBooksInPagesFiltered(String withName) {
		List<Book> pageOfBooks = bookList.stream().filter((u) -> u.getName().equals(withName) || withName == null)
				.collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) bookList.size()));
		PagedResponse response = new PagedResponse(pageOfBooks, totalPages);

		return response;
	}

	public List<String> getAllDistinctBookNames() {
		return bookList.stream()
				.map((u) -> u.getName())
				.distinct()
				.collect(Collectors.toList());
	}
}
