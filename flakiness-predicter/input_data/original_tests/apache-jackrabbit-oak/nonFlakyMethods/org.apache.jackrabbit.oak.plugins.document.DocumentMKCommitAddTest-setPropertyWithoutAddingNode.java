@Test public void setPropertyWithoutAddingNode() throws Exception {
  try {
    mk.commit("/","^\"a/key1\" : \"value1\"",null,null);
    fail("Exception expected");
  }
 catch (  Exception expected) {
  }
}
