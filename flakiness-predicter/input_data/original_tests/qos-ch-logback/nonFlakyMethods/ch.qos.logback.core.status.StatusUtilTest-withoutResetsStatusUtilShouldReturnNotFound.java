@Test public void withoutResetsStatusUtilShouldReturnNotFound(){
  context.getStatusManager().add(new InfoStatus("test",this));
  assertEquals(-1,statusUtil.timeOfLastReset());
}
