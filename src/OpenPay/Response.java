/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpenPay;

/**
 *
 * @author Equipo1
 */
public class Response {
    private OpenPayToken token;
    private String status;
    private String description;

    public Response(OpenPayToken token, String status, String description) {
        this.token = token;
        this.status = status;
        this.description = description;
    }

    public OpenPayToken getToken() {
        return token;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
    
}
