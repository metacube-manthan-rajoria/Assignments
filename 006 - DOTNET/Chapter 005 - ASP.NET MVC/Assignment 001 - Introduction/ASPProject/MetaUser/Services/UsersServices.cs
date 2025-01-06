using System;

namespace MetaUser.Services;
using MetaUser.Models;

public class UsersServices
{
    private List<User> userList;

    public UsersServices(){
        userList = new List<User>{
            new User{Id=Guid.NewGuid(), Username="Gamedemons", Email="gamedemons55@gmail.com", Password="12345678", ConfirmPassword="12345678"},
            new User{Id=Guid.NewGuid(), Username="Void", Email="void@proton.me", Password="12345678", ConfirmPassword="12345678"},
            new User{Id=Guid.NewGuid(), Username="Manthan", Email="manthanrajoria@hotmail.com", Password="12345678", ConfirmPassword="12345678"},
            new User{Id=Guid.NewGuid(), Username="Nyx", Email="nyxane@gmail.com", Password="12345678", ConfirmPassword="12345678"}
        };
    }

    public List<User> GetUserList(){
        return userList;
    }

    public void AddUser(User user){
        user.Id = Guid.NewGuid();
        userList.Add(user);
    }

    public bool RemoveUser(Guid id){
        User? userToRemove = null;
        foreach(var user in userList){
            if(user.Id == id){
                userToRemove = user;
            }
        }
        if(userToRemove != null){
            userList.Remove(userToRemove);
            return true;
        }
        return false;
    }

    public bool FindUser(string email, string password){
        foreach(var user in userList){
            if(user.Email.Equals(email) && user.Password.Equals(password)){
                return true;
            }
        }
        return false;
    }

    public User GetUser(string email, string password){
        foreach(var user in userList){
            if(user.Email.Equals(email) && user.Password.Equals(password)){
                return user;
            }
        }
        return null;
    }

    public bool EmailAlreadyInUse(string email){
        foreach(var user in userList){
            if(user.Email.Equals(email)){
                return true;
            }
        }
        return false;
    }
}
