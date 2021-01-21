@Test public void copyNodeWithChildren() throws Exception {
  mk.commit("/","+\"a\" : { \"b\" : {},  \"c\" : {}, \"d\" : {}}",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/a/c",null));
  assertTrue(mk.nodeExists("/a/d",null));
  mk.commit("/","*\"a\" : \"e\"",null,null);
  assertTrue(mk.nodeExists("/e",null));
  assertTrue(mk.nodeExists("/e/b",null));
  assertTrue(mk.nodeExists("/e/c",null));
  assertTrue(mk.nodeExists("/e/d",null));
}
