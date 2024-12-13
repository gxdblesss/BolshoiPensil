package prac2;
//Task5
public class Dog {
        private String name;
        private int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


        public int getHumanAge() {
            return age * 7;
        }


        @Override
        public String toString() {
            return "Собака: " + name + ", Возраст: " + age + " лет (человеческий возраст: " + getHumanAge() + " лет)";
        }
    }

    class DogsBudka {
        public static void main(String[] args) {
            Dog[] dogs = new Dog[4];

            dogs[0] = new Dog("Бобик", 3);
            dogs[1] = new Dog("Шарик", 5);
            dogs[2] = new Dog("Тузик", 2);
            dogs[3] = new Dog("Грелка", 10);



            for (Dog dog : dogs) {
                System.out.println(dog);
            }
        }
    }


