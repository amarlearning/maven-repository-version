package com.amarpandey;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MavenRepositoryVersion {

	public static void main(String[] args) {

		String groupid = null;
		String artifactid = null;
		Document document = null;
		String mavenRepositoryURL = null;
		
		try(Scanner input = new Scanner(System.in)) {
			
			System.out.print("Enter the GroupId : ");
			groupid = input.nextLine();
			
			System.out.print("Enter the ArtifactId : ");
			artifactid = input.nextLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mavenRepositoryURL = generateMavenRepositoryURL(groupid, artifactid);
		
		try {
			document = Jsoup.connect(mavenRepositoryURL).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Element linkText = document.select("a[href].vbtn.release").first();
		
		System.out.println("Latest version of this maven repository is : " + linkText.html());
		
	}
	
	
	public static String generateMavenRepositoryURL(String groupid, String artifactid) {
		
		StringBuilder sbuilder = new StringBuilder();
		
		sbuilder.append(Constants.BASE_URL);
		sbuilder.append(groupid);
		sbuilder.append("/");
		sbuilder.append(artifactid);
		
		return sbuilder.toString();
	}

}
