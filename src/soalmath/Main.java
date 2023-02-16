package soalmath;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("Selamat Datang di kuis Matematika Java! Ketik S untuk Mulai atau E untuk Exit ");
		String respon = sc.nextLine();
		if (respon.equals("E") || respon.equals("e")) {
			System.exit(0);
		}
		
		final int jumlah_soal = 5;
		int jumlah_benar = 0;
		int count = 0;
		long waktu_mulai = System.currentTimeMillis();
		String output = " ";
		
		while (count < jumlah_soal) {
			int angka1 = ThreadLocalRandom.current().nextInt(0,100); // random angka dari 0 - 100 
			int angka2 = (int) (Math.random()*100);
			
			System.out.println("Jawaban pertanyaan berikut : ");
			System.out.println(angka1 + " + " + angka2 + " = ?");
			int jawaban = sc.nextInt();
			
			int kunci = angka1 + angka2;
			if (jawaban == kunci) {
				System.out.println("Jawaban Anda benar!" + "\n");
				count++;
				jumlah_benar++;
			}
			else {
				System.out.println("Jawaban Anda Salah!" + "\n");
				System.out.println("Jawaban yang benar adalah = "+ kunci + "\n");
				count++;
			}
			output += "\n" + angka1 + " + " + angka2 + " = " + jawaban + " >> " + ((jawaban == kunci) ? "Benar" : "Salah");
		}
		long waktu_finish = System.currentTimeMillis();
		long waktu_tempuh = waktu_finish - waktu_mulai;
		
		System.out.println("-----------------------------------");
		System.out.println("Berikut hasilnnya : " + output);
		System.out.println("\n" + "Anda Menjawab benar sebanyak " + jumlah_benar + " soal");
		System.out.println("Waktu yang ditempuh adalah " + (waktu_tempuh / 1000) + " detik");
		System.out.println("-----------------------------------");
		
		sc.nextLine();
	}
	}
}
