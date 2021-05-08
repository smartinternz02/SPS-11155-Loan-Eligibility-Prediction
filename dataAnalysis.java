package org.loan;

import java.io.IOException;

import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BoxTrace;
import tech.tablesaw.plotly.traces.HistogramTrace;

public class dataAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Reading the training dataset in a dataframe using Tablesaw
			Table loantrain_data = Table.read().csv("D:\\bootcamp\\org.loan\\src\\main\\java\\org\\loan\\trainfinal.csv");
			System.out.println("----TRAIN DATA SET----");
			System.out.print("shape:");
			System.out.println(loantrain_data.shape());
			System.out.println();
			System.out.println("Summary of train set");
			System.out.println(loantrain_data.summary());
			System.out.println();
			System.out.println(loantrain_data.structure());
			
			//Reading the test dataset in a dataframe using tablesaw
			Table loantest_data = Table.read().csv("D:\\bootcamp\\org.loan\\src\\main\\java\\org\\loan\\testfinal.csv");
			System.out.println();
			System.out.println("----TEST DATA SET----");
			System.out.print("shape:");
			System.out.println(loantest_data.shape());
			System.out.println();
			System.out.println("Summary of test set");
			System.out.println(loantest_data.summary());
			System.out.println();
			System.out.println(loantest_data.structure());
			
			//histogram of variable ApplicantIncome for training dataset
			Layout layout1 = Layout.builder().title("ApplicantIncome train").build();
			HistogramTrace trace1 = HistogramTrace.builder(loantrain_data.nCol("ApplicantIncome")).build();
			Plot.show(new Figure(layout1,trace1));

            // Box Plot for variable ApplicantIncome of training data set
		    Layout layout2 = Layout.builder().title(" Loan status train").build();
		    BoxTrace trace2 =BoxTrace.builder(loantrain_data.categoricalColumn("Loan_Status"), loantrain_data.nCol("ApplicantIncome")).build();
		    Plot.show(new Figure(layout2, trace2));
		    
		  //histogram of variable ApplicantIncome for testing dataset
			Layout layout3 = Layout.builder().title("ApplicantIncome test").build();
			HistogramTrace trace3 = HistogramTrace.builder(loantest_data.nCol("ApplicantIncome")).build();
			Plot.show(new Figure(layout3,trace3));

            // Box Plot for variable ApplicantIncome of testing data set
		    Layout layout4 = Layout.builder().title(" Loan status test").build();
		    BoxTrace trace4 =BoxTrace.builder(loantest_data.categoricalColumn("Loan_Status"), loantest_data.nCol("ApplicantIncome")).build();
		    Plot.show(new Figure(layout4, trace4));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
