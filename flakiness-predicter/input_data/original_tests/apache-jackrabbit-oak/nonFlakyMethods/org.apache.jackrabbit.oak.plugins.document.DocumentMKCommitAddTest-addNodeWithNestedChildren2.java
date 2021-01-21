@Test public void addNodeWithNestedChildren2() throws Exception {
  mk.commit("/","+\"a\" : {}",null,null);
  mk.commit("/a","+\"b\" : {}",null,null);
  mk.commit("/a/b","+\"c\" : {}",null,null);
  mk.commit("/a","+\"d\" : {}",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/a/b/c",null));
  assertTrue(mk.nodeExists("/a/d",null));
}
