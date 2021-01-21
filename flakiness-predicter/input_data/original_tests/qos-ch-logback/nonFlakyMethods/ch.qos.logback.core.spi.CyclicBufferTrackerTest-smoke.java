@Test public void smoke(){
  long now=3000;
  CyclicBuffer<Object> cb=tracker.getOrCreate(key,now);
  assertEquals(cb,tracker.getOrCreate(key,now++));
  now+=CyclicBufferTracker.DEFAULT_TIMEOUT + 1000;
  tracker.removeStaleComponents(now);
  assertEquals(0,tracker.liveKeysAsOrderedList().size());
  assertEquals(0,tracker.getComponentCount());
}
