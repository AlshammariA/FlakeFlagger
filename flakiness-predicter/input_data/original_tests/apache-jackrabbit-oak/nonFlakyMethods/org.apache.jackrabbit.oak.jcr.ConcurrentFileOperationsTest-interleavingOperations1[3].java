@Test public void interleavingOperations1() throws Exception {
  Node folder1=testRootNode.addNode("folder1","nt:unstructured");
  Node folder2=testRootNode.addNode("folder2","nt:unstructured");
  Node file1=addFile(session.getNode(folder1.getPath()),"file1.tmp");
  Node file2=addFile(session.getNode(folder2.getPath()),"file2.tmp");
  session.save();
  Session s1=createAdminSession();
  Session s2=createAdminSession();
  try {
    rename(s1.getNode(file1.getPath()),"file1.bin");
    rename(s2.getNode(file2.getPath()),"file2.bin");
    s1.save();
    s2.save();
  }
  finally {
    s1.logout();
    s2.logout();
  }
}
