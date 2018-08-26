using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// Using system mailing
using System.Net.Mail;

/// <summary>
/// Summary description for clsBusinessLayer
/// </summary>
public class clsBusinessLayer
{
    public clsBusinessLayer() {}

    public static bool SendEmail(string Sender, string Recipient, string bcc, string cc,
string Subject, string Body)
    {
        try
        {
            // Create new Mailer Message Object
            MailMessage MyMailMessage = new MailMessage();
            // Mailer From
            MyMailMessage.From = new MailAddress(Sender);
            // Mailer Recipients
            MyMailMessage.To.Add(new MailAddress(Recipient));
            // Check if any one need to be added to email
            if (bcc != null && bcc != string.Empty)
            {
                // Add BCC to Email
                MyMailMessage.Bcc.Add(new MailAddress(bcc));
            }
            // Check if any one need to have CC
            if (cc != null && cc != string.Empty)
            {
                // Add CC to the mail
                MyMailMessage.CC.Add(new MailAddress(cc));
            }
            // Mailer subject
            MyMailMessage.Subject = Subject;
            // Mailer Body
            MyMailMessage.Body = Body;
            // Render the mail as HTML
            MyMailMessage.IsBodyHtml = true;
            // Set Mail Priority
            MyMailMessage.Priority = MailPriority.Normal;
            // Set SMTP Client to localHost
            SmtpClient MySmtpClient = new SmtpClient("localhost");
            //SMTP Port = 25;
            //Generic IP host = "127.0.0.1";
            // Send the Email
            MySmtpClient.Send(MyMailMessage);
            // If the mail sent return true
            return true;
        }
        catch (Exception ex)
        {
            // If error occured then return false;
            return false;
        }
    }
}