@Test public void nonExistingRevision() throws Exception {
  try {
    mk.getNodes("/","123",1,0,-1,null);
    fail("Exception expected");
  }
 catch (  Exception expected) {
  }
}
