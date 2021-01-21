@Test public void copyNodeWithChild() throws Exception {
  mk.commit("/","+\"a\" : { \"b\" : {} }",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  mk.commit("/","*\"a\" : \"c\"",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/c",null));
  assertTrue(mk.nodeExists("/c/b",null));
}
