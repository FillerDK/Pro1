package model;

import java.util.ArrayList;

public class Seat {
    private int row;
    private int num;
    private int price;
    private SeatType seatType;

    public Seat(int row, int num, int price, SeatType seatType) {
        this.row = row;
        this.num = num;
        this.price = price;
        this.seatType = seatType;
    }

    public int getRow() {
        return row;
    }

    public int getNum() {
        return num;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("Row: %d Num %d (%d Kr %s)\n", row, num, price, seatType);
    }

}
