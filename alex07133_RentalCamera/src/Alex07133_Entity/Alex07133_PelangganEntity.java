package Alex07133_Entity;
import java.util.Date;
public class Alex07133_PelangganEntity extends Alex07133_Rentalcamera {  //menerapkan inheritence/pewarisan, dimana petugas mewarisi data abstract, subclass
                                                        //superclass
    protected Date tgl_sewa,tgl_kembali; //atribut
    public Alex07133_PelangganEntity(String id,String nama,
    String alamat, String noIdentitas,String notelp,Date tgl_sewa,Date tgl_kembali){
        super(id,nama,alamat,noIdentitas,notelp);//memanggil construktor dari superclass
        this.tgl_sewa=tgl_sewa;
        this.tgl_kembali=tgl_kembali;
}
 @Override   //pendefinisian ulang method yang sama pada subclass
    public String getId() {
        return id;
    }

    public Date getTgl_sewa() {
        return tgl_sewa;
    }

    public Date getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_sewa(Date tgl_sewa) {
        this.tgl_sewa = tgl_sewa;
    }

    public void setTgl_kembali(Date tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }
    
}
