@Test public void testDifferentNodes() throws Exception {
  Tree folder=root.getTree("/").addChild("myFolder");
  folder.setProperty(JCR_PRIMARYTYPE,NT_FOLDER,Type.NAME);
  Tree file=folder.addChild("myFile");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE,Type.NAME);
  file.setProperty("jcr:title","title");
  file.setProperty("jcr:description","description");
  Tree resource=file.addChild(JCR_CONTENT);
  resource.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource.setProperty("jcr:lastModified",Calendar.getInstance());
  resource.setProperty("jcr:encoding","UTF-8");
  resource.setProperty("jcr:mimeType","text/plain");
  resource.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy dog."));
  root.commit();
  assertQuery("//element(*, nt:file)[jcr:contains(., 'dog')]","xpath",ImmutableList.of("/myFolder/myFile"));
  assertQuery("//element(*, nt:file)[jcr:contains(., 'title')]","xpath",ImmutableList.of("/myFolder/myFile"));
  assertQuery("//element(*, nt:file)[jcr:contains(., 'dog') and jcr:contains(., 'title')]","xpath",ImmutableList.of("/myFolder/myFile"));
}
