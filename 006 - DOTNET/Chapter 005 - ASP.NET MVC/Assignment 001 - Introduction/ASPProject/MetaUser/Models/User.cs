namespace MetaUser.Models;

public class User
{
    [Key]
    public int Id {get; set;}
    public required string Username {get; set;}
    public required string Email {get; set;}
    public required string Password {get; set;}
    public required string ConfirmPassword {get; set;}
}
