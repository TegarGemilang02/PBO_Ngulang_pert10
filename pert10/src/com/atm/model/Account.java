package com.atm.model;

import java.util.Scanner;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    public static final double MINIMUM_BALANCE = 50000;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    // Getter dan Setter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        if (amount <= 0) {
            System.out.println("Jumlah setoran harus lebih besar dari nol.");
            return;
        }
        // Proses penyetoran
        this.balance += amount;
        System.out.println("Setoran berhasil. Saldo Anda sekarang: " + this.balance);
    }
    
    public void debit(double amountToWithdraw) {
        if (amountToWithdraw <= 0) {
            System.out.println("Jumlah penarikan harus lebih besar dari nol.");
            return;
        }

        // Cek apakah saldo cukup setelah penarikan
        if (this.balance - amountToWithdraw < MINIMUM_BALANCE) {
            System.out.println("Penarikan gagal. Saldo setelah penarikan harus minimal Rp" + MINIMUM_BALANCE + ".");
            return;
        }

        // Proses penarikan
        this.balance -= amountToWithdraw;
        System.out.println("Penarikan berhasil. Saldo Anda sekarang: " + this.balance);
    }

    // Metode untuk memverifikasi PIN lama
    private boolean verifyPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }


    public void changePin() {
        Scanner scanner = new Scanner(System.in);

        // Verifikasi PIN lama
        System.out.print("Masukkan PIN lama: ");
        String oldPin = scanner.nextLine();
        
        if (!verifyPin(oldPin)) {
            System.out.println("PIN lama salah. Ubah PIN gagal.");
            return;
        }

        // Minta nasabah memasukkan PIN baru dua kali
        System.out.print("Masukkan PIN baru: ");
        String newPin1 = scanner.nextLine();
        System.out.print("Masukkan ulang PIN baru: ");
        String newPin2 = scanner.nextLine();

        // Validasi bahwa kedua input PIN baru cocok
        if (!newPin1.equals(newPin2)) {
            System.out.println("PIN baru tidak cocok. Ubah PIN gagal.");
            return;
        }
        // Perbarui PIN jika validasi berhasil
        this.pin = newPin1;
        System.out.println("PIN berhasil diubah.");
    }

}