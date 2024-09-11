package com.java.abstractInterface;

interface AdminPrivileges{

    /** **This is Marker Interface**
     *
     * Some key utilities of a marker interface are as follows:
     *
     * --> You can create a common parent. (When you have a common parent,
     * you can use a super type reference to point to subtype objects, and it
     * can help you to achieve runtime polymorphism).
     *
     * --> A class can claim membership in the set; for example, if your class
     * implements the Serializable interface, it becomes serializable. So,
     * your class actually becomes an interface type through polymorphism.
     * Even a class that implements a tagging interface need not define any
     * new method, because the interface itself does not have any methods.
     *
     */
}

class User {
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
class AdminUser extends User implements AdminPrivileges{

    public AdminUser(String name) {
        super(name);
    }

    public void accessAdminPanel(){
        System.out.println(getName() + " can access Admin Panel...");
    }
}

public class MarkerInterface {
    public static void main(String[] args){
        User normalUser = new User("Normal User");
        AdminUser adminUser = new AdminUser("AdminUser");

        checkAccessPrivilege(normalUser);
        checkAccessPrivilege(adminUser);
    }

    public static void checkAccessPrivilege(User user){
        if(user instanceof AdminPrivileges){
            ((AdminUser) user).accessAdminPanel();
        }else {
            System.out.println(user.getName() + " DO NOT have access");
        }
    }
}
