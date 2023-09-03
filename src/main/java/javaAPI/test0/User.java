package javaAPI.test0;

public class User {

    int user_id;
    String username;
    int post_count;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPost_count() {
        return post_count;
    }

    public void setPost_count(int post_count) {
        this.post_count = post_count;
    }

    public User(int user_id, String username, int post_count) {
        this.user_id = user_id;
        this.username = username;
        this.post_count = post_count;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("user_id=").append(user_id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", post_count=").append(post_count);
        sb.append('}');
        return sb.toString();
    }
}
