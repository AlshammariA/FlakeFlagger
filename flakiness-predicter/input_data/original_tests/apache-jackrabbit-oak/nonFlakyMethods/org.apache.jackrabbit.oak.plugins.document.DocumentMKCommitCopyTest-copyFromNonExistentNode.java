@Test public void copyFromNonExistentNode() throws Exception {
  mk.commit("/","+\"a\" : {}",null,null);
  assertTrue(mk.nodeExists("/a",null));
  try {
    mk.commit("/","*\"b\" : \"c\"",null,null);
    fail("Exception expected");
  }
 catch (  Exception expected) {
  }
}
