@Test public void addNodeWithNestedChildren() throws Exception {
  mk.commit("/","+\"a\" : { \"b\": { \"c\" : { \"d\" : {} } } }",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/a/b/c",null));
  assertTrue(mk.nodeExists("/a/b/c/d",null));
}
