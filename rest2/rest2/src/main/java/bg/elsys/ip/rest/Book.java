package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModelProperty;

public class Book {

	@ApiModelProperty(required = true)
	private int id;
	private String name;
	private String author;
	private String genre;
	private int pagesNum;

	public Book() {
	}

	public Book(int id, String name, String author, String genre, int pagesNum) {
		this.id = id;
		this.name = name;
		this.setAuthor(author);
		this.setGenre(genre);
		this.setPagesNum(pagesNum);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPagesNum() {
		return pagesNum;
	}

	public void setPagesNum(int pagesNum) {
		this.pagesNum = pagesNum;
	}

}
