package com.javanaut.stockAlertObserver.utility;

public class StaticMessages {
    public static final String SUBSCRIPTION_SUCCESS = """
    You are subscribed to this product.
    You will be notify once it is available.
""";
    public static final String SUBSCRIBE_MAIL_SUBJECT = "Your wait is over: %s is back!";
    public static final String SUBSCRIBE_MAIL_BODY = """
            <html> 
            <body> 
            <h1>Product Back in Stock!</h1> 
            <p>Dear Customer,</p> 
            <p>We are excited to inform you that the product you subscribed to, <strong>%s</strong>, is now back in stock!</p> 
            <p>Hurry and place your order before it runs out again.</p> 
            <p>Thank you for choosing us!</p> <br> 
            <p>Best regards,</p> 
            <p>ProductCart</p> 
            </body> 
            </html>
            """;
}
