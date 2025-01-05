using System;

namespace MetaUser.Services;
using MetaUser.Models;

public class UsersServices
{
    private List<User> userList;

    public UsersServices(){
        userList = new List<User>{
            new User{Username="Gamedemons", Email="gamedemons55@gmail.com", Password="12345678", ConfirmPassword="12345678"},
            new User{Username="Void", Email="void@proton.me", Password="12345678", ConfirmPassword="12345678"},
            new User{Username="Manthan", Email="manthanrajoria@hotmail.com", Password="12345678", ConfirmPassword="12345678"},
            new User{Username="Nyx", Email="nyxane@gmail.com", Password="12345678", ConfirmPassword="12345678"}
        };
    }

    public List<User> GetUserList(){
        return userList;
    }

    public void AddUser(User user){
        userList.Add(user);
    }

    public bool RemoveUser(Guid id){
        foreach(var user in userList){
            if(user.Id == id){
                userList.Remove(user);
                return true;
            }
        }
        return false;
    }
}
