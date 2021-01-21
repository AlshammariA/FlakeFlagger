@Test public void interleavingOperations2() throws Exception {
  Node folder1=testRootNode.addNode("folder1","nt:unstructured");
  Node folder2=testRootNode.addNode("folder2","nt:unstructured");
  addFile(testRootNode,"dummy");
  session.save();
  Session s1=createAdminSession();
  Session s2=createAdminSession();
  try {
    Node file1=addFile(s1.getNode(folder1.getPath()),"file1.tmp");
    Node file2=addFile(s2.getNode(folder2.getPath()),"file2.tmp");
    s1.save();
    s2.save();
    rename(file1,"file1.bin");
    rename(file2,"file2.bin");
    s1.save();
    s2.save();
  }
  finally {
    s1.logout();
    s2.logout();
  }
  session.refresh(false);
  assertTrue(session.nodeExists(folder1.getPath() + "/file1.bin"));
  assertFalse(session.nodeExists(folder1.getPath() + "/file1.tmp"));
  assertTrue(session.nodeExists(folder2.getPath() + "/file2.bin"));
  assertFalse(session.nodeExists(folder2.getPath() + "/file2.tmp"));
}
