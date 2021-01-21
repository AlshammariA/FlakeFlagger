@Test public void removeNodeWithChildren() throws Exception {
  mk.commit("/","+\"a\" : { \"b\" : {},  \"c\" : {}, \"d\" : {}}",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/a/c",null));
  assertTrue(mk.nodeExists("/a/d",null));
  mk.commit("/","-\"a/b\"",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertFalse(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/a/c",null));
  assertTrue(mk.nodeExists("/a/d",null));
}
