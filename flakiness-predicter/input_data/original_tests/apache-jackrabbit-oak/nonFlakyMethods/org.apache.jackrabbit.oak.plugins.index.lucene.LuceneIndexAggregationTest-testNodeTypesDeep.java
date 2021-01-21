@Test public void testNodeTypesDeep() throws Exception {
  Tree folder=root.getTree("/").addChild("myFolder");
  folder.setProperty(JCR_PRIMARYTYPE,NT_FOLDER,Type.NAME);
  Tree folder2=folder.addChild("subfolder");
  folder2.setProperty(JCR_PRIMARYTYPE,"nt:unstructured",Type.NAME);
  Tree folder3=folder2.addChild("subsubfolder");
  folder3.setProperty(JCR_PRIMARYTYPE,"nt:unstructured",Type.NAME);
  file(folder3,"file");
  root.commit();
  String xpath="//element(*, nt:folder)[jcr:contains(., 'dog')]";
  assertQuery(xpath,"xpath",ImmutableList.of("/myFolder"));
}
