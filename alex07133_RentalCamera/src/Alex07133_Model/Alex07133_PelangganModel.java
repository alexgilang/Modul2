package Alex07133_Model;
import Alex07133_Entity.Alex07133_CameraEntity;
import Alex07133_Entity.Alex07133_PelangganEntity;
import Alex07133_Model.Alex07133_DaftarPelangganModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Alex07133_PelangganModel implements Alex07133_ModeIinterfaces { //inhiritence mewariskan interface=hanya mengandung deklarasi method 
    private ArrayList<Alex07133_PelangganEntity> pelangganEntityArrayList;
     
     public Alex07133_PelangganModel(){
        pelangganEntityArrayList = new ArrayList<Alex07133_PelangganEntity>();
    }
public void insert(Alex07133_PelangganEntity pelangganEntity){
    pelangganEntityArrayList.add(pelangganEntity);  
}
 @Override
    public void view(){
        for(Alex07133_PelangganEntity pelangganEntity : pelangganEntityArrayList){
            System.out.println("===========================================");
            System.out.println(" ID : "+pelangganEntity.getId()+"\n Nama : "
            +pelangganEntity.getnama()+"\n Alamat : "+pelangganEntity.getalamat()+
            "\n No Identitas: "+pelangganEntity.getnoIdentitas()+"\n No Telepon : "
            +pelangganEntity.getnotelp()
            +"\n tgl sewa : " +new SimpleDateFormat(" dd - MM - yyyy").format(pelangganEntity.getTgl_sewa())       
            +"\n tgl Kembali : " +new SimpleDateFormat(" dd - MM - yyyy").format(pelangganEntity.getTgl_kembali()));
                      
            System.out.println("===========================================");
        }
    }
    public int cekData(String id, String nama){
        int loop = 0;
        while (!pelangganEntityArrayList.get(loop).getId().equals(id) && 
                !pelangganEntityArrayList.get(loop).getnama().equals(nama)){
            loop++;
        }
        return loop;
    }
    public Alex07133_PelangganEntity getpelangganEntityArrayList(int index){
        return pelangganEntityArrayList.get(index);
    }
}
