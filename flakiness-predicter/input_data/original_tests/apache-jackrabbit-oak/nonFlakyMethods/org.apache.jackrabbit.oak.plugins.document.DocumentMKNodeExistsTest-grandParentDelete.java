@Test public void grandParentDelete() throws Exception {
  mk.commit("/","+\"a\" : { \"b\" : { \"c\" : { \"d\" : {} } } }",null,"Add /a/b/c/d");
  mk.commit("/a","-\"b\"",null,"Remove /b");
  boolean exists=mk.nodeExists("/a/b/c/d",null);
  assertFalse(exists);
}
