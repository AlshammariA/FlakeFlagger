@Test public void trackerShouldHonorTimeoutParameter(){
  List<Appender<Object>> appenderList=new ArrayList<Appender<Object>>();
  int timeout=2;
  appenderTracker.setTimeout(timeout);
  for (int i=0; i <= timeout; i++) {
    Appender a=appenderTracker.getOrCreate(key + "-" + i,now++);
    appenderList.add(a);
  }
  long numComponentsCreated=timeout + 1;
  assertEquals(numComponentsCreated,appenderTracker.allKeys().size());
  appenderTracker.removeStaleComponents(now++);
  assertEquals(numComponentsCreated - 1,appenderTracker.allKeys().size());
  assertNull(appenderTracker.find(key + "-" + 0));
  assertFalse(appenderList.get(0).isStarted());
  for (int i=1; i <= timeout; i++) {
    assertNotNull(appenderTracker.find(key + "-" + i));
    assertTrue(appenderList.get(i).isStarted());
  }
}
