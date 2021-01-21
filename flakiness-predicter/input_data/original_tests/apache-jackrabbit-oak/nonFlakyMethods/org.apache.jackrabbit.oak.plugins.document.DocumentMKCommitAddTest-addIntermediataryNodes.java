@Test public void addIntermediataryNodes() throws Exception {
  String rev1=mk.commit("/","+\"a\" : { \"b\" : { \"c\": {} }}",null,null);
  String rev2=mk.commit("/","+\"a/d\" : {} +\"a/b/e\" : {}",null,null);
  assertTrue(mk.nodeExists("/a/b/c",rev1));
  assertFalse(mk.nodeExists("/a/b/e",rev1));
  assertFalse(mk.nodeExists("/a/d",rev1));
  assertTrue(mk.nodeExists("/a/b/c",rev2));
  assertTrue(mk.nodeExists("/a/b/e",rev2));
  assertTrue(mk.nodeExists("/a/d",rev2));
}
