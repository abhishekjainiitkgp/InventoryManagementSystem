import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;

    public UserController() {
        this.userList = new ArrayList<>();
    }

    public UserController(List<User> userList) {
        this.userList = userList;
    }
    //addUser
    public void addUser(User user){
        this.userList.add(user);
    }
    public void  removeUser(User user){
        this.userList.remove(user);
    }

    public User getUserById(int id){
        for(User user : userList){
            if(user.userId==id)
                return user;
        }
        return null;
    }

    //remove User
}
