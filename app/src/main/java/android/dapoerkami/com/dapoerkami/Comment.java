package android.dapoerkami.com.dapoerkami;

/**
 * Created by Anantya Khrisna Seta on 8/4/2018.
 */

public class Comment {
    String postId;
    String username;
    String message;

    //method setter dan getter untuk comment yang ada
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
