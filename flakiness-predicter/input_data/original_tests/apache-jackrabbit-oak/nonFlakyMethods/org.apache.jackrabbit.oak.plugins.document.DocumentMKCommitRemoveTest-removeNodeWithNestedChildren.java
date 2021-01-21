@Test public void removeNodeWithNestedChildren() throws Exception {
  mk.commit("/","+\"a\" : { \"b\" : { \"c\" : { \"d\" : {} } } }",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/a/b/c",null));
  assertTrue(mk.nodeExists("/a/b/c/d",null));
  mk.commit("/","-\"a\"",null,null);
  assertFalse(mk.nodeExists("/a",null));
  assertFalse(mk.nodeExists("/a/b",null));
  assertFalse(mk.nodeExists("/a/b/c",null));
  assertFalse(mk.nodeExists("/a/b/c/d",null));
}
