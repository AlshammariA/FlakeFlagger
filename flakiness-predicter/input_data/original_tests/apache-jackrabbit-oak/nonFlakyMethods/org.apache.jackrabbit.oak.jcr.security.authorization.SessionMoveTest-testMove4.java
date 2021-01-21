@Test public void testMove4() throws Exception {
  allow(path,privilegesFromName(PrivilegeConstants.REP_WRITE));
  move(childNPath,destPath);
  deny(path,privilegesFromName(Privilege.JCR_ADD_CHILD_NODES));
  try {
    move(destPath,childNPath);
    fail("Move requires addChildNodes and removeChildNodes privilege.");
  }
 catch (  AccessDeniedException e) {
  }
}
