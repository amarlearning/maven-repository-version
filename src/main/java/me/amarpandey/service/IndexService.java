package me.amarpandey.service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import me.amarpandey.utils.Constants;

@Service
public class IndexService {

  public String submitXML(String xmlData) {

    Model model = null;
    StringWriter writer = new StringWriter();
    Reader reader = new StringReader(xmlData);
    MavenXpp3Reader xpp3Reader = new MavenXpp3Reader();

    try {
      model = xpp3Reader.read(reader);
    } catch (IOException | XmlPullParserException e) {
      e.printStackTrace();
    }

    List<Dependency> dependencyList = model.getDependencies();

    for (int i = 0; i < dependencyList.size(); i++) {

      String updatedVersion = null;
      String groupId = dependencyList.get(i).getGroupId();
      String artifactId = dependencyList.get(i).getArtifactId();

      try {
        updatedVersion = this.getLatestVersion(groupId, artifactId);
      } catch (Exception e) {
        e.printStackTrace();
      }

      dependencyList.get(i).setVersion(updatedVersion);
    }

    try {
      new MavenXpp3Writer().write(writer, model);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return writer.toString();
  }

  private String getLatestVersion(String groupid, String artifactid) {

    Document document = null;
    String mavenRepositoryURL = null;

    mavenRepositoryURL = this.generateMavenRepositoryURL(groupid, artifactid);

    try {
      document = Jsoup.connect(mavenRepositoryURL).get();
    } catch (IOException e) {
      e.printStackTrace();
    }

    Element linkText = document.select("a[href].vbtn.release").first();

    return linkText.html();
  }

  private String generateMavenRepositoryURL(String groupid, String artifactid) {

    StringBuilder sbuilder = new StringBuilder();

    sbuilder.append(Constants.BASE_URL);
    sbuilder.append("/");
    sbuilder.append(groupid);
    sbuilder.append("/");
    sbuilder.append(artifactid);

    return sbuilder.toString();
  }
}
