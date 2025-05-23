public class Usuario extends Base {
    private String auth0Id;
    private String username;

    public String getAuth0Id() { return auth0Id; }
    public void setAuth0Id(String auth0Id) { this.auth0Id = auth0Id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}