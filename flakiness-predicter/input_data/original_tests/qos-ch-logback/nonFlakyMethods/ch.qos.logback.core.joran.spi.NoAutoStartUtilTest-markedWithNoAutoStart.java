@Test public void markedWithNoAutoStart(){
  DoNotAutoStart o=new DoNotAutoStart();
  assertFalse(NoAutoStartUtil.notMarkedWithNoAutoStart(o));
}
