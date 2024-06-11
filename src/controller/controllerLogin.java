/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoPegawai;
import java.util.List;
import javax.swing.JOptionPane;
import view.FormLogin;
import view.FormLupa;
import view.MenuUtama;
import view.FormPembelian;
/**
 *
 * @author Arif
 */
public class controllerLogin {
    FormLogin frame;
    List<Pegawai> listPeg;
    daoPegawai daoPeg = new daoPegawai();
    FormLupa lupa = new FormLupa();
    MenuUtama menu = new MenuUtama();
    FormPembelian fBeli = new FormPembelian();
    
    public controllerLogin(FormLogin frame){
        this.frame = frame;
        listPeg = daoPeg.getData();
    }
    
    public void cekData(){
        if((frame.getTxtusername().getText().equals("")) ||
                (frame.getTxtpassword().getText().equals(""))){
            JOptionPane.showMessageDialog(frame, "Username atau Password belum diisi");
            
        }else {
            Pegawai peg = daoPeg.cekUserPass(frame.getTxtusername().getText(), frmae.getTxtpassword().getText());
            if(peg.getKedepeg() != null){
                menu.setVisible(true);
                menu.setLblkodepeg(peg.getKodepeg());
                menu.setLblnamapeg(peg.getNamepeg());
                fBeli.setTxtpegawai(peg.getNamapeg());
                batal();
                frame.setViseble(false);
            } else {
                jOptionPane.showMessageDialog(frame, "Username atau Password salah");
            }
        }
    }
    
    public void lupaPass(){
        frame.dispose();
        lupa.setVisble(true);
    }
    
    public void batal(){
        frame.setTxtusername("");
        frame.seTxtpassword("");
    }
    
    public void keluar(){
        frame.dispose();
    }
}
