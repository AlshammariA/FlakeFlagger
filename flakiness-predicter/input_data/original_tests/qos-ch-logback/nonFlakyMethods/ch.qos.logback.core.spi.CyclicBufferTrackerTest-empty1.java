@Test public void empty1(){
  long now=3000;
  assertNotNull(tracker.getOrCreate(key,now++));
  now+=ComponentTracker.DEFAULT_TIMEOUT + 1000;
  tracker.removeStaleComponents(now);
  assertEquals(0,tracker.liveKeysAsOrderedList().size());
  assertEquals(0,tracker.getComponentCount());
  assertNotNull(tracker.getOrCreate(key,now++));
}
