package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User value : users) {
            if (login.equals(value.getUsername())) {
                user = value;
                break;
            }
        }
            if (user == null) {
                throw new UserNotFoundException("User not found");
            }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        if (user.getUsername().length() < 3) {
            rsl = false;
        }
        if (!user.isValid()) {
            throw new UserInvalidException("Not valid user");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException en) {
            en.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}