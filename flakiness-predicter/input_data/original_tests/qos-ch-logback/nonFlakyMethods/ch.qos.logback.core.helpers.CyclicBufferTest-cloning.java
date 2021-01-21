@Test public void cloning(){
  CyclicBuffer<String> cb=new CyclicBuffer<String>(2);
  cb.add("zero");
  cb.add("one");
  CyclicBuffer<String> clone=new CyclicBuffer<String>(cb);
  assertSize(clone,2);
  cb.clear();
  assertSize(cb,0);
  List<String> witness=Arrays.asList("zero","one");
  assertEquals(witness,clone.asList());
}
