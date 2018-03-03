package by.htp.lib.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import by.htp.lib.bean.Author;
import by.htp.lib.bean.Book;
import by.htp.lib.dao.BookDao;

public class FileBookDaoImpl implements BookDao {

	private static final String FILE_PATH = "resources/library.txt";

	Book[] books = new Book[100];
	int bookCount = 0;
	int authorCount = 0;

	@Override
	public Book[] readAll() {

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

			String str = null;

			while ((str = br.readLine()) != null) {

				String[] strArr = str.split(", ");

				addBook(strArr);

				bookCount++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return books;
	}

	public void addBook(String[] strArr) {

		books[bookCount] = new Book();
		books[bookCount].setId(Integer.parseInt(strArr[0]));
		books[bookCount].setTitle(strArr[1]);
		books[bookCount].setYear(Integer.parseInt(strArr[2]));
		Author author = new Author();
		authorCount++;
		author.setId(authorCount);
		author.setName(strArr[3]);
		author.setSurname(strArr[4]);
		books[bookCount].setAuthor(author);

	}
}
