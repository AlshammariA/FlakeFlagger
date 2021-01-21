@Test public void testNodeTypes() throws Exception {
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
  String matchContentSimple="//*[( jcr:contains(., 'dog') and @jcr:primaryType = 'nt:file' )]";
  assertQuery(matchContentSimple,"xpath",ImmutableList.of("/myFolder/myFile"));
  String matchContentDouble="//*[( jcr:contains(., 'dog') and (@jcr:primaryType = 'nt:file' or @jcr:primaryType = 'nt:folder') )]";
  assertQuery(matchContentDouble,"xpath",ImmutableList.of("/myFolder","/myFolder/myFile"));
}
