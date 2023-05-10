package com.dell.listener;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

public class Ireporter implements IReporter{

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	System.out.println("generateReport");
	IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
    }

    @Override
    public IReporterConfig getConfig() {
	System.out.println("IReporterConfig");
	return IReporter.super.getConfig();
    }

}
