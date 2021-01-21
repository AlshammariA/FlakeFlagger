@Test public void testTimeout(){
  Iterable<Integer> s;
  PrefetchIterator<Integer> it;
  long timeout=10;
  s=seq(0,100,10);
  it=new PrefetchIterator<Integer>(s.iterator(),5,timeout,1000,-1);
  assertEquals(-1,it.size());
  s=seq(0,100);
  it=new PrefetchIterator<Integer>(s.iterator(),5,timeout,1000,-1);
  assertEquals(100,it.size());
}
