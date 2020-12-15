package Alex07133_Main;
import Alex07133_Entity.Alex07133_PetugasEntity;
import Alex07133_Entity.Alex07133_PelangganEntity;
import Alex07133_Entity.Alex07133_DaftarPelangganEntity;
import Alex07133_Entity.Alex07133_CameraEntity;
import Alex07133_Model.Alex07133_DaftarPelangganModel;
import Alex07133_Model.Alex07133_PelangganModel;
import Alex07133_Model.Alex07133_PetugasModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner; 
public class Alex07133_main {
    private static Alex07133_PetugasModel petugasModel = new Alex07133_PetugasModel(); //encapsulatin, prosees pembungkusan data atribut dan method menjadi satu
    private static Alex07133_PelangganModel pelangganModel = new Alex07133_PelangganModel();
    private static Alex07133_DaftarPelangganModel daftarPelangganmodel = new Alex07133_DaftarPelangganModel();
    private static Scanner input = new Scanner (System.in);
    private static int pilCamera;
    static int cekpelanggan;
    static int cekPetugas;
 
    
    public static void main(String[] args) { 
        Alex07133_main data = new Alex07133_main();
        data.viewMenu(); //untuk mengurangi keyword static pada program, kita mendefinisikan ulang obyek rental camera menghubungkan pada method view menu
    }
    
    void viewMenu(){
        datapetugas(); 
        int loop=0;
        do{
           int pilih = 0;
           System.out.print("Selamat Datang Di RENTAL CAMERA !!" +
                            "\n 1. Login" +
                            "\n 2. Daftar Pelanggan" +
                            "\n 3. Lihat Data Petugas" +
                            "\n 4. Lihat Data Camera" +
                            "\n 0. Stop" +
                            "\n Masukkan Pilihan Anda : ");
                        pilih = input.nextInt();
                        if(pilih == 1){
                            int pilLogin = 0;
            System.out.print("1. Login petugas" + "\n2. Login pelanggan" + "\n Pilih : ");
                pilLogin = input.nextInt();
                if(pilLogin == 1){
                    loginPetugas();
                   
                   
                    
                }else{
                    loginPelanggan();
                }
            }else if(pilih == 2){
                register();
            }else if(pilih == 3){
                petugasModel.view();
            }else if (pilih == 4){
               for(int i=0;i<Alex07133_CameraEntity.merk.length;i++){
                    System.out.println(i+". "+Alex07133_CameraEntity.merk[i]);
               }
            }else{
                break;
            }
        }while (loop != 1);
    }

        void datapetugas(){
        String id[] = {"01","02","03"};
        String nama [] = {"astrid","sabrina","alex"};
        String alamat [] = {"mojokerto","mojokerto","sidoarjo"};
        String noIdentitas [] = {"01","02","03"};
        String notelp [] = {"01","02","03"};
              for(int i=0;i<id.length;i++){
                petugasModel.insertPetugas(new Alex07133_PetugasEntity(id[i],nama[i],alamat[i],
                noIdentitas[i],notelp[i]));
            }
    }
        void register(){
        System.out.print("Input ID = ");
        String id = input.next();
        System.out.print("Input nama = ");
        String nama = input.next();
        System.out.print("Input Alamat = ");
        String alamat = input.next();
        System.out.print("Input no Identitas = ");
        String noIdentitas =  input.next();
        System.out.print("Input no Telepon = ");
        String notelp =  input.next();
        System.out.print("Input Tgl sewa (dd/mm/yyyy) = ");
        Date Tgl_sewa = new Date(input.next());
        System.out.print("Input Tgl sewa (dd/mm/yyyy) = ");
        Date Tgl_kembali = new Date(input.next());
        pelangganModel.insert(new Alex07133_PelangganEntity(id,nama,alamat,noIdentitas,notelp,
        Tgl_sewa,Tgl_kembali));
    }
        void loginPelanggan(){
        System.out.print("ID : ");
        String id = input.next();
        System.out.print("Nama : ");
        String nama = input.next();
        cekpelanggan = pelangganModel.cekData(id, nama);
        System.out.println("Selamat datang "+pelangganModel.getpelangganEntityArrayList(cekpelanggan)
        .getnama());
        int cekppelanggan = daftarPelangganmodel.cekData(id, nama);
        if (cekppelanggan == -1){
            System.out.println("Anda belum memilih kamera");
                daftarcamera();
        }else if(cekppelanggan == -2){
            System.out.println("Anda belum memilih kamera");
                daftarcamera();
        }else{
        System.out.println("Nama = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnama());
        System.out.println("id = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getId());
        System.out.println("No identitas = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnoIdentitas());
        System.out.println("No telp = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnotelp());
        System.out.println("camera = "+Alex07133_CameraEntity.merk[daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getIndexCamera()]);
        System.out.println("Tgl sewa           : "+new SimpleDateFormat(" dd - MM - yyyy").format(daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getTgl_sewa()));
        System.out.println("Tgl sewa           : "+new SimpleDateFormat(" dd - MM - yyyy").format(daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getTgl_kembali()));
        System.out.println("isVerified = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).isIsVerified());
        
        }
    }
        void daftarcamera(){
        System.out.print("Pilih Camera = \n");
        for(int i=0;i<Alex07133_CameraEntity.merk.length;i++){
        System.out.println(i+". "+Alex07133_CameraEntity.merk[i]);
        }
        System.out.print("Pilih Camera = ");
            pilCamera = input.nextInt();
        daftarPelangganmodel.insertDataPelanggan(new Alex07133_DaftarPelangganEntity(pilCamera,
                pelangganModel.getpelangganEntityArrayList(cekpelanggan),false));
    }
        void loginPetugas(){
        System.out.print("id : ");
        String id = input.next();
        System.out.print("nama: ");
        String nama = input.next();
        cekPetugas = petugasModel.cekData(id,nama);
        System.out.println("Selamat Datang "+petugasModel.showDataPetugas(cekPetugas).getnama());
        pelangganModel.view();
        updateIsverified();
    }
        void updateIsverified(){
        System.out.print("id : ");
        String id = input.next();
        System.out.print("nama: ");
        String nama = input.next();
        System.out.println("========================================");
        int cekpelanggan = daftarPelangganmodel.cekData(id, nama);
        System.out.println("Nama = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnama());
        System.out.println("id = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getId());
        System.out.println("No identitas = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnoIdentitas());
        System.out.println("No telp = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnotelp());
        System.out.println("camera = "+Alex07133_CameraEntity.merk[daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getIndexCamera()]);
        System.out.println("Tgl sewa           : "+new SimpleDateFormat(" dd - MM - yyyy").format(daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getTgl_sewa()));
        System.out.println("Tgl sewa           : "+new SimpleDateFormat(" dd - MM - yyyy").format(daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getTgl_kembali()));
        System.out.println("isVerified = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).isIsVerified());
        daftarPelangganmodel.updateIsVerified(cekpelanggan, new Alex07133_DaftarPelangganEntity(pilCamera,
        pelangganModel.getpelangganEntityArrayList(cekpelanggan),true));
    }
}