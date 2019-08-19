package builder;

public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String fathersName;
    private String mothersName;
    private double height;
    private double weight;

    public Person(String firstName, String middleName, String lastName, int age, String fathersName, String mothersName, double height, double weight) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.height = height;
        this.weight = weight;
    }

    public static class Builder {

        private String firstName;
        private String middleName;
        private String lastName;
        private int age;
        private String fathersName;
        private String mothersName;
        private double height;
        private double weight;

        public Builder() {}

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder fathersName(String fathersName) {
            this.fathersName = fathersName;
            return this;
        }

        public Builder mothersName(String mothersName) {
            this.mothersName = mothersName;
            return this;
        }

        public Builder height(double height) {
            this.firstName = firstName;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Person build() {
            return new Person(firstName, middleName, lastName, age, fathersName, mothersName, height, weight);
        }
    }
}
