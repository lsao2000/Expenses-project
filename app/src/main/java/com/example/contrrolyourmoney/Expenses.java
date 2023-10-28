package com.example.contrrolyourmoney;
import android.os.Build;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;
public class Expenses {
    private Float expense;
    private Float moneyOfMonth;
    private String note;
    private LocalDate date;
    private static LocalTime time ;
    public static ArrayList<Expenses> allExpense = new ArrayList<>();
    private ArrayList<Float> allDayExpenses = new ArrayList<>();
    private ArrayList<LocalTime> allTimeExpenses = new ArrayList<>();

    Expenses(){

    }
    Expenses(float moneyOfMonth){
        this.moneyOfMonth = moneyOfMonth;
    }
    Expenses(float expense, String note){
        this.expense = expense;
        this.note = note;
        if(allTimeExpenses.isEmpty()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                time = LocalTime.now();
            }
            allTimeExpenses.add(time);
            allDayExpenses.add(expense);
        }
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public ArrayList<Float> getAllDayExpenses() {
        return allDayExpenses;
    }

    public void setAllDayExpenses(ArrayList<Float> allDayExpenses) {
        this.allDayExpenses = allDayExpenses;
    }

    public Float getMoneyOfMonth() {
        return moneyOfMonth;
    }

    public void setMoneyOfMonth(Float moneyOfMonth) {
        this.moneyOfMonth = moneyOfMonth;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Float getExpense() {
        return expense;
    }

    public void setExpense(Float expense) {
        this.expense = expense;
    }

    public Float getTotalDayExpenses() {
        float totalExpenses = 0;
        for (Float expenses : allDayExpenses){
            totalExpenses += expense;
        }
        return totalExpenses;
    }

    public Float getTotalExpensesMonth(int month) {
        float totalExpensesMonth = 0;
        for (Expenses expenses: allExpense){
            int monthExpense = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[1]);
            if(monthExpense == month){
                totalExpensesMonth += expenses.getTotalDayExpenses();
            }
        }
        return totalExpensesMonth;
    }


    public LocalDate getDate() {
        return date;
    }

    public ArrayList<LocalTime> getallTimeExpenses() {
        return allTimeExpenses;
    }

    public void setallTimeExpenses(ArrayList<LocalTime> allTimeExpenses) {
        this.allTimeExpenses = allTimeExpenses;
    }

    public void setDate(LocalDate today) {
        this.date = today;
    }

    public ArrayList<Expenses> getAllExpense() {
        return allExpense;
    }

    public void setAllExpense(ArrayList<Expenses> allExpense) {
        Expenses.allExpense = allExpense;
    }
    public static void addExpense(Expenses newExpense){
        boolean allowAddExpense = true;
        int newday = Integer.parseInt(String.valueOf(newExpense.getDate()).split("\\-")[2]);
        int newMonth = Integer.parseInt(String.valueOf(newExpense.getDate()).split("\\-")[1]);
        int newYear = Integer.parseInt(String.valueOf(newExpense.getDate()).split("\\-")[0]);
        for (Expenses expenses: allExpense){
            int day = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[2]);
            int month = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[1]);
            int year = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[0]);
            if(day == newday && month == newMonth && year == newYear){
                expenses.getAllDayExpenses().add(newExpense.expense);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    time = LocalTime.now();
                }
                expenses.getallTimeExpenses().add(newExpense.getTime());
                expenses.allDayExpenses.add(newExpense.expense);
                allowAddExpense = false;
                break;
            }
        }
        if(allowAddExpense){
            allExpense.add(newExpense);
        }
    }
    public Expenses searchdate(LocalDate date1){
        Expenses getExpense = null;
        for (Expenses expenses :allExpense){
            if(expenses.equals(date1)){
                getExpense = expenses;
            }
        }
        return  getExpense;
    }

    public ArrayList<Expenses> listExpenseByMonth(int month){
        ArrayList<Expenses> list = new ArrayList<>();
        for(Expenses expenses : allExpense){
            int searchMonth = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[1]);
            if(searchMonth == month){
                list.add(expenses);
            }
        }
        return list;
    }

    @NonNull
    @Override
    public String toString() {
        return "Price : "+expense +" Product : "+note+ " Date : "+ date;
    }
}
