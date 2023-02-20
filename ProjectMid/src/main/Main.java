package main;

import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import main.Karyawan;

public class Main {
	
	static ArrayList<Karyawan> karyawanList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	int countManager=0, countSupervisor=0, countAdmin=0;
	
public Main() {
	Scanner scanner = new Scanner(System.in);
    int menu;

    do {
        System.out.println("Menu:");
        System.out.println("1. Insert data karyawan");
        System.out.println("2. View data karyawan");
        System.out.println("3. Update data karyawan");
        System.out.println("4. Delete data karyawan");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
        menu = scanner.nextInt();

        switch (menu) {
            case 1:
                insertKaryawan();
                break;
            case 2:
                viewKaryawan();
                break;
            case 3:
                updateKaryawan();
                break;
            case 4:
                deleteKaryawan();
                break;
            case 5:
                System.out.println("Terima kasih");
                break;
            default:
                System.out.println("Menu tidak tersedia");
        }
    } while (menu != 5);
    scanner.close();
}    	
	public static void main(String[] args) {
		new Main();
		
    }
     

	public static void insertKaryawan() {
		
		String kode, nama, jenis, jabatan;
	    int gaji;
	    int countManager=0 ,countSupervisor = 0, countAdmin = 0; 
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kode karyawan: ");
        kode = scanner.nextLine();

        System.out.print("Nama Karyawan: ");
        nama = scanner.nextLine();
        while (nama.length() < 3) {
            System.out.println("Nama karyawan minimal 3 huruf.");
            System.out.print("Nama Karyawan: ");
            nama = scanner.nextLine();
        }

        System.out.print("Jenis Kelamin (Laki-Laki / Perempuan): ");
        jenis = scanner.nextLine();
        while (!jenis.equals("Laki-Laki") && !jenis.equals("Perempuan")) {
            System.out.println("Jenis kelamin hanya bisa memilih (Laki-Laki / Perempuan)");
            System.out.print("Jenis Kelamin (Laki-Laki / Perempuan): ");
            jenis = scanner.nextLine();
        }

        System.out.print("Jabatan (Manager / Supervisor / Admin): ");
        jabatan = scanner.nextLine();
        while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin")) {
            System.out.println("Jabatan hanya bisa memilih (Manager / Supervisor / Admin)");
            System.out.print("Jabatan (Manager / Supervisor / Admin): ");
            jabatan = scanner.nextLine();
        }
        
        if (jabatan.equals("Manager")) {
            gaji = 8000000;
            countManager++;
        } else if (jabatan.equals("Supervisor")) {
            gaji = 6000000;
            countSupervisor++;
        } else {
            gaji = 4000000;
            countAdmin++;
        }

        if (jabatan.equals("Manager") && countManager % 3 == 0) {
            gaji += (gaji * 0.1);
        } else if (jabatan.equals("Supervisor") && countSupervisor % 3 == 0) {
            gaji += (gaji * 0.075);
        } else if (jabatan.equals("Admin") && countAdmin % 3 == 0) {
            gaji += (gaji * 0.05);
        }

	
        }
		
	public static void viewKaryawan() {
		 if (karyawanList.size() == 0) {
		        System.out.println("Belum ada data karyawan yang tersimpan");
		    } else {
		     
		        Collections.sort(karyawanList, Comparator.comparing(Karyawan::getKode));

		        
		        System.out.printf("%-10s %-20s %-15s %-15s %-10s\n", "Kode", "Nama", "Jenis Kelamin", "Jabatan", "Gaji");

		        
		        for (Karyawan karyawan : karyawanList) {
		            System.out.printf("%-10s %-20s %-15s %-15s %-10d\n", karyawan.getKode(), karyawan.getNama(), karyawan.getJenisKelamin(), karyawan.getJabatan(), karyawan.getGaji());
		        }
		    }
	}

	public static void updateKaryawan() {
		Scanner scanner = new Scanner(System.in);

	    System.out.print("Masukkan kode karyawan: ");
	    String kode = scanner.nextLine();

	    Karyawan karyawanToUpdate = null;
	    for (Karyawan karyawan : karyawanList) {
	        if (karyawan.getKode().equals(kode)) {
	            karyawanToUpdate = karyawan;
	            break;
	        }
	    }

	    if (karyawanToUpdate == null) {
	        System.out.println("Karyawan dengan kode " + kode + " tidak ditemukan");
	        return;
	    }

	    System.out.println("Data karyawan dengan kode " + kode + ":");
	    System.out.println(karyawanToUpdate);

	    System.out.println("Masukkan data baru (kosongkan jika tidak ingin diubah):");

	    System.out.print("Nama karyawan: ");
	    String nama = scanner.nextLine();
	    if (!nama.isEmpty()) {
	        while (nama.length() < 3) {
	            System.out.println("Nama karyawan minimal 3 huruf.");
	            System.out.print("Nama Karyawan: ");
	            nama = scanner.nextLine();
	        }
	        karyawanToUpdate.setNama(nama);
	    }

	    System.out.print("Jenis Kelamin (Laki-Laki / Perempuan): ");
	    String jenis = scanner.nextLine();
	    if (!jenis.isEmpty()) {
	        while (!jenis.equals("Laki-Laki") && !jenis.equals("Perempuan")) {
	            System.out.println("Jenis kelamin hanya bisa memilih (Laki-Laki / Perempuan)");
	            System.out.print("Jenis Kelamin (Laki-Laki / Perempuan): ");
	            jenis = scanner.nextLine();
	        }
	        karyawanToUpdate.setJenis(jenis);
	    }

	    System.out.print("Jabatan (Manager / Supervisor / Admin): ");
	    String jabatan = scanner.nextLine();
	    if (!jabatan.isEmpty()) {
	        while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin")) {
	            System.out.println("Jabatan hanya bisa memilih (Manager / Supervisor / Admin)");
	            System.out.print("Jabatan (Manager / Supervisor / Admin): ");
	            jabatan = scanner.nextLine();
	        }
	        karyawanToUpdate.setJabatan(jabatan);

	        if (jabatan.equals("Manager")) {
	            karyawanToUpdate.setGaji(8000000);
	        } else if (jabatan.equals("Supervisor")) {
	            karyawanToUpdate.setGaji(6000000);
	        } else {
	            karyawanToUpdate.setGaji(4000000);
	        }
	    }

	    System.out.println("Data karyawan dengan kode " + kode + " telah diubah");
	    System.out.println(karyawanToUpdate);
	}
	public static void deleteKaryawan() {
		 Scanner scanner = new Scanner(System.in);

		    System.out.print("Masukkan kode karyawan: ");
		    String kode = scanner.nextLine();

		    boolean kodeDitemukan = false;
		    for (Karyawan karyawan : karyawanList) {
		        if (karyawan.getKode().equals(kode)) {
		            karyawanList.remove(karyawan);
		            kodeDitemukan = true;
		            System.out.println("Data karyawan dengan kode " + kode + " berhasil dihapus.");
		            break;
		        }
		    }
		    
		    if (!kodeDitemukan) {
		        System.out.println("Data karyawan dengan kode " + kode + " tidak ditemukan.");
		    }
	}
	
}
