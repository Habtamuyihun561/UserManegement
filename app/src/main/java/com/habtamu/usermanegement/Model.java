package com.habtamu.usermanegement;

public class Model {
    private String fullname;
    private String username;
    private int image;
    private String password;
    private String confirm_password;
    private String email;
    private String gender;
    private int id;
    private String phon_number;

    public Model(String fullname, String username,
                 int image, String password,
                 String confirm_password,
                 String email, String gender,
                 int id, String phon_number) {
        this.fullname = fullname;
        this.username = username;
        this.image = image;
        this.password = password;
        this.confirm_password = confirm_password;
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.phon_number = phon_number;
    }

    public Model() {
    }



    public Model(String fullname, String username,
                 String email, String password
                 ,String phon_number, String gender
                 ) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.phon_number = phon_number;
    }




    public int getImage()
    {
        return image;
    }

    public void setImage(int image)
    {
        this.image = image;
    }



    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirm_password()
    {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhon_number() {
        return phon_number;
    }

    public void setPhon_number(String phon_number) {
        this.phon_number = phon_number;
    }


    public Model(String fullname, String username,String email,
                 String password,
                 String confirm_password
            , String phon_number,String gender) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.confirm_password = confirm_password;
        this.email = email;
        this.gender = gender;
        this.phon_number = phon_number;
    }

    public Model(String fullname, String username, int id) {
        this.fullname = fullname;
        this.username = username;
        this.id = id;
    }}


