@Test public void copyNode() throws Exception {
  mk.commit("/","+\"a\" : {}",null,null);
  assertTrue(mk.nodeExists("/a",null));
  mk.commit("/","*\"a\" : \"b\"",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/b",null));
}
