package com.damarie.reportcard;

import java.util.ArrayList;

public class ReportCard {

    private String mStudentName;
    private double mEnglishGrade;
    private double mHistoryGrade;
    private double mScienceGrade;
    private double mArtGrade;
    private double mHealthGrade;

    private ArrayList mEnglishGrades;
    private ArrayList mHistoryGrades;
    private ArrayList mScienceGrades;
    private ArrayList mArtGrades;
    private ArrayList mHealthGrades;

    public ReportCard(String studentName) {
        mStudentName = studentName;

        mEnglishGrade = 0;
        mHistoryGrade = 0;
        mScienceGrade = 0;
        mArtGrade = 0;
        mHealthGrade = 0;
    }

    public String getStudentName() {
        return mStudentName;
    }

    public double getEnglishGrade() {
        return mEnglishGrade;
    }

    public double getHistoryGrade() {
        return mHistoryGrade;
    }

    public double getScienceGrade() {
        return mScienceGrade;
    }

    public double getArtGrade() {
        return mArtGrade;
    }

    public double getHealthGrade() {
        return mHealthGrade;
    }

    public void addEnglishGrade(double grade) {
        double tempSum = 0;
        mEnglishGrades.add(grade);
        for (int count = 0; count < mEnglishGrades.size(); count++) {
            tempSum += (double) mEnglishGrades.get(count);
        }
        mEnglishGrade = tempSum / mEnglishGrades.size();
    }

    public void addHistoryGrade(double grade) {
        double tempSum = 0;
        mHistoryGrades.add(grade);
        for (int count = 0; count < mHistoryGrades.size(); count++) {
            tempSum += (double) mHistoryGrades.get(count);
        }
        mHistoryGrade = tempSum / mHistoryGrades.size();
    }

    public void addScienceGrade(double grade) {
        double tempSum = 0;
        mScienceGrades.add(grade);
        for (int count = 0; count < mScienceGrades.size(); count++) {
            tempSum += (double) mScienceGrades.get(count);
        }
        mScienceGrade = tempSum / mScienceGrades.size();
    }

    public void addArtGrade(double grade) {
        double tempSum = 0;
        mArtGrades.add(grade);
        for (int count = 0; count < mArtGrades.size(); count++) {
            tempSum += (double) mArtGrades.get(count);
        }
        mArtGrade = tempSum / mArtGrades.size();
    }

    public void addHealthGrade(double grade) {
        double tempSum = 0;
        mHealthGrades.add(grade);
        for (int count = 0; count < mHealthGrades.size(); count++) {
            tempSum += (double) mHealthGrades.get(count);
        }
        mHealthGrade = tempSum / mHealthGrades.size();
    }

    @Override
    public String toString() {
        String tempReportCard;
        tempReportCard = "Name: " + getStudentName() + ";";
        tempReportCard = tempReportCard + "English Grade: " + getEnglishGrade() + ";";
        tempReportCard = tempReportCard + "History Grade: " + getStudentName() + ";";
        tempReportCard = tempReportCard + "Science Grade: " + getScienceGrade() + ";";
        tempReportCard = tempReportCard + "Art Grade: " + getArtGrade() + ";";
        tempReportCard = tempReportCard + "Health Grade: " + getHealthGrade();

        return tempReportCard;
    }
}
