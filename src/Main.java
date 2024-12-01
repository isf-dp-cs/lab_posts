import model.Post; // this imports the Post class from the model package
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static Post[] readPostsFromFile(String filePath) throws IOException {
        // Create an array to store 100 posts
        Post[] allPosts = new Post[100];
        int postCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while (reader.ready() == true) { // check that there are lines left to read
                line = reader.readLine(); // read the next line
                String[] parts = line.split(", "); // split the line into pieces
                if (parts.length == 4) { // make sure you won't get index out of bounds
                    String textContent = parts[0];
                    String hashtag = parts[1];
                    int likes = Integer.parseInt(parts[2]);
                    boolean visibility = Boolean.parseBoolean(parts[3]);

                    Post newPost = new Post(textContent, hashtag, visibility, likes); // create the new post
                    allPosts[postCount++] = newPost; // add the post to the array
                }
            }
        }

        return allPosts;
    }

    public static void main(String[] args) throws IOException{
        Post[] allPosts = Main.readPostsFromFile("src/posts_database.txt");
        for (Post post : allPosts) {
            System.out.println(post);
        }
    }

}