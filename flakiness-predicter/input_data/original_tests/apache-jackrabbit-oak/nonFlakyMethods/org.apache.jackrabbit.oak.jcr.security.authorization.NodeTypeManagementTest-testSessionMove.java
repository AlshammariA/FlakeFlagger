@Test public void testSessionMove() throws Exception {
  String parentPath=childNode.getParent().getPath();
  String srcPath=childNode.getPath();
  String destPath=parentPath + "/destination";
  try {
    testSession.move(srcPath,destPath);
    testSession.save();
    fail("Missing write privilege.");
  }
 catch (  AccessDeniedException e) {
  }
  modify(parentPath,Privilege.JCR_WRITE,true);
  try {
    testSession.move(srcPath,destPath);
    testSession.save();
    fail("Missing privilege jcr:nodeTypeManagement.");
  }
 catch (  AccessDeniedException e) {
  }
  modify(parentPath,REP_WRITE,true);
  testSession.move(srcPath,destPath);
  testSession.save();
}
