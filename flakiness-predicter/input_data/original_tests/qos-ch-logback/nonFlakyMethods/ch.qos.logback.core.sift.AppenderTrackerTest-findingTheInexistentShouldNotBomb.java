@Test public void findingTheInexistentShouldNotBomb(){
  assertNull(appenderTracker.find(key));
  now+=AppenderTracker.DEFAULT_TIMEOUT + 1;
  appenderTracker.removeStaleComponents(now);
  assertNull(appenderTracker.find(key));
}
