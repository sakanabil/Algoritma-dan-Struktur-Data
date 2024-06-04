package Pertemuan13.tugas;

class Film25 {
int id;
String judul;
double rating;
Film25 prev, next;

    Film25(int id, String judul, double rating) {
        this.id = id;
        this.judul = judul;
        this.rating = rating;
    }
}