@Test public void addDuplicateNode() throws Exception {
  mk.commit("/","+\"a\" : {}",null,null);
  try {
    mk.commit("/","+\"a\" : {}",null,null);
    fail("Exception expected");
  }
 catch (  Exception expected) {
  }
}
