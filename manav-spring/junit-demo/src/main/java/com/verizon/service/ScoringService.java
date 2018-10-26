package com.verizon.service;

import com.verizon.exception.ScoreException;
import com.verizon.model.Grade;

public class ScoringService {

	public Grade getGrade(double avg){
		Grade g =  null;
		if(avg>=90) g= Grade.A;
		else  if(avg>=80) g=Grade.B;
		else  if(avg>=70) g=Grade.C;
		else g =Grade.F;
		return g;
	}
	
	public double getPercentage(int[] marks,int maxMarksInEachSubjects)throws ScoreException
	{
		if(maxMarksInEachSubjects<=0)
			 throw new ScoreException("Invalid max marks");
		
		if(marks==null||marks.length==0)
			throw new ScoreException("No marks Recieved");
		double totalMaxScore = maxMarksInEachSubjects*marks.length;
		
		double totalScore=0;
		for(int score:marks){
			if(score<0)
				throw new ScoreException("One of Scores is negative");
			totalScore+=score;
		}
		double percent = (totalScore/totalMaxScore)*100;
		return percent;
	}
}
