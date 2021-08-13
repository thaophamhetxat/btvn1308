package models;

public class SanPham {
    int id;
    String name;
    int price;
    String loaiSP;

    public SanPham() {
    }

    public SanPham(int id, String name, int price, String loaiSP) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.loaiSP = loaiSP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }
}
