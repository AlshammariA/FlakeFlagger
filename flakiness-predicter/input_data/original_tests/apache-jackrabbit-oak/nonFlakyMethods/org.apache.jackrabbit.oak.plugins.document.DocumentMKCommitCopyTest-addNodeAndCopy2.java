@Test public void addNodeAndCopy2(){
  mk.commit("/","+\"a\":{}",null,null);
  mk.commit("/","+\"a/b\":{}",null,null);
  mk.commit("/","*\"a/b\":\"c\"",null,null);
  assertTrue(mk.nodeExists("/a/b",null));
  assertTrue(mk.nodeExists("/c",null));
}
