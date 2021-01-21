@Test public void smoke(){
  Appender<Object> a=appenderTracker.getOrCreate(key,now);
  assertTrue(a.isStarted());
  now+=AppenderTracker.DEFAULT_TIMEOUT + 1;
  appenderTracker.removeStaleComponents(now);
  assertFalse(a.isStarted());
  assertNull(appenderTracker.find(key));
}
