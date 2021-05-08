package org.loan;
import java.util.Arrays;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
public class logReg {
	public static void main(String[] args) throws Exception {
		DataSource source = new DataSource("D:\\bootcamp\\org.loan\\src\\main\\java\\org\\loan\\trainfinal1.arff");
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
	       
	    Classifier classifier = new weka.classifiers.functions.Logistic();
	    DataSource source1 = new DataSource("D:\\bootcamp\\org.loan\\src\\main\\java\\org\\loan\\testfinal1.arff");
	    Instances dataset1 = source.getDataSet();
	    dataset1.setClassIndex(dataset1.numAttributes()-1);
	       
	    classifier.buildClassifier(dataset);
	    //System.out.println(classifier);
	       
	    Evaluation eval = new Evaluation(dataset);
		eval.evaluateModel(classifier, dataset1);
		/** Print the algorithm summary */
		System.out.println("* Logistic Regression Evaluation with Datasets *");
		System.out.println(eval.toSummaryString());
		System.out.print(" the expression for the input data as per alogorithm is ");
		System.out.println(classifier);
			
		double confusion[][] = eval.confusionMatrix();
		System.out.println("Confusion Matrix...");
		for (double[] row : confusion)
			System.out.println( Arrays.toString(row));
	        System.out.println("--------------------------------------");
	        
	        System.out.println("Area under the curve");
	        System.out.println(eval.areaUnderROC(0));
	        System.out.println("----------------------------------------");
	        
	        
	        System.out.println(eval.getAllEvaluationMetricNames());;
	        
	        
	        System.out.println("Recall--");
	        System.out.println(Math.round(eval.recall(1)*100.0)/100.0);
	        
	        System.out.println("precison");
	        System.out.println(Math.round(eval.precision(1)*100.0)/100.0);
	       
	        System.out.println("F1 score");
	        System.out.println(Math.round(eval.fMeasure(1)*100.0)/100.0);
	        
	        System.out.println("Accuracy");
	        double acc = eval.correct()/(eval.correct()+eval.incorrect());
	        System.out.println(Math.round(acc*100.0)/100.0);
	        
	        
	        System.out.println("-----------");
	        Instance predict = dataset1.get(120);
	        
	        double value = classifier.classifyInstance(predict);
	        
	        System.out.println("Predicted label");
	        System.out.println(value);
	        
	        
	       
	       
		}

}
