package by.htp.lib.runner;

import by.htp.lib.bean.Book;
import by.htp.lib.bean.Catalog;
import by.htp.lib.logic.LibraryService;
import by.htp.lib.logic.impl.CityLibraryServiceImpl;

public class LibrarianMain {

	public static void main(String[] args) {

		LibraryService service = new CityLibraryServiceImpl();
		Catalog booksCatalog = service.getMainCatalog();
		viewCatalogInfo(booksCatalog);

	}

	private static void viewCatalogInfo(Catalog catalog) {

		for (Book book : catalog.getBooks()) {
			if (book != null) {
				System.out.println(book);
			}
		}
	}
}
