using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MetaUser.Models;
using MetaUser.Services;

namespace MetaUser.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    private readonly UsersServices _userService;
    private User currentUser;
    public bool isLoggedIn = false;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
        _userService = new UsersServices();
    }

    [HttpGet]
    public IActionResult Index()
    {
        ViewData["userList"] = _userService.GetUserList();
        ViewData["isLoggedIn"] = isLoggedIn;
        return View();
    }

    [HttpPost]
    public IActionResult RegisterUser(User user){
        bool passwordValid = user.Password.Equals(user.ConfirmPassword);
        bool accountExistsAlready = _userService.EmailAlreadyInUse(user.Email);

        if(passwordValid && !accountExistsAlready){
            currentUser = user;
            _userService.AddUser(user);
            ViewData["currentUsername"] = currentUser.Username;
            isLoggedIn = true;
        }
        
        ViewData["userList"] = _userService.GetUserList();
        ViewData["isLoggedIn"] = isLoggedIn;
        return View("Index");
    }

    [HttpPost]
    public IActionResult LoginUser(User user){
        string email = user.Email;
        string password = user.Password;
        bool userAvailable = _userService.FindUser(email, password);

        if(userAvailable){
            isLoggedIn = true;
            ViewData["currentUsername"] = _userService.GetUser(email, password).Username;
        }else{
            isLoggedIn = false;
        }

        ViewData["isLoggedIn"] = isLoggedIn;
        ViewData["userList"] = _userService.GetUserList();
        return View("Index");
    }

    public IActionResult DeleteUser(){
        
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
