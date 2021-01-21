@Test public void testMove2() throws Exception {
  allow(path,modifyChildCollection);
  try {
    move(childNPath,destPath);
    fail("Move requires addChildNodes and removeChildNodes privilege.");
  }
 catch (  AccessDeniedException e) {
  }
}
