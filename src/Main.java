import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        authorsCRUD authorsCrud = new authorsCRUD();
        testAuthorsCrud(authorsCrud);

        booksCRUD booksCrud = new booksCRUD();
        testBooksCrud(booksCrud);
    }

    private static void testAuthorsCrud(authorsCRUD authorsCrud) {
        System.out.println("findAll authors: " + authorsCrud.findAll());

        authorsModel authorToSave = new authorsModel(0, "John Doe", 'M');
        authorsModel savedAuthor = authorsCrud.save(authorToSave);
        System.out.println("Saved author: " + savedAuthor);

        List<authorsModel> authorsToSave = Arrays.asList(
                new authorsModel(0, "Author1", 'F'),
                new authorsModel(0, "Author2", 'M')
        );
        List<authorsModel> savedAuthors = authorsCrud.saveAll(authorsToSave);
        System.out.println("Saved authors: " + savedAuthors);

        authorsModel authorToDelete = savedAuthors.get(0);
        authorsModel deletedAuthor = authorsCrud.delete(authorToDelete);
        System.out.println("Deleted author: " + deletedAuthor);
    }

    private static void testBooksCrud(booksCRUD booksCrud) {
        System.out.println("findAll books: " + booksCrud.findAll());

        booksModel bookToSave = new booksModel(0, "John Doe", "Sample Book", 200, "Sample Topic", null, true);
        booksModel savedBook = booksCrud.save(bookToSave);
        System.out.println("Saved book: " + savedBook);

        booksModel bookToDelete = savedBook;
        booksModel deletedBook = booksCrud.delete(bookToDelete);
        System.out.println("Deleted book: " + deletedBook);
    }
}
