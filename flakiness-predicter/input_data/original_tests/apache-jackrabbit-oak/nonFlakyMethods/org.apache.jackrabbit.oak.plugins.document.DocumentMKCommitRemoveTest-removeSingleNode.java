@Test public void removeSingleNode() throws Exception {
  mk.commit("/","+\"a\" : {}",null,null);
  assertNodesExist(null,"/a");
  mk.commit("/","-\"a\"",null,null);
  assertNodesNotExist(null,"/a");
}
