public class Main {
    public static void main(String[] args) {

        //task 1
        GeometricFigure circle = new Circle(7);
        GeometricFigure triangle = new Triangle(2, 3);
        GeometricFigure square = new Square(2);


        GeometricFigure[] geometricFigures = {circle, triangle, square};


        totalArea(geometricFigures);

        //task 2
        Participant human = new Human(100, 1);
        Participant robot = new Robot(200, 2);
        Participant cat = new Cat(500, 4);


        Obstacle wall = new Wall(3);
        Obstacle racetrack = new Racetrack(150);


        Participant[] participants = {human, robot, cat};
        Obstacle[] obstacles = {racetrack, wall};


        test(participants, obstacles);

    }

    public static void totalArea(GeometricFigure[] geometrics) {
        float result = 0;
        for (GeometricFigure geometric : geometrics) {
            result += geometric.getArea();
        }
        System.out.println("Total area of all figures = " + result);



        System.out.println();

    }



    public static void test(Participant[] participants, Obstacle[] obstacles) {
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (obstacle.toString().contains("Racetrack")) {
                    if (participant.getRunDistance() >= obstacle.overcome()) {
                        participant.run();
                        System.out.println("passed the racetrack");
                    } else {
                        participant.run();
                        System.out.println("did not pass the racetrack");
                        System.out.println("The passed distance: " + participant.getRunDistance() + " out of " + obstacle.overcome());
                        break;
                    }
                } else {
                    if (participant.getJumpDistance() >= obstacle.overcome()) {
                        participant.jump();
                        System.out.println("passed the wall");
                    } else {
                        participant.jump();
                        System.out.println("did not pass the wall");
                        System.out.println("The passed height: " + participant.getJumpDistance() + " out of " + obstacle.overcome());
                        break;
                    }

                }
            }
        }
    }
}