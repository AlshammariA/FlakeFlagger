@Test public void testChildNodeProperty2() throws Exception {
  Tree file=root.getTree("/").addChild("myFile");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE,Type.NAME);
  Tree resource=file.addChild(JCR_CONTENT);
  resource.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy dog."));
  resource.setProperty("jcr:title","title");
  resource.setProperty("jcr:description","description");
  Tree file2=root.getTree("/").addChild("myFile2");
  file2.setProperty(JCR_PRIMARYTYPE,NT_FILE,Type.NAME);
  Tree resource2=file2.addChild(JCR_CONTENT);
  resource2.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource2.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy dog."));
  resource2.setProperty("jcr:title","other");
  resource.setProperty("jcr:description","title");
  root.commit();
  String matchChildSimple="//*[( jcr:contains(jcr:content/@jcr:title, 'title') )]";
  assertQuery(matchChildSimple,"xpath",ImmutableList.of("/myFile"));
}
