@Test public void copyNodeWithNestedChildren() throws Exception {
  mk.commit("/","+\"a\" : { \"b\" : { \"c\" : { \"d\" : {} } } }",null,null);
  assertTrue(mk.nodeExists("/a",null));
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/a/b/c",null));
  assertTrue(mk.nodeExists("/a/b/c/d",null));
  mk.commit("/","*\"a\" : \"e\"",null,null);
  assertTrue(mk.nodeExists("/e",null));
  assertTrue(mk.nodeExists("/e/b",null));
  assertTrue(mk.nodeExists("/e/b/c",null));
  assertTrue(mk.nodeExists("/e/b/c/d",null));
  mk.commit("/","*\"e/b\" : \"f\"",null,null);
  assertTrue(mk.nodeExists("/f",null));
  assertTrue(mk.nodeExists("/f/c",null));
  assertTrue(mk.nodeExists("/f/c/d",null));
}
