/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpenPay;

import Model.CreditCard;
import Util.Hashing;

/**
 *
 * @author Equipo1
 */
public class OpenPayTokenizer {
    
    public Response tokenizeCard(CreditCard card) {
        String tokenId = Integer.toString(Hashing.toHashSuma(card.getCardNumber()));
        OpenPayToken token = new OpenPayToken(tokenId);
        
        //Response response = new Response(token, "Error", "Hubo un problema al crear el token");
        Response response = new Response(token, "Exito", "Token creado exitosamente");
        return response;
    }
    
}
