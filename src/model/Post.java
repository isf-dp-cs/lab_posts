package model;

public class Post

{
    private String textContent;
    private String hashtag;
    private int likes;
    private boolean visibility;

    // Default constructor
    public Post(String textContent, String hashtag, boolean visibility, int likes) {
        this.textContent = textContent;
        this.hashtag = hashtag;
        this.visibility = visibility;
        this.likes = likes;
    }

    // Accessor and mutator methods
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isVisible() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        String colorCode;
        if (visibility == true) {
            colorCode = "\u001B[32m"; // Green for visible
        } else {
            colorCode = "\u001B[31m"; // Red for non-visible
        }

        String resetColorCode = "\u001B[0m";

        // in a string \n is an escape sequence that creates a newline
        String output = colorCode + "--------------------------------------------------\n"
                + colorCode + "| " + textContent + " |\n"
                + colorCode + "--------------------------------------------------\n"
                + colorCode + "| Hashtag: " + hashtag + " |\n"
                + colorCode + "--------------------------------------------------\n"
                + colorCode + "| Likes: " + likes + " |\n"
                + colorCode + "--------------------------------------------------\n"
                + resetColorCode;

        return output;
    }
}