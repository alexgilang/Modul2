package Alex07133_Model; //
import Alex07133_Entity.Alex07133_DaftarPelangganEntity; //mengaksees
import Alex07133_Entity.Alex07133_CameraEntity;
import Alex07133_Entity.Alex07133_PetugasEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat; //tanggal
import java.util.ArrayList; //objek arraylist
public class Alex07133_DaftarPelangganModel implements Alex07133_ModeIinterfaces { //inhiritence mewariskan interface=hanya mengandung deklarasi method 
    private ArrayList<Alex07133_DaftarPelangganEntity> daftarpelangganArrayList;
    public Alex07133_DaftarPelangganModel(){
    daftarpelangganArrayList = new ArrayList<Alex07133_DaftarPelangganEntity>();
        }
    public void insertDataPelanggan(Alex07133_DaftarPelangganEntity daftarpelanggan){
        daftarpelangganArrayList.add(daftarpelanggan);
    }
    public ArrayList<Alex07133_DaftarPelangganEntity> getdaftarpelangganArrayList(){
        return daftarpelangganArrayList;
    }
    @Override //memanggil method dari class
    public void view(){ //menampilkan data dari
        for(Alex07133_DaftarPelangganEntity daftarpelanggan : daftarpelangganArrayList){
        System.out.println("===========================================");
        System.out.print("ID : "+daftarpelanggan.getPelanggan().getId()+"\n Nama : "
        +daftarpelanggan.getPelanggan().getnama()+"\n Alamat "+daftarpelanggan.getPelanggan().getalamat()+
        "\n No Identitas "+daftarpelanggan.getPelanggan().getnoIdentitas()+
        "\n No Telepon "+daftarpelanggan.getPelanggan().getnotelp()+
        "\n Camera: "+Alex07133_CameraEntity.merk[daftarpelanggan.getIndexCamera()]+
        "\n Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(daftarpelanggan.getPelanggan().getTgl_sewa())+
         "\n Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(daftarpelanggan.getPelanggan().getTgl_kembali())+
        "\n IsVerified : ");
        if(daftarpelanggan.isIsVerified() == false){
        System.out.println("Belum Di Verifikasi Petugas");
        }else{
        System.out.println("Telah Di Verifikasi");
            }
        System.out.println("===========================================");
        }
    }
    public int cekData(String id, String nama){
        int loop = 0;
        if(daftarpelangganArrayList.size() ==0){
            loop = -1;//data kosong
        }else{
            for(int i = 0; i <daftarpelangganArrayList.size(); i++){
            if(daftarpelangganArrayList.get(i).getPelanggan().getId().equals(id)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
    public Alex07133_DaftarPelangganEntity showDaftarPelanggan(int index){
        return daftarpelangganArrayList.get(index);
    }
    public void updateIsVerified(int index,Alex07133_DaftarPelangganEntity daftarpelanggan){
    daftarpelangganArrayList.set(index, daftarpelanggan);
    }
}
