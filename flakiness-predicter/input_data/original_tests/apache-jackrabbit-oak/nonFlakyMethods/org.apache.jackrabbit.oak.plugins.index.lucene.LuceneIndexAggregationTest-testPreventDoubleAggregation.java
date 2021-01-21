@Test public void testPreventDoubleAggregation() throws Exception {
  Tree file=root.getTree("/").addChild("myFile");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE,Type.NAME);
  file.setProperty("jcr:title","fox");
  Tree resource=file.addChild(JCR_CONTENT);
  resource.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource.setProperty("jcr:lastModified",Calendar.getInstance());
  resource.setProperty("jcr:encoding","UTF-8");
  resource.setProperty("jcr:mimeType","text/plain");
  resource.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy dog."));
  root.commit();
  String matchChildSimple="//element(*, nt:file)[( jcr:contains(., 'fox') )]";
  assertQuery(matchChildSimple,"xpath",ImmutableList.of("/myFile"));
}
