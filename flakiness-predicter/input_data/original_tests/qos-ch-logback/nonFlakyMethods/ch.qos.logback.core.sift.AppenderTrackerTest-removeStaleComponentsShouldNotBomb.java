@Test public void removeStaleComponentsShouldNotBomb(){
  appenderTracker.removeStaleComponents(now);
  assertEquals(0,appenderTracker.getComponentCount());
}
