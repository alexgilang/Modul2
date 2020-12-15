package Alex07133_Entity;
import java.util.Date;
public class Alex07133_PetugasEntity extends Alex07133_Rentalcamera{ //menerapkan inheritence/pewarisan, dimana petugas mewarisi data abstract, subclass
                                                        //superclass
    public Alex07133_PetugasEntity(String id,String nama,
    String alamat, String noIdentitas,String notelp){
        super(id,nama,alamat,noIdentitas,notelp); //memanggil construktor dari superclass
}
 @Override   //pendefinisian ulang method yang sama pada subclass
    public String getId() {
        return id;
    }
}

