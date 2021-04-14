
package pajak;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pajak {
    public enum Jabatan{
        GENERALMANAGER, MANAGER, ASSISTANTMANAGER, SENIORENGINEER, JUNIORENGINEER, TEKNISI, DRIVER
    }
    public double hitungBiayaJabatan(Jabatan namaJabatan, String tanggalPengangkatan, String tanggalPerhitungan){
        double biayaJabatan;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
        LocalDate lcPengangkatan = LocalDate.parse(tanggalPengangkatan, formatter);
        LocalDate lcPerhitungan = LocalDate.parse(tanggalPerhitungan, formatter);
        
        int tahunPengangkatan = lcPengangkatan.getYear();
        int tahunPerhitungan = lcPerhitungan.getYear();
        int bulanPengangkatan = lcPengangkatan.getMonthValue();
        int bulanPerhitungan = lcPerhitungan.getMonthValue();
        if(lcPerhitungan.compareTo(lcPengangkatan)>0){
            //proses perhitungan
            int jumlahBulan;
            
            if(tahunPengangkatan == tahunPerhitungan){
                jumlahBulan = bulanPerhitungan - bulanPengangkatan;
            }
            else{
                jumlahBulan = bulanPerhitungan - 1;    
            }
            
            double gajiPokokPerBulan;
            double tunjanganJabatanPerBulan;
            if(namaJabatan == Jabatan.GENERALMANAGER){
               gajiPokokPerBulan = 9000000;
               tunjanganJabatanPerBulan = 5000000;
            }
            else if(namaJabatan == Jabatan.MANAGER){
               gajiPokokPerBulan = 8000000;
               tunjanganJabatanPerBulan = 4000000;
            }
            else if (namaJabatan == Jabatan.ASSISTANTMANAGER){
               gajiPokokPerBulan = 6000000;
               tunjanganJabatanPerBulan = 3000000;
            }
            else if (namaJabatan == Jabatan.SENIORENGINEER){
                gajiPokokPerBulan = 3500000;
                tunjanganJabatanPerBulan = 2000000;
            }
            else if (namaJabatan == Jabatan.JUNIORENGINEER){
                gajiPokokPerBulan = 3000000;
                tunjanganJabatanPerBulan = 1500000;
            }
            else if (namaJabatan == Jabatan.TEKNISI){
                gajiPokokPerBulan = 2000000;
                tunjanganJabatanPerBulan = 1000000;
            }
            else if(namaJabatan == Jabatan.DRIVER){
                gajiPokokPerBulan = 1500000;
                tunjanganJabatanPerBulan = 750000; 
            }
            else {
                gajiPokokPerBulan = 1500000;
                tunjanganJabatanPerBulan = 750000; 
            }
            
            double JKK = gajiPokokPerBulan * 0.24 / 100.0;
            double JKM = gajiPokokPerBulan * 0.3 / 100.0;
            double JHT = gajiPokokPerBulan * 3.74 / 100.0;
            double BPJSKesehatan = gajiPokokPerBulan * 4 / 100.0;
            
            double penghasilanBrutoSetahun = jumlahBulan * (gajiPokokPerBulan + tunjanganJabatanPerBulan + JKK + JKM + JHT + BPJSKesehatan);
            
            biayaJabatan = penghasilanBrutoSetahun * 5.0 / 100.0;
            if(biayaJabatan > 6000000)
                biayaJabatan = 6000000;
        }
        else{
            biayaJabatan = 0;
        }
        
        return biayaJabatan;
    }
}
