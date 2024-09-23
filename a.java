import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;

public class GitExample {
    public static void main(String[] args) {
        try {
            // Clone a repository
            Git.cloneRepository()
                .setURI("https://github.com/your-repo.git")
                .setDirectory(new File("path/to/repo"))
                .call();

            // Open an existing repository
            Git git = Git.open(new File("path/to/repo"));

            // Add a file to the repository
            git.add().addFilepattern("file.txt").call();

            // Commit the changes
            git.commit().setMessage("Added file.txt").call();

            // Push the changes to the remote repository
            git.push().call();

            System.out.println("Repository operations completed successfully.");
        } catch (GitAPIException | IOException e) {
            e.printStackTrace();
        }
    }
}

