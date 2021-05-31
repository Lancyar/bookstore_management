package thanhhp.registeration;

import java.io.Serializable;

public class RegistrationCreateError implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String fullNameLengthErr;
    private String confirmNoMatch;
    private String usernameExist;
    private String adminRemoveAdmin;
    
    public RegistrationCreateError() {
        
    }
    /**
     * @return the usernameLengthErr
     */
    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    /**
     * @param usernameLengthErr the usernameLengthErr to set
     */
    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    /**
     * @return the passwordLengthErr
     */
    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    /**
     * @param passwordLengthErr the passwordLengthErr to set
     */
    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    /**
     * @return the fullNameLengthErr
     */
    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    /**
     * @param fullNameLengthErr the fullNameLengthErr to set
     */
    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    /**
     * @return the confirmNoMatch
     */
    public String getConfirmNoMatch() {
        return confirmNoMatch;
    }

    /**
     * @param confirmNoMatch the confirmNoMatch to set
     */
    public void setConfirmNoMatch(String confirmNoMatch) {
        this.confirmNoMatch = confirmNoMatch;
    }

    /**
     * @return the usernameExist
     */
    public String getUsernameExist() {
        return usernameExist;
    }

    /**
     * @param usernameExist the usernameExist to set
     */
    public void setUsernameExist(String usernameExist) {
        this.usernameExist = usernameExist;
    }

    public String getAdminRemoveAdmin() {
        return adminRemoveAdmin;
    }

    public void setAdminRemoveAdmin(String adminRemoveAdmin) {
        this.adminRemoveAdmin = adminRemoveAdmin;
    }
    
    
}
