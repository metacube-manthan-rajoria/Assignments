using System;

namespace MetaUser.Services;
using MetaUser.Models;

public class UserServices
{
    private static List<User> userList = new List<User>{
        new User{Id=Guid.NewGuid(), Username="Gamedemons", Email="gamedemons55@gmail.com", Password="12345678", ConfirmPassword="12345678"},
        new User{Id=Guid.NewGuid(), Username="Void", Email="void@proton.me", Password="12345678", ConfirmPassword="12345678"},
        new User{Id=Guid.NewGuid(), Username="Manthan", Email="manthanrajoria@hotmail.com", Password="12345678", ConfirmPassword="12345678"},
        new User{Id=Guid.NewGuid(), Username="Nyx", Email="nyxane@gmail.com", Password="12345678", ConfirmPassword="12345678"}
    };
    public static bool isLoggedIn = false;

    public static List<User> GetUserList(){
        return userList;
    }

    public static bool AddUser(User newUser){
        foreach(var user in userList){
            if(user.Equals(newUser)){
                return false;
            }
        }
        userList.Add(newUser);
        return true;
    }

    public static bool RemoveUser(Guid id){
        User? userToRemove = null;
        int index = 0;
        foreach(var user in userList){
            if(user.Id == id && index!=0){
                userToRemove = user;
            }
            index++;
        }
        if(userToRemove != null){
            userList.Remove(userToRemove);
            return true;
        }
        return false;
    }

    public static User? FindUser(string email, string password){
        foreach(var user in userList){
            if(user.Email.Equals(email) && user.Password.Equals(password)){
                return user;
            }
        }
        return null;
    }

    public static bool EmailAlreadyInUse(string email){
        foreach(var user in userList){
            if(user.Email.Equals(email)){
                return true;
            }
        }
        return false;
    }
}
