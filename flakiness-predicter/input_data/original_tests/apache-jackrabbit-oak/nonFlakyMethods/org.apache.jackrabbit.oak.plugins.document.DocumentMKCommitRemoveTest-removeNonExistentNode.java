@Test public void removeNonExistentNode() throws Exception {
  try {
    mk.commit("/","-\"a\"",null,null);
    fail("Exception expected");
  }
 catch (  Exception expected) {
  }
}
