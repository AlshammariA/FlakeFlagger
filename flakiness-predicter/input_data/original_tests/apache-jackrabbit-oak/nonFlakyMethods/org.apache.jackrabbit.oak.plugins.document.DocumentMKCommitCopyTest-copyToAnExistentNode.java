@Test public void copyToAnExistentNode() throws Exception {
  mk.commit("/","+\"a\" : { \"b\" : {} }",null,null);
  mk.commit("/","+\"c\" : {}",null,null);
  try {
    mk.commit("/","*\"c\" : \"a/b\"",null,null);
    fail("Exception expected");
  }
 catch (  Exception expected) {
  }
}
