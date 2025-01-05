using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MetaUser.Models;

namespace MetaUser.Controllers;

public class AuthController : Controller
{
    private readonly ILogger<AuthController> _logger;
    public List<User> users = new List<User>{
        new User{Username="Gamedemons", Email="gamedemons55@gmail.com", Password="12345678", ConfirmPassword="12345678"},
        new User{Username="Void", Email="void@proton.me", Password="12345678", ConfirmPassword="12345678"},
        new User{Username="Manthan", Email="manthanrajoria@hotmail.com", Password="12345678", ConfirmPassword="12345678"},
        new User{Username="Nyx", Email="nyxane@gmail.com", Password="12345678", ConfirmPassword="12345678"}
    };

    public AuthController(ILogger<AuthController> logger)
    {
        _logger = logger;
    }

    [HttpGet]
    public IActionResult Index()
    {
        return View("Register");
    }

    [HttpPost]
    public IActionResult Index(User user){
        users.Add(user);
        ViewData["usersList"] = users; 
        return RedirectToAction("Index", "Users");
    }

    public IActionResult Login()
    {
        return View();
    }

    public IActionResult AddUser(User user){
        var users = (List<User>)ViewData["usersList"]!;
        users.Add(user);
        return RedirectToAction("Index", "Users");
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
