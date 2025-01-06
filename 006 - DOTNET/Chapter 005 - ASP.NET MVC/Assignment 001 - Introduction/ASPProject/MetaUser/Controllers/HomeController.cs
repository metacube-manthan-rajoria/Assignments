using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MetaUser.Models;
using MetaUser.Services;

namespace MetaUser.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }

    [HttpGet]
    public IActionResult Index()
    {
        ViewData["userList"] = UserServices.GetUserList();
        ViewData["isLoggedIn"] = UserServices.isLoggedIn;
        ViewBag.isAdmin = false;
        return View();
    }

    [HttpPost]
    public IActionResult RegisterUser(User user){
        bool passwordValid = user.Password.Equals(user.ConfirmPassword);
        bool accountExistsAlready = UserServices.EmailAlreadyInUse(user.Email);

        if(passwordValid && !accountExistsAlready){
            UserServices.AddUser(user);
            ViewData["currentUsername"] = user.Username;
            UserServices.isLoggedIn = true;
        }
        
        ViewData["userList"] = UserServices.GetUserList();
        ViewData["isLoggedIn"] = UserServices.isLoggedIn;
        ViewBag.isAdmin = false;
        return View("Index");
    }

    [HttpPost]
    public IActionResult LoginUser(User user){
        string email = user.Email;
        string password = user.Password;
        User? userAvailable = UserServices.FindUser(email, password);

        if(userAvailable != null){
            UserServices.isLoggedIn = true;
            ViewData["currentUsername"] = userAvailable.Username;
        }else{
            UserServices.isLoggedIn = false;
        }

        ViewData["isLoggedIn"] = UserServices.isLoggedIn;
        ViewData["userList"] = UserServices.GetUserList();
        ViewBag.isAdmin = UserServices.isAdmin(userAvailable.Id);
        return View("Index");
    }

    [HttpPost]
    public IActionResult UpdateUser(User user){
        bool passwordValid = user.Password.Equals(user.ConfirmPassword);
        bool accountExistsAlready = UserServices.EmailAlreadyInUse(user.Email);

        if(passwordValid && (!accountExistsAlready || (accountExistsAlready && UserServices.FindUser(user.Id).Email.Equals(user.Email)))){
            UserServices.UpdateUser(user);
            ViewData["currentUsername"] = user.Username;
            UserServices.isLoggedIn = true;
        }
        
        ViewData["userList"] = UserServices.GetUserList();
        ViewData["isLoggedIn"] = UserServices.isLoggedIn;
        ViewBag.isAdmin = UserServices.isAdmin(user.Id);
        return View("Index");
    }

    public IActionResult DeleteUser(Guid id){
        ViewData["currentUsername"] = UserServices.GetUserList()[0].Username;
        ViewData["userList"] = UserServices.RemoveUser(id);
        ViewData["isLoggedIn"] = true;
        ViewData["userList"] = UserServices.GetUserList();
        ViewBag.isAdmin = true;
        return View("Index");
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
