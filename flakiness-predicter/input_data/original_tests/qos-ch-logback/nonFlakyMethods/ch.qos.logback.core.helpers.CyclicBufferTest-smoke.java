@Test public void smoke(){
  CyclicBuffer<String> cb=new CyclicBuffer<String>(2);
  assertSize(cb,0);
  cb.add("zero");
  assertSize(cb,1);
  cb.add("one");
  assertSize(cb,2);
  cb.add("two");
  assertSize(cb,2);
  assertEquals("one",cb.get());
  assertSize(cb,1);
  assertEquals("two",cb.get());
  assertSize(cb,0);
}
