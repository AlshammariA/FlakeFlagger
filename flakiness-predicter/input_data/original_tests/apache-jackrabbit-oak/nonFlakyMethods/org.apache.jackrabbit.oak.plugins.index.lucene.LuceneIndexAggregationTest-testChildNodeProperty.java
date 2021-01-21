@Test public void testChildNodeProperty() throws Exception {
  Tree file=root.getTree("/").addChild("myFile");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE,Type.NAME);
  Tree resource=file.addChild(JCR_CONTENT);
  resource.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource.setProperty("jcr:lastModified",Calendar.getInstance());
  resource.setProperty("jcr:encoding","UTF-8");
  resource.setProperty("jcr:mimeType","text/plain");
  resource.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy dog."));
  resource.setProperty("jcr:title","title");
  resource.setProperty("jcr:description","description");
  root.commit();
  String matchChildSimple="//*[( jcr:contains(@jcr:title, 'title') )]";
  assertQuery(matchChildSimple,"xpath",ImmutableList.of("/myFile/jcr:content"));
  String matchChildWithStar="//*[( jcr:contains(., 'dog') and jcr:contains(@jcr:title, 'title') )]";
  assertQuery(matchChildWithStar,"xpath",ImmutableList.of("/myFile/jcr:content"));
}
