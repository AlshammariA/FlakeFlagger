@Test public void smoke(){
  bsm.add(new ErrorStatus("hello",this));
  assertEquals(Status.ERROR,bsm.getLevel());
  List<Status> statusList=bsm.getCopyOfStatusList();
  assertNotNull(statusList);
  assertEquals(1,statusList.size());
  assertEquals("hello",statusList.get(0).getMessage());
}
