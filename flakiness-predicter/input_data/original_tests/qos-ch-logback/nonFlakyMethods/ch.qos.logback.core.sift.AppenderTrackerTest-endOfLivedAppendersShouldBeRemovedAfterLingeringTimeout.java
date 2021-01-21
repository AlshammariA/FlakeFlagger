@Test public void endOfLivedAppendersShouldBeRemovedAfterLingeringTimeout(){
  Appender a=appenderTracker.getOrCreate(key,now);
  appenderTracker.endOfLife(key);
  now+=AppenderTracker.LINGERING_TIMEOUT + 1;
  appenderTracker.removeStaleComponents(now);
  assertFalse(a.isStarted());
  a=appenderTracker.find(key);
  assertNull(a);
}
