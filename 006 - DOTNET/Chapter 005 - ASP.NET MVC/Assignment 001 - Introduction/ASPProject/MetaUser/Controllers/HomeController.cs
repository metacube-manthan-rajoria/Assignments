using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MetaUser.Models;
using MetaUser.Services;

namespace MetaUser.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    private readonly UsersServices _userService;
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
    public IActionResult Index(User user){
        _userService.AddUser(user);
        isLoggedIn = true;
        ViewData["userList"] = _userService.GetUserList();
        ViewData["isLoggedIn"] = isLoggedIn;
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
