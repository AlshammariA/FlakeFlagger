@Test public void removeAndAddNode() throws Exception {
  String base=mk.commit("","+\"/a\":{}",null,null);
  String rev=mk.commit("","-\"/a\"",base,null);
  assertTrue(mk.nodeExists("/a",base));
  assertFalse(mk.nodeExists("/a",rev));
  mk.commit("","+\"/a\":{}",rev,null);
}
