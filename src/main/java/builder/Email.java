package builder;

import java.util.HashSet;
import java.util.Set;

public class Email {

    private final String title;
    private final String recipients;
    private final String message;

    public Email(String title, String recipients, String message) {
        this.title = title;
        this.recipients = recipients;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getRecipients() {
        return recipients;
    }

    public String getMessage() {
        return message;
    }

    public static class EmailBuilder {

        private Set recipients = new HashSet();
        private String title;
        private String greeting;
        private String mainTest;
        private String closing;

        public EmailBuilder addRecipient(String recipient) {
            this.recipients.add(recipient);
            return this;
        }

        public EmailBuilder removeRecipient(String recipient) {
            this.recipients.remove(recipient);
            return this;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGreeting(String greeting) {
            this.greeting = greeting;
        }

        public void setMainTest(String mainTest) {
            this.mainTest = mainTest;
        }

        public void setClosing(String closing) {
            this.closing = closing;
        }

        public Email build() {

            String message = greeting + "\n" + mainTest + "\n" + closing;
            String recipientSection = commaSeparatedRecipients();

            return new Email(title, recipientSection, message);
        }

        private String commaSeparatedRecipients() {

            StringBuilder stringBuilder = new StringBuilder();
            recipients.forEach(recipient -> {
                stringBuilder.append(",").append(recipient);
            });

            return stringBuilder.toString().replaceFirst(",","");
        }
    }
}
