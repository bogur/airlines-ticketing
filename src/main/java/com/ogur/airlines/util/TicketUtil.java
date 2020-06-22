package com.ogur.airlines.util;

import java.util.Random;

public class TicketUtil
{
    public static final String TICKET_BUY = "SATIN AL";
    public static final String TICKET_SOLD = "SATIN ALINDI";
    public static final String TICKET_CANCEL = "İPTAL";

    public static final int CAPACITY_PERCENT = 10;

    /*
     *
     */
    public static String generateTicketNumber( String prefix, int capacity )
    {
        Random r = new Random( );
        int low = 1;
        int high = capacity;
        int result = r.nextInt(high-low) + low;

        return prefix + "-" +  result;
    }

    public static String maskCreditCardNumber( String cardNumber)
    {
        String maskedCardNumber = ignoreCharOfCardNumbers( cardNumber);
        maskedCardNumber= maskedString(maskedCardNumber, 6, 12, '*');

        return maskedCardNumber;
    }

    private static String ignoreCharOfCardNumbers( String cardNumber )
    {
        StringBuilder sb = new StringBuilder( );

        for (int i = 0; i < cardNumber.length(); i++)
        {
            if(Character.isDigit( cardNumber.charAt(i) ))  // just keep digit of card number.
            {
                sb.append(cardNumber.charAt(i));
            }
        }

        return sb.toString();
    }

    private static String maskedString( String cardNumber, int start, int end, char maskedChar)
    {
        int maskedLength = end - start;

        StringBuilder sb = new StringBuilder(maskedLength);

        for(int i = 0; i < maskedLength; i++)
        {
            sb.append(maskedChar);
        }

        return cardNumber.substring(0, start) + sb.toString()  + cardNumber.substring(start + maskedLength);
    }
}
