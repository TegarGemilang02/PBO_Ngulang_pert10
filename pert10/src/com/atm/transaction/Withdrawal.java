package com.atm.transaction;

import com.atm.model.Account;
import java.util.Scanner;

public class Withdrawal extends Transaction {

    public Withdrawal(Account account) {
        super(account);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah penarikan: ");
        double amountToWithdraw = scanner.nextDouble();
        double currentBalance = this.account.getBalance();

        //meriksa apakah saldo setelah penarikan tidak kurang dari saldo minimal
        if (currentBalance - amountToWithdraw < Account.MINIMUM_BALANCE) {
            System.out.println("Penarikan gagal. Saldo setelah penarikan minimal Rp50,000.");
        } else {
         //Lanjutkan proses penarikan
            this.account.debit(amountToWithdraw);
            System.out.println("Penarikan berhasil. Saldo saat ini: " + this.account.getBalance());
        }
    }
}