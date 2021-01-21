@Test public void destroy(){
  long now=3000;
  CyclicBuffer<Object> cb=tracker.getOrCreate(key,now);
  cb.add(new Object());
  assertEquals(1,cb.length());
  tracker.endOfLife(key);
  now+=CyclicBufferTracker.LINGERING_TIMEOUT + 10;
  tracker.removeStaleComponents(now);
  assertEquals(0,tracker.liveKeysAsOrderedList().size());
  assertEquals(0,tracker.getComponentCount());
  assertEquals(0,cb.length());
}
