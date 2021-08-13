package service;


import models.LoaiSanPham;
import models.SanPham;

import java.util.ArrayList;

public class SanPhamService {
    public ArrayList<SanPham> list = new ArrayList<>();
    public ArrayList<LoaiSanPham> loaisanPhams = new ArrayList<>();
    public SanPhamService(){
        loaisanPhams.add(new LoaiSanPham("keo"));
        loaisanPhams.add(new LoaiSanPham("banh"));
        list.add(new SanPham(1,"keo",2000,loaisanPhams.get(0).getLoaiSP()));
        list.add(new SanPham(1,"orio",2000,loaisanPhams.get(1).getLoaiSP()));

    }

    public void save (SanPham sanPham){
        list.add(sanPham);
    }

    public void delete(int index){
        list.remove(index);
    }

    public void edit(SanPham sanPham,int index){
        list.set(index,sanPham);
    }

}
