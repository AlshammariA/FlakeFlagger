@Test public void query() throws Exception {
  setTravesalEnabled(false);
  Tree t=root.getTree("/");
  child(t,"a","nt:unstructured");
  child(t,"b","nt:unstructured");
  child(t,"c","nt:folder");
  child(t,"d","nt:folder");
  mixLanguage(t,"e");
  mixLanguage(t,"f");
  NodeUtil n=new NodeUtil(root.getTree("/oak:index"));
  createIndexDefinition(n,"nodetype",false,new String[]{JCR_PRIMARYTYPE,JCR_MIXINTYPES},new String[]{"nt:folder","mix:language"});
  root.commit();
  assertQuery("select [jcr:path] from [nt:unstructured] ",new ArrayList<String>());
  assertQuery("select [jcr:path] from [nt:folder] ",of("/c","/d"));
  assertQuery("select [jcr:path] from [mix:language] ",of("/e","/f"));
  setTravesalEnabled(true);
}
