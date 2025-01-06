using System.ComponentModel.DataAnnotations;

namespace MetaUser.Models;

public class User
{
    [Key]
    public Guid Id {get; set;}
    [Required]
    public required string Username {get; set;}
    [Required]
    public required string Email {get; set;}
    [Required]
    public required string Password {get; set;}
    [Required]
    public required string ConfirmPassword {get; set;}
}
