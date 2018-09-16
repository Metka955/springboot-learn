package com.metka.test;

import java.io.File;
import java.net.URL;

public class ScanPackageTest {
	
	public static void main(String[] args) {
		scanPackage("com.metka");
	}
	public static void scanPackage(String basePackage) {
		
		URL url=ScanPackageTest.class
				.getResource("/"+basePackage.replace(".", "/"));
		String str=url.getFile();
		File f=new File(str);
		
		
		
		for(File file:f.listFiles()) {
			
			if(file.isDirectory()) {
				scanPackage(basePackage+"."+file.getName());
			}else {
				System.out.println(file.getName());
			}
		}
		
	}
}
