public class Dragon26 {
    int x, y, width, height;

    Dragon26(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void moveLeft() {
        x--;
        if (x < 0 || x > width) {
            detectCollision();
        }
    }

    void moveRight() {
        x++;
        if (x < 0 || x > width) {
            detectCollision();
        }
    }

    void moveUp() {
        y--;
        if (y < 0 || y > height) {
            detectCollision();
        }
    }

    void moveDown() {
        y++;
        if (y < 0 || y > height) {
            detectCollision();
        }
    }

    void printPosition() {
        System.out.println("Posisi Dragon: (" + x + ", " + y + ")");
    }

    void detectCollision() {
        System.out.println("Game Over");
    }
}