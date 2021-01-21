@SuppressWarnings("deprecation") @Test public void nodeTypeConstraint() throws Exception {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  Node folder1=root.addNode("folder1","nt:folder");
  Node folder2=root.addNode("folder2","nt:folder");
  JcrUtils.putFile(folder1,"file","text/plain",new ByteArrayInputStream("foo bar".getBytes("UTF-8")));
  folder2.addNode("folder3","nt:folder");
  session.save();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q=qm.createQuery("//element(*, nt:folder)",Query.XPATH);
  Set<String> paths=new HashSet<String>();
  for (RowIterator it=q.execute().getRows(); it.hasNext(); ) {
    paths.add(it.nextRow().getPath());
  }
  assertEquals(new HashSet<String>(Arrays.asList("/folder1","/folder2","/folder2/folder3")),paths);
}
