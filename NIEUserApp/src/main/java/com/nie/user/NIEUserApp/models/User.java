package com.nie.user.NIEUserApp.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.AssertTrue;

public class User {

    private int userId;

    @Size(min=3, message="Username must be a minimum of 3 characters")
    private String userName;

    @Pattern(regexp="[6789][0-9]{9}", message="Mobile number must start with 6, 7, 8, or 9 and be 10 digits long")
    private String mobileNum;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be a valid email address")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be a minimum of 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
             message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;

    @NotBlank(message = "Confirm password cannot be blank")
    private String confirmPassword;

    // No-argument constructor is a good practice for frameworks like Spring
    public User() {
    }

    // Constructor with fields
    public User(int userId, String userName, String mobileNum, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.mobileNum = mobileNum;
        this.email = email;
        this.password = password;
        // confirmPassword is intentionally not in the constructor to be set separately
    }

    // A custom validation method to ensure passwords match
    @AssertTrue(message = "Passwords do not match")
    public boolean isPasswordConfirmed() {
        if (this.password == null || this.confirmPassword == null) {
            return false;
        }
        return this.password.equals(this.confirmPassword);
    }
    
    // Getters and Setters for all fields
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
               "userId=" + userId +
               ", userName='" + userName + '\'' +
               ", mobileNum='" + mobileNum + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}

