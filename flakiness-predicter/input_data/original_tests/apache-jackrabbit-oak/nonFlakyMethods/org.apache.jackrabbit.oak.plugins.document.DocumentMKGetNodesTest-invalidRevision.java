@Test public void invalidRevision() throws Exception {
  try {
    mk.getNodes("/","invalid",1,0,-1,null);
    fail("Exception expected");
  }
 catch (  Exception expected) {
  }
}
