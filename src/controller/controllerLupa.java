/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;

/**
 *
 * @author Arif
 */
public class controllerLupa {
    FormLupa frame;
    daoPegawai daoPeg = new daoPegawai();
    Pegawai tambahPeg = new Pegawai();
    List<Pegawai> listPeg;
    
    public controllerLupa(FormLupa frame){{
        this.frame = frame;
        listPeg = daoPeg.getData();
    }
    
    public void ubahPass() {
        if(frame.getTxtusername().getText().equeals("")){
            JOptionPane.showMessageDialog(frame, "Username belum diisi",);
            
        }else {
            int row = daoPeg.cekUser(frame.getTxtusername().getText());
            if(row == 0){
                JOptionPane.showMessageDialog(frame, "Username tidak ditemukan");
                bersih();
            }
        }
    }
    
    public void keluar() {
        frmae.dispose();
        FormLogin flogin = new FormLogin();
        flogin.setVisible(true);
    }
    
    public void bersih(){
        frame.setTxtusername("");
        frame.setTxtpassword("");
    }
}
