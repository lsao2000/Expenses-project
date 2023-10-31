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
    private LocalTime hour;
    private static LocalTime time ;
    private String timeText;

    public String getTimeText() {
        return timeText;
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

    public static ArrayList<Expenses> allExpense = new ArrayList<>();
    private ArrayList<Expenses> allDayExpenses = new ArrayList<Expenses>();
    private ArrayList<LocalTime> allTimeExpenses = new ArrayList<>();

    Expenses(){

    }
    Expenses(float moneyOfMonth){
        this.moneyOfMonth = moneyOfMonth;
    }
    Expenses(float expense, String note){
        this.expense = expense;
        this.note = note;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            time = LocalTime.now();
            hour = LocalTime.of(time.getHour(), time.getMinute(),time.getSecond());
        }
        setTime(hour);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public ArrayList<Expenses> getAllDayExpenses() {
        return allDayExpenses;
    }

    public void setAllDayExpenses(ArrayList<Expenses> allDayExpenses) {
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
        for (Expenses expenses : allDayExpenses){
            totalExpenses += expenses.expense;
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
        newExpense.setTimeText(String.valueOf(time));
        boolean allowAddExpense = true;
        int newday = Integer.parseInt(String.valueOf(newExpense.getDate()).split("\\-")[2]);
        int newMonth = Integer.parseInt(String.valueOf(newExpense.getDate()).split("\\-")[1]);
        int newYear = Integer.parseInt(String.valueOf(newExpense.getDate()).split("\\-")[0]);
        if(allExpense.size() > 0) {
            for (Expenses expenses : allExpense) {
                int day = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[2]);
                int month = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[1]);
                int year = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[0]);
                if (day == newday && month == newMonth && year == newYear) {
                    expenses.allDayExpenses.add(newExpense);
                    allowAddExpense = false;
                    break;
                }
            }
        }
        if(allowAddExpense){
            allExpense.add(newExpense);
            newExpense.allDayExpenses.add(newExpense);
        }
    }
    public static Expenses searchdate(LocalDate date1){
        Expenses getExpense = null;
        int year = Integer.parseInt(String.valueOf(date1).split("\\-")[0]);
        int month = Integer.parseInt(String.valueOf(date1).split("\\-")[1]);
        int day = Integer.parseInt(String.valueOf(date1).split("\\-")[2]);
        for (Expenses expenses :allExpense){
            int yearExpense = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[0]);
            int monthExpense = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[1]);
            int dayExpense = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[2]);
            if(year == yearExpense & month == monthExpense & day == dayExpense){
                getExpense = expenses;
            }
        }
        return  getExpense;
    }
    public static ArrayList<Expenses> searchdate(int month){
        ArrayList<Expenses> expensesArrayList = new ArrayList<>();
        for(Expenses expenses: allExpense){
            int month1 = Integer.parseInt(String.valueOf(expenses.getDate()).split("\\-")[1]);
            if(month1 == month){
                expensesArrayList.add(expenses);
            }
        }

        return  expensesArrayList;
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
