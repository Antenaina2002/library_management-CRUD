import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        authorsCRUD authorsCrud = new authorsCRUD();
        testAuthorsCrud(authorsCrud);
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
}
