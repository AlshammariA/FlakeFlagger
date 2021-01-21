@Test public void addNodeWithChildren() throws Exception {
  mk.commit("/","+\"a\" : { \"b\": {}, \"c\": {}, \"d\" : {} }",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/a/c",null));
  assertTrue(mk.nodeExists("/a/d",null));
}
