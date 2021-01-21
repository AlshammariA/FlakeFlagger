@Test public void testKnownSize(){
  Iterable<Integer> s;
  PrefetchIterator<Integer> it;
  s=seq(0,100);
  it=new PrefetchIterator<Integer>(s.iterator(),5,0,10,200);
  assertEquals(200,it.size());
}
