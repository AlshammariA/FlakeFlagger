@Test public void empty0(){
  long now=3000;
  tracker.removeStaleComponents(now);
  assertEquals(0,tracker.liveKeysAsOrderedList().size());
  assertEquals(0,tracker.getComponentCount());
}
