@Test public void commonObject(){
  Object o=new Object();
  assertTrue(NoAutoStartUtil.notMarkedWithNoAutoStart(o));
}
