package com.example.model;

/**
 * @author garden
 * @create 4/29/18
 */
public class EasyMail {
    private String receiptant;
    private String subject;

    private String trackingCode;
    private String carrier;
    private String updatedAt;
    private String location;
    private String status;

    public EasyMail(String receiptant, String subject, String trackingCode, String carrier, String updatedAt, String location, String status) {
        this.receiptant = receiptant;
        this.subject = subject;
        this.trackingCode = trackingCode;
        this.carrier = carrier;
        this.updatedAt = updatedAt;
        this.location = location;
        this.status = status;
        if (carrier == null){
            this.carrier = "unknown";
        }else if(updatedAt == null){
            this.updatedAt = "unknown";
        }else if(location == null){
            this.location = "unknown";
        }else if(status == null){
            this.status = "unknown";
        }
    }

    public String getReceiptant() {
        return receiptant;
    }

    public void setReceiptant(String receiptant) {
        this.receiptant = receiptant;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://www.w3.org/TR/REC-html40/loose.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width\">\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <title>Alerts e.g. approaching your limit</title>\n" +
                "    <style type=\"text/css\">\n" +
                "\n" +
                "        @media only screen and (max-width: 640px) {\n" +
                "            body {\n" +
                "                padding: 0 !important;\n" +
                "            }\n" +
                "            h1, h2, h3, h4 {\n" +
                "                font-weight: 800 !important;\n" +
                "                margin: 20px 0 5px !important;\n" +
                "            }\n" +
                "            h1 {\n" +
                "                font-size: 22px !important;\n" +
                "            }\n" +
                "            h2 {\n" +
                "                font-size: 18px !important;\n" +
                "            }\n" +
                "            h3 {\n" +
                "                font-size: 16px !important;\n" +
                "            }\n" +
                "            .container {\n" +
                "                padding: 0 !important;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "            .content {\n" +
                "                padding: 0 !important;\n" +
                "            }\n" +
                "            .content-wrap {\n" +
                "                padding: 10px !important;\n" +
                "            }\n" +
                "            .invoice {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        /*# sourceMappingURL=styles.css.map */\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;-webkit-font-smoothing:antialiased;-webkit-text-size-adjust:none;height:100%;line-height:1.6em;background-color:#f6f6f6;width:100% !important;'>\n" +
                "<table class=\"body-wrap\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;background-color:#f6f6f6;width:100%;'>\n" +
                "    <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "        <td style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;'></td>\n" +
                "        <td class=\"container\" width=\"600\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;display:block !important;max-width:600px !important;margin:0 auto !important;clear:both !important;'>\n" +
                "            <div class=\"content\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;max-width:600px;margin:0 auto;display:block;padding:20px;'>\n" +
                "                <table class=\"main\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;background-color:#fff;border:1px solid #e9e9e9;border-radius:3px;'>\n" +
                "                    <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                        <td class=\"alert alert-warning\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;font-size:16px;color:#fff;font-weight:500;padding:20px;text-align:center;border-radius:3px 3px 0 0;background-color:#FF9F00;'>\n" +
                "                            Package Update: "+trackingCode+"\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                        <td class=\"alert alert-warning\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;font-size:16px;color:#fff;font-weight:500;padding:20px;text-align:center;border-radius:3px 3px 0 0;background-color:#FF9F00;'>\n" +
                "                            Carrier: "+carrier+"\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                        <td class=\"content-wrap\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;padding:20px;'>\n" +
                "                            <table class=\"aligncenter\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;text-align:center;'>\n" +
                "                                <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                                    <td class=\"content-block\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;padding:0 0 20px;'>\n" +
                "                                        <strong style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>Congratulations, Your package is much closer.</strong>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                                    <td class=\"content-block\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;padding:0 0 20px;'>\n" +
                "                                        <a class=\"btn-primary\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;color:#348eda;text-decoration:underline;text-decoration:none;color:#FFF;background-color:#000000;border:solid #000000;border-width:10px 20px;line-height:2em;font-weight:bold;text-align:center;cursor:pointer;display:inline-block;border-radius:5px;text-transform:capitalize;'>The Current Location: "+location+"</a>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                                    <td class=\"content-block\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;padding:0 0 20px;'>\n" +
                "                                        <a class=\"btn-primary\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;color:#348eda;text-decoration:underline;text-decoration:none;color:#FFF;background-color:#000000;border:solid #000000;border-width:10px 20px;line-height:2em;font-weight:bold;text-align:center;cursor:pointer;display:inline-block;border-radius:5px;text-transform:capitalize;'>Updated at: "+updatedAt+"</a>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                                    <td class=\"content-block\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;padding:0 0 20px;'>\n" +
                "                                        <a class=\"btn-primary\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;color:#348eda;text-decoration:underline;text-decoration:none;color:#FFF;background-color:#000000;border:solid #000000;border-width:10px 20px;line-height:2em;font-weight:bold;text-align:center;cursor:pointer;display:inline-block;border-radius:5px;text-transform:capitalize;'>Current Status: "+status+"</a>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                                    <td class=\"content-block\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;padding:0 0 20px;'>\n" +
                "                                        Thanks for using PacTrack Service.\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "                <div class=\"footer\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;width:100%;clear:both;color:#999;padding:20px;'>\n" +
                "                    <table width=\"100%\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                        <tr style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;'>\n" +
                "                            <td class=\"aligncenter content-block\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;padding:0 0 20px;text-align:center;color:#999;font-size:12px;'>\n" +
                "                                <a href=\"http://www.mailgun.com\" style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;color:#348eda;text-decoration:underline;color:#999;font-size:12px;'>Unsubscribe</a> from these alerts.</td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "        <td style='margin:0;font-family:\"Helvetica Neue\", Helvetica, Arial, sans-serif;box-sizing:border-box;font-size:14px;vertical-align:top;'></td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
        return content;
    }

}
