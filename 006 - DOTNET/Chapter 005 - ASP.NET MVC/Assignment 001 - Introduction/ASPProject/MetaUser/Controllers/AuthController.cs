using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MetaUser.Models;
using MetaUser.Services;

namespace MetaUser.Controllers;

public class AuthController : Controller
{
    private readonly ILogger<AuthController> _logger;

    public AuthController(ILogger<AuthController> logger)
    {
        _logger = logger;
    }

    [HttpGet]
    public IActionResult Index()
    {
        return View("Register");
    }

    public IActionResult Login()
    {
        return View();
    }

    public IActionResult Update(Guid id){
        User? user = UserServices.FindUser(id);
        ViewBag.user = user;
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
